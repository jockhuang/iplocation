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

