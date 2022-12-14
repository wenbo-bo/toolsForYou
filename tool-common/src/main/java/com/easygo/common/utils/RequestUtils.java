//package com.easygo.common.utils;
//
//import lombok.experimental.UtilityClass;
//
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Objects;
//
///**
// * @Author wenbo
// * @Date 2021/12/6 10:14
// **/
//@UtilityClass
//public class RequestUtils {
//
//    public HttpServletRequest getRequest() {
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        if (Objects.isNull(requestAttributes)) {
//            return null;
//        } else {
//            return ((ServletRequestAttributes) requestAttributes).getRequest();
//        }
//    }
//
//    public String getParam(String str) {
//        return getRequest().getParameter(str);
//    }
//
//    public String getHeader(String head) {
//        HttpServletRequest request = getRequest();
//        if (null == request) {
//            return null;
//        }
//        return getRequest().getHeader(head);
//    }
//}
