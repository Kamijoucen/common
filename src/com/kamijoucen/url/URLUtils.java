package com.kamijoucen.url;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class URLUtils {


    public static String conversionUrlParam(Map<String, String> prop, boolean isinner) {
        if (prop == null || prop.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        if (isinner) {
            builder.append("?");
        }
        Set<Map.Entry<String, String>> entries = prop.entrySet();
        final int loopSize = entries.size() - 1;
        Iterator<Map.Entry<String, String>> iter = entries.iterator();
        for (int i = 0; i < loopSize; ++i) {
            Map.Entry<String, String> entry = iter.next();
            builder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        Map.Entry<String, String> entry = iter.next();
        builder.append(entry.getKey()).append("=").append(entry.getValue());
        return builder.toString();
    }


    /**
     * 将map数据转换成url参数
     * @param prop
     * @return
     */
    public static String conversionUrlParam(Map<String, String> prop) {
        return conversionUrlParam(prop, true);
    }

//    /**
//     * 判断是否ajax请求
//     *
//     * @param request
//     * @return
//     */
//    public static boolean isAjax(HttpServletRequest request) {
//        boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
//        String ajaxFlag = null == request.getParameter("ajax") ? "false" : request.getParameter("ajax");
//        return ajax || ajaxFlag.equalsIgnoreCase("true");
//    }


    public static String getLocalHost() {
        String localHost = null;
        try {
            InetAddress address = InetAddress.getLocalHost();
            localHost = address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return localHost;
    }
}
