/**
 * Specl.com Inc.
 * Copyright (c) 2010-2011 All Rights Reserved.
 */
package com.hjide.iplocation;

import org.apache.log4j.Logger;

/**
 * 
 * @author zhaobin
 */
public class IPByteArray {
    
    Logger logger = Logger.getLogger(IPByteArray.class);
    
    private byte[] byteArray;
    
    public IPByteArray( byte[] byteArray ){
        this.byteArray = byteArray;
    }
    
    public void read( int position, byte[] bytes ){
        int p = position;
        for( int i=0; i<bytes.length; i++ ){
            bytes[i] = read(p);
            p++;
        }
    }
    
    public byte read(int position){
        return byteArray[position];
    }
    
    
}
