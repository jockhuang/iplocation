/**
 * Specl.com Inc.
 * Copyright (c) 2010-2011 All Rights Reserved.
 */
package com.hjide.iplocation;

/**
 * 
 * @author zhaobin
 */
public class IPLocation {
    
    private String country;
    private String area;
    
    public IPLocation() {
        country = area = "";
    }
    
    public IPLocation getCopy() {
        IPLocation ret = new IPLocation();
        ret.country = country;
        ret.area = area;
        return ret;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        if(area.trim().equals("CZ88.NET")){
            this.area="全国";
        }else{
            this.area = area;
        }
    }
}

