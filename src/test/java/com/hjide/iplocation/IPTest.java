package com.hjide.iplocation;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.hjide.iplocation.ClassLoaderUtil;
import com.hjide.iplocation.IPSeeker;

public class IPTest {
    private static int thread_num = 100;
    private static int client_num = 1000;
    
    
    public static void main(String[] args) {
        InputStream inputStream = ClassLoaderUtil.getResourceAsStream("qqwry.dat", IPTest.class);
        final Random random1 = new Random(10);
        final List<String> ipList = new ArrayList<String>();
        ipList.add("61.167.230.255");//黑龙江
        ipList.add("58.31.255.255");//北京
        ipList.add("113.57.222.97");//湖北
        ipList.add("60.24.139.255");//天津
        ipList.add("114.80.166.240");//上海
        
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(thread_num);
        for (int index = 0; index < client_num; index++) {
            final IPSeeker ipSeeker = IPSeeker.getInstance(inputStream);
            
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        semp.acquire();
                        String ip = ipList.get(Math.abs(random1.nextInt())%5);
                        String iplal = ipSeeker.getIPAdress(ip);
                        System.out.println("Thread:" + NO+" "+ip+" "+iplal);
                        semp.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            
            exec.execute(run);
        }
        exec.shutdown();
    }
    
}
