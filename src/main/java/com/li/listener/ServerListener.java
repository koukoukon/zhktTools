package com.li.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class ServerListener implements ServletContextListener {
    public static Map<String, String> map = null;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        map = new HashMap<>();
        map.put("fuLingLing","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSlc2a1Q2ODZjdWN4MU5jbktRakI2dW9PcFFCbjY5a0ZOcXBZbERQMVVHN3c9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSjMzM0ROTXVINHlGMXVpRUNOWW5GVzVvTG9leFFjTVBpRGtGTGVuWEVXd3c9PQ==");
        map.put("zhangJinDing","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSnBLSmJIbXBOc2ZBOXQxN2svUG1RazlSSTJRN2hZbDdHeXhNM3l0Q3Zycnc9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSUVQQUxZeHIrYkdGV1dQUzBXVDlMSE1kRHYwR2ZiUkdWZDIwYXVYWXZ1aFE9PQ==");
        map.put("caoSaiLe","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSS9uUmhtRG9NSmZCaGFiZndUWjdSalRKaGY0MzQ2bFVHSWNEcTlQenBNQkE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMS1JHUjFkSWcvQTN1RTZuMW1nUjBoQldNWjAxMzRCVnUxM0RZb3ZSNDBSR3c9PQ==");
        map.put("xvShiWei","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSlRRdytxTVBvYVlpcTF0MmNHNDRnSEdqR1VEbG4zTWs5OHdzcUY4Y1k4eVE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSUI3bmx6MHBVL3BsWnRNeTlKeDNFTjVtcG8va2RDSXB4QU02K3N0QXd5RFE9PQ==");
        map.put("wangYong","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMS2pCdVgrZzZnYmtORG9EM294UDNiT1lPY1hSeDMyY0NPWEtHbnNKVlN0VEE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMTFU1ZTdXeUJ5d2pySUJla1JXM1lHT2tucnZCTmRuSnJmeWNaMEtSK0JmL1E9PQ==");
        map.put("yangFan","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSVRTM2l3QW1GRGtoVFZ2M2VUaFdxVXdmU1JxVnpaUDVQcERrNHRVUEJkVEE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSmNieGZPdEd4T3BZbkRNWmZNQWUyWkMxalpnTXIvZlF6bTcvd1V0dGcvT2c9PQ==");
        map.put("wangJun","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSUZCOXFkVnF0T0FzRCs1U1dhdHU1UHlaRURCZGk3dHZZbDJrb1JjMll3M1E9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSU1VQ0dEbE1IY04wendsV2E2bmtuYVhGbk5HaWhpbzBYcXpPdlBmU2U5VXc9PQ==");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}
