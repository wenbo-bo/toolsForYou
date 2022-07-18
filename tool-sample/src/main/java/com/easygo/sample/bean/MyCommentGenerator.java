package com.easygo.sample.bean;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @Author wenbo
 * @Date 2021/12/6 10:41
 **/
public class MyCommentGenerator extends PluginAdapter  {


    private Properties properties;

    public MyCommentGenerator() {
        properties = new Properties();
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties.putAll(properties);
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

//    @Override
//    public void addConfigurationProperties(Properties properties) {
//        // 获取自定义的 properties
//        this.properties.putAll(properties);
//    }

//    @Override
//    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        String author = properties.getProperty("author");
//        String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
//        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
//        String tableName = introspectedTable.getTableConfiguration().getTableName();
//        // 获取表注释
//        String remarks = introspectedTable.getRemarks();
//
//        topLevelClass.addJavaDocLine("/**");
//        topLevelClass.addJavaDocLine(" * " + remarks);
//        topLevelClass.addJavaDocLine(" *");
//        topLevelClass.addJavaDocLine(" * @author " + author);
//        topLevelClass.addJavaDocLine(" * @date " + dateFormatter.format(new Date()));
//        topLevelClass.addJavaDocLine(" */");
//        topLevelClass.addAnnotation("@Data");
//        topLevelClass.addAnnotation("@Accessors(chain = true)");
//        topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = false)");
//        topLevelClass.addAnnotation("@ApiModel(value ="+"\""+tableName+"\","+"description="+"\""+remarks+"\""+")");
//        topLevelClass.addImportedType("io.swagger.annotations.ApiModelProperty");
//        topLevelClass.addImportedType("lombok.Data");
//        topLevelClass.addImportedType("lombok.experimental.Accessors");
//        topLevelClass.addImportedType("lombok.EqualsAndHashCode");
//        topLevelClass.addImportedType("io.swagger.annotations.ApiModel");
//    }

//    @Override
//    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
//        // 获取列注释
//        introspectedColumn.getJdbcTypeName();
//        String remarks = introspectedColumn.getRemarks();
//        field.addAnnotation("@ApiModelProperty("+"\""+remarks+"\""+")");
//    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String author = properties.getProperty("author");
        String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
        String tableName = introspectedTable.getTableConfiguration().getTableName();
        // 获取表注释
        String remarks = introspectedTable.getRemarks();

        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * " + remarks);
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * @author " + author);
        topLevelClass.addJavaDocLine(" * @date " + dateFormatter.format(new Date()));
        topLevelClass.addJavaDocLine(" */");
        Field field = new Field();
        field.setFinal(true);
        field.setInitializationString("1L"); //$NON-NLS-1$
        field.setName("serialVersionUID"); //$NON-NLS-1$
        field.setStatic(true);
        field.setType(new FullyQualifiedJavaType("long")); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PRIVATE);
        topLevelClass.addField(field);
        topLevelClass.addSuperInterface(new FullyQualifiedJavaType("Serializable"));
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addAnnotation("@Accessors(chain = true)");
        topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = false)");
        topLevelClass.addAnnotation("@ApiModel(value ="+"\""+tableName+"\","+"description="+"\""+remarks+"\""+")");
        topLevelClass.addImportedType("java.io.Serializable");
        topLevelClass.addImportedType("io.swagger.annotations.ApiModelProperty");
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addImportedType("lombok.experimental.Accessors");
        topLevelClass.addImportedType("lombok.EqualsAndHashCode");
        topLevelClass.addImportedType("io.swagger.annotations.ApiModel");
        return true;
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 获取列注释
        introspectedColumn.getJdbcTypeName();
        String remarks = introspectedColumn.getRemarks();
        field.addAnnotation("@ApiModelProperty("+"\""+remarks+"\""+")");
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return true;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }




}
