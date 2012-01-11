/**
 * Specl.com Inc.
 * Copyright (c) 2010-2011 All Rights Reserved.
 */
package com.hjide.iplocation;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

/**
 * 
 * @author zhaobin
 */
public class IPLocationUtil {
    
    public static Logger logger = Logger.getLogger(IPLocationUtil.class);
    
    public static Map<String,String> provinceMap  = new HashMap<String,String>();
    static{
        provinceMap.put("北京","北京");
        provinceMap.put("天津","天津");
        provinceMap.put("河北","河北");
        provinceMap.put("山东","山东");
        provinceMap.put("山西","山西");
        provinceMap.put("河南","河南");
        provinceMap.put("湖北","湖北");
        provinceMap.put("辽宁","辽宁");
        provinceMap.put("吉林","吉林");
        provinceMap.put("黑龙","黑龙江");
        provinceMap.put("内蒙","内蒙古");
        provinceMap.put("上海","上海");
        provinceMap.put("江苏","江苏");
        provinceMap.put("浙江","浙江");
        provinceMap.put("安徽","安徽");
        provinceMap.put("广东","广东");
        provinceMap.put("广西","广西");
        provinceMap.put("福建","福建");
        provinceMap.put("湖南","湖南");
        provinceMap.put("江西","江西");
        provinceMap.put("海南","海南");
        provinceMap.put("台湾","台湾");
        provinceMap.put("香港","香港");
        provinceMap.put("澳门","澳门");
        provinceMap.put("四川","四川");
        provinceMap.put("重庆","重庆");
        provinceMap.put("陕西","陕西");
        provinceMap.put("贵州","贵州");
        provinceMap.put("云南","云南");
        provinceMap.put("西藏","西藏");
        provinceMap.put("甘肃","甘肃");
        provinceMap.put("青海","青海");
        provinceMap.put("宁夏","宁夏");
        provinceMap.put("新疆","新疆");
    }
    
    /**
     * 将Classpath下文件转为Byte数组
     * @param fileName
     * @return
     */
    public static byte[] getByteArrayFromClasspathFile(String fileName){
        InputStream inputStream = ClassLoaderUtil.getResourceAsStream(fileName, IPLocationUtil.class);
        byte[] array = getByteArrayFromInputStream(inputStream);
        try {
            inputStream.close();
        } catch (IOException e) {
            logger.error("关闭InputStream错误", e);
        }
        return array;
    }
    
    /**
     * 将InputStream转换为Byte数组
     * @param inputStream
     * @return
     */
    public static byte[] getByteArrayFromInputStream(InputStream inputStream){
        byte[] array = null;
        try {
            array = new byte[inputStream.available()];
            inputStream.read(array, 0, array.length);
        } catch (IOException e) {
            logger.error("将InputStream转换为Byte数组错误", e);
        }
        return array;
    }
    
    /**
     * 从ip的字符串形式得到字节数组形式
     * @param ip 字符串形式的ip
     * @return 字节数组形式的ip
     */
    public static byte[] getIpByteArrayFromString(String ip) {
        byte[] ret = new byte[4];
        StringTokenizer st = new StringTokenizer(ip, ".");
        try {
            ret[0] = (byte)(Integer.parseInt(st.nextToken()) & 0xFF);
            ret[1] = (byte)(Integer.parseInt(st.nextToken()) & 0xFF);
            ret[2] = (byte)(Integer.parseInt(st.nextToken()) & 0xFF);
            ret[3] = (byte)(Integer.parseInt(st.nextToken()) & 0xFF);
        } catch (Exception e) {
            logger.error("从ip的字符串形式得到字节数组形式报错"+e.toString());
        }
        return ret;
    }
 
    /**
     * 根据某种编码方式将字节数组转换成字符串
     * @param b 字节数组
     * @param offset 要转换的起始位置
     * @param len 要转换的长度
     * @param encoding 编码方式
     * @return 如果encoding不支持，返回一个缺省编码的字符串
     */
    public static String getString(byte[] b, int offset, int len, String encoding) {
        try {
            return new String(b, offset, len, encoding);
        } catch (UnsupportedEncodingException e) {
            return new String(b, offset, len);
        }
    }
}

