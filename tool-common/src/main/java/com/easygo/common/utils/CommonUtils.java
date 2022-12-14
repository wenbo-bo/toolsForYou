package com.easygo.common.utils;




public class CommonUtils {


    /**
     * 判断文件名是否带盘符，重新处理
     *
     * @param fileName
     * @return
     */
    public static String getFileName(String fileName) {
        //判断是否带有盘符信息
        // Check for Unix-style path
        int unixSep = fileName.lastIndexOf('/');
        // Check for Windows-style path
        int winSep = fileName.lastIndexOf('\\');
        // Cut off at latest possible point
        int pos = (winSep > unixSep ? winSep : unixSep);
        if (pos != -1) {
            // Any sort of path separator found...
            fileName = fileName.substring(pos + 1);
        }
        //替换上传文件名字的特殊字符
        fileName = fileName.replace("=", "").replace(",", "").replace("&", "");
        return fileName;
    }

    /**
     * 年龄重写
     *
     * @param ageY
     * @param ageM
     * @param ageD
     * @return
     */
    public static String ageOverWrite(String ageY, Integer ageM, Integer ageD) {
        String aa = ageY == null ? "0" : ageY;
        int ageYear = Integer.valueOf(aa);
        int ageMonth = ageM == null ? 0 : ageM;
        int ageDay = ageD == null ? 0 : ageD;
        int age = 0;
        if (ageYear != 0) {
            age = ageYear;
            return age + "岁";
        } else if (ageMonth != 0 && ageMonth <= 12) {
            age = ageMonth;
            return age + "个月";
        } else if (ageDay == 0) {
            age = 1;
            return age + "天";
        } else {
            age = ageDay;
            return age + "天";
        }

    }



    /**
     * redis的key键规则定义
     *
     * @param prefix 项目前缀
     * @param module 模块名称
     * @param func   方法名称
     * @param args   参数..
     * @return key
     */
    public static String keyBuilder(String module, String func, String... args) {
        StringBuilder key = new StringBuilder();
        // KEY_SPLIT_CHAR 为分割字符
        key.append(":").append(module);
        if (StringUtil.isNotEmpty(func)) {
            key.append(":").append(func);
        }
        for (String arg : args) {
            key.append(":").append(arg);
        }
        return key.toString();
    }
}
