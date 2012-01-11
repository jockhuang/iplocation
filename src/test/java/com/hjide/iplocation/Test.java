/**
 * Specl.com Inc.
 * Copyright (c) 2010-2011 All Rights Reserved.
 */
package com.hjide.iplocation;

import java.io.InputStream;

import com.hjide.iplocation.ClassLoaderUtil;
import com.hjide.iplocation.IPLocation;
import com.hjide.iplocation.IPSeeker;

/**
 * 
 * @author zhaobin
 */
public class Test {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        String ip = "1.193.126.116";
        InputStream inputStream = ClassLoaderUtil.getResourceAsStream("qqwry.dat", IPTest.class);
        IPSeeker ipSeeker = IPSeeker.getInstance(inputStream);
        IPLocation iplal = ipSeeker.getIPLocation(ip);
        System.out.println(ip+" "+iplal.getCountry()+":"+iplal.getArea());
        System.out.println(ipSeeker.getIPAdress(ip));
    }

}
