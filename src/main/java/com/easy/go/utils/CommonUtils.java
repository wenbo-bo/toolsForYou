package com.easy.go.utils;

import org.apache.commons.lang3.StringUtils;


public class CommonUtils {

//    public static String uploadOnlineImage(byte[] data,String basePath,String bizPath,String uploadType){
//        String dbPath = null;
//        String fileName = "image" + Math.round(Math.random() * 100000000000L);
//        fileName += "." + PoiPublicUtil.getFileExtendName(data);
//        try {
//            if(CommonConstant.UPLOAD_TYPE_LOCAL.equals(uploadType)){
//                File file = new File(basePath + File.separator + bizPath + File.separator );
//                if (!file.exists()) {
//                    file.mkdirs();// 创建文件根目录
//                }
//                String savePath = file.getPath() + File.separator + fileName;
//                File savefile = new File(savePath);
//                FileCopyUtils.copy(data, savefile);
//                dbPath = bizPath + File.separator + fileName;
//            }else {
//                InputStream in = new ByteArrayInputStream(data);
//                String relativePath = bizPath+"/"+fileName;
//                if(CommonConstant.UPLOAD_TYPE_MINIO.equals(uploadType)){
//                    dbPath = MinioUtil.upload(in,relativePath);
//                }else if(CommonConstant.UPLOAD_TYPE_OSS.equals(uploadType)){
//                    dbPath = OssBootUtil.upload(in,relativePath);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dbPath;
//    }

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
//
//    public static String age(Date beginDate, Date endDate){
//        if (null == beginDate){
//            return "0天";
//        }
//        Long lo = DateUtil.betweenYear(beginDate,endDate,false);
//        Long lo2 = DateUtil.betweenMonth(beginDate,endDate,false);
//        Long lo3 = DateUtil.betweenDay(beginDate,endDate,false);
//        return ageOverWrite(String.valueOf(lo),lo2.intValue(),lo3.intValue());
//    }
//    /**
//     * redis的key键规则定义
//     *
//     * @param module 模块名称
//     * @param func   方法名称
//     * @param args   参数..
//     * @return key
//     */
//    public static String keyBuilder(String module, String func, String... args) {
//        return keyBuilder(module, func, args);
//    }


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
        if (StringUtils.isNotBlank(func)) {
            key.append(":").append(func);
        }
        for (String arg : args) {
            key.append(":").append(arg);
        }
        return key.toString();
    }
}
