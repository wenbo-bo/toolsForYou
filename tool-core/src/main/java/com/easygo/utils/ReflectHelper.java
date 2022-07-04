package com.easygo.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * @author 张代浩
 * @desc 通过反射来动态调用get 和 set 方法
 */
@Slf4j
public class ReflectHelper {

    private Class cls;

    /**
     * 传过来的对象
     */
    private Object obj;

    /**
     * 存放get方法
     */
    private Hashtable<String, Method> getMethods = null;
    /**
     * 存放set方法
     */
    private Hashtable<String, Method> setMethods = null;

    /**
     * 定义构造方法 -- 一般来说是个pojo
     *
     * @param o 目标对象
     */
    public ReflectHelper(Object o) {
        obj = o;
        initMethods();
    }

    /**
     * @desc 初始化
     */
    public void initMethods() {
        getMethods = new Hashtable<String, Method>();
        setMethods = new Hashtable<String, Method>();
        cls = obj.getClass();
        Method[] methods = cls.getMethods();
        // 定义正则表达式，从方法中过滤出getter / setter 函数.
        String gs = "get(\\w+)";
        Pattern getM = Pattern.compile(gs);
        String ss = "set(\\w+)";
        Pattern setM = Pattern.compile(ss);
        // 把方法中的"set" 或者 "get" 去掉
        String rapl = "$1";
        String param;
        for (int i = 0; i < methods.length; ++i) {
            Method m = methods[i];
            String methodName = m.getName();
            if (Pattern.matches(gs, methodName)) {
                param = getM.matcher(methodName).replaceAll(rapl).toLowerCase();
                getMethods.put(param, m);
            } else if (Pattern.matches(ss, methodName)) {
                param = setM.matcher(methodName).replaceAll(rapl).toLowerCase();
                setMethods.put(param, m);
            } else {
                // logger.info(methodName + " 不是getter,setter方法！");
            }
        }
    }

    /**
     * @desc 调用set方法
     */
    public boolean setMethodValue(String property, Object object) {
        Method m = setMethods.get(property.toLowerCase());
        if (m != null) {
            try {
                // 调用目标类的setter函数
                m.invoke(obj, object);
                return true;
            } catch (Exception ex) {
                log.info("invoke getter on " + property + " error: " + ex.toString());
                return false;
            }
        }
        return false;
    }

    /**
     * @desc 调用set方法
     */
    public Object getMethodValue(String property) {
        Object value = null;
        Method m = getMethods.get(property.toLowerCase());
        if (m != null) {
            try {
                /*
                 * 调用obj类的setter函数
                 */
                value = m.invoke(obj, new Object[]{});

            } catch (Exception ex) {
                log.info("invoke getter on " + property + " error: " + ex.toString());
            }
        }
        return value;
    }

    /**
     * 把map中的内容全部注入到obj中
     *
     * @param data
     * @return
     */
    public Object setAll(Map<String, Object> data) {
        if (data == null || data.keySet().size() <= 0) {
            return null;
        }
        for (Entry<String, Object> entry : data.entrySet()) {
            this.setMethodValue(entry.getKey(), entry.getValue());
        }
        return obj;
    }

    /**
     * 把map中的内容全部注入到obj中
     *
     * @param o
     * @param data
     * @return
     */
    public static Object setAll(Object o, Map<String, Object> data) {
        ReflectHelper reflectHelper = new ReflectHelper(o);
        reflectHelper.setAll(data);
        return o;
    }

    /**
     * 把map中的内容全部注入到新实例中
     *
     * @param clazz
     * @param data
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T setAll(Class<T> clazz, Map<String, Object> data) {
        T o = null;
        try {
            o = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            o = null;
            return o;
        }
        return (T) setAll(o, data);
    }

    /**
     * 根据传入的class将mapList转换为实体类list
     *
     * @param mapist
     * @param clazz
     * @return
     */
    public static <T> List<T> transList2Entrys(List<Map<String, Object>> mapist, Class<T> clazz) {
        List<T> list = new ArrayList<T>();
        if (mapist != null && mapist.size() > 0) {
            for (Map<String, Object> data : mapist) {
                list.add(ReflectHelper.setAll(clazz, data));
            }
        }
        return list;
    }

    /**
     * 根据属性名获取属性值
     */
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取属性名数组
     */
    public static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            //log.info(fields[i].getType());
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

    /**
     * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
     */
    public static List<Map> getFiledsInfo(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        List<Map> list = new ArrayList<Map>();
        Map<String, Object> infoMap = null;
        for (int i = 0; i < fields.length; i++) {
            infoMap = new HashMap<String, Object>();
            infoMap.put("type", fields[i].getType().toString());
            infoMap.put("name", fields[i].getName());
            infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
            list.add(infoMap);
        }
        return list;
    }

    /**
     * 获取对象的所有属性值，返回一个对象数组
     */
    public static Object[] getFiledValues(Object o) {
        String[] fieldNames = getFiledName(o);
        Object[] value = new Object[fieldNames.length];
        for (int i = 0; i < fieldNames.length; i++) {
            value[i] = getFieldValueByName(fieldNames[i], o);
        }
        return value;
    }

    public static <T> T mapToObject(Map<String, Object> map, Class<T> beanClass) throws Exception {
        if (map == null) {
            return null;
        }
        T object = beanClass.newInstance();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isFinal(mod) || Modifier.isStatic(mod)) {
                continue;
            }
            field.setAccessible(true);

            field.set(object, map.get(field.getName()));
        }
        return object;
    }


    /**
     * 直接读取对象属性值, 无视private/protected修饰符, 不经过getter函数.
     */
    @SuppressWarnings("unchecked")
    public static <E> E getFieldValue(final Object obj, final String fieldName) {
        Field field = getAccessibleField(obj, fieldName);
        if (field == null) {
            log.debug("在 [" + obj.getClass() + "] 中，没有找到 [" + fieldName + "] 字段 ");
            return null;
        }
        E result = null;
        try {
            result = (E) field.get(obj);
        } catch (IllegalAccessException e) {
            log.error("不可能抛出的异常{}", e.getMessage());
        }
        return result;
    }

    /**
     * 循环向上转型, 获取对象的DeclaredField, 并强制设置为可访问.
     * 如向上转型到Object仍无法找到, 返回null.
     */
    public static Field getAccessibleField(final Object obj, final String fieldName) {
        // 为空不报错。直接返回 null
        if (obj == null) {
            return null;
        }
        Validate.notBlank(fieldName, "fieldName can't be blank");
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Field field = superClass.getDeclaredField(fieldName);
                makeAccessible(field);
                return field;
            } catch (NoSuchFieldException e) {
                continue;
            }
        }
        return null;
    }


    /**
     * 改变private/protected的成员变量为public，尽量不调用实际改动的语句，避免JDK的SecurityManager抱怨。
     */
    public static void makeAccessible(Field field) {
        if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())
                || Modifier.isFinal(field.getModifiers())) && !field.isAccessible()) {
            field.setAccessible(true);
        }
    }

    /**
     * 获取类的所有属性，包括父类
     *
     * @param object
     * @return
     */
    public static Field[] getAllFields(Object object) {
        Class<?> clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        if (("HashMap").equals(clazz.getSimpleName()) || "LinkedHashMap".equals(clazz.getSimpleName()) || object.toString().startsWith("data:image/jpg")) {
            return fieldList.toArray(new Field[0]);
        }
        while (clazz != null) {
            if (("JSONObject").equals(clazz.getSimpleName())) {
                break;
            }
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();

        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    public static JSONObject item(Object record) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{}";
        try {
            //解决@JsonFormat注解解析不了的问题详见SysAnnouncement类的@JsonFormat
            json = mapper.writeValueAsString(record);
        } catch (JsonProcessingException e) {
            log.error("json解析失败" + e.getMessage(), e);
        }

        JSONObject item = null;
        try {
            item = JSONObject.parseObject(json);
        } catch (Exception e) {
            log.info("字典json解析错误 忽略:{}", e.getMessage());
            log.info("json:{}", json);
        }
        return item;
    }

    public static List getList(Object object, String name) {
        Class<?> clazz = object.getClass();
        List list = null;
        Field[] fields = clazz.getDeclaredFields();
        fields = Arrays.stream(fields).filter(m -> m.getName().equals(name)).toArray(Field[]::new);
        if (clazz != null) {
            try {
                String fieldName = fields[0].getName();
                PropertyDescriptor descriptor = new PropertyDescriptor(fieldName, clazz);
                Method method = descriptor.getReadMethod();
                list = (List) method.invoke(object);
                if (name.equals(fieldName)) {
                    return list;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    public static Object getObject(Object object, String name) {
        Class<?> clazz = object.getClass();
        Object o = null;
        Field[] fields = clazz.getDeclaredFields();
        fields = Arrays.stream(fields).filter(m -> m.getName().equals(name)).toArray(Field[]::new);
        if (clazz != null) {
            try {
                String fieldName = fields[0].getName();
                PropertyDescriptor descriptor = new PropertyDescriptor(fieldName, clazz);
                Method method = descriptor.getReadMethod();
                o = method.invoke(object);
                if (name.equals(fieldName)) {
                    return o;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return o;
    }
}
