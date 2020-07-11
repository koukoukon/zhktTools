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
        map.put("fuLingLing","ASP.NET_SessionId=1snugl4kbdzu1tcfxsliosny; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSlFMeEFmcDd5ei93c1NHeHQ1Uk9tTisyQ0xpcnErSUZwU2crbkszY0hDd2c9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMTCtvek45aU5SMnNUOXB1OHVsS1VhWVdEVm9PdDIrYml4Q3BzV1RhdDRjUlE9PQ==");
        map.put("zhangJinDing","ASP.NET_SessionId=gwflygtne3lxqm5ocylyig1h; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSi9UeDNUR3dCOW53Y21sVVNCNHRiS3VjYktCREpRbE1GOWUxQVh1OTJjOFE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSXltejEwRjZyWUpmNHA0b0xOc1doMU01dGs1SUc0eEFNdzdwZUxsTHlvOXc9PQ==");
        map.put("caoSaiLe","ASP.NET_SessionId=1snugl4kbdzu1tcfxsliosny; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSnBJMEhMT1JueENjbXluOFFQYXZXcjNCSUt2ZWx1Z1Y1MURxa0I4bFRQbnc9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSTJ6R2VlUUtIaW9QTVFIWkdjVUgvakNBMmx0RmVldi85Ym1jTjFXY2tPVlE9PQ==");
        map.put("xvShiWei","ASP.NET_SessionId=1snugl4kbdzu1tcfxsliosny; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSWRvYkRGaElrbjJyMmJodlFZVU9NZ0Q3ZXZkNWV3Sk1rR3I0MFZWbk9wdEE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSWptcXBOYzlCbnBTdlRtT0M3clNZbW9rcUdwRk5hSHFXRmRScEx5RTVMdEE9PQ==");
        map.put("wangYong","ASP.NET_SessionId=cuzue2yl0rrfz5rw3jljfccw; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMS3djTUYxNkRBczh5aTE4cTVpR2ZON0cwajNqZmVzeXVNQVo4OUY3Mk85bVE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMS1NqSjNoZjZhcjlEOTROWE1FckhxQlY4WmxZUG5aV2t1cWdVUVdUYnp0SWc9PQ==");
        map.put("yangFan","ASP.NET_SessionId=1snugl4kbdzu1tcfxsliosny; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSUUvOWNRMHYyd21sNTVjb0VmRm1Kc0pkOERTMVlqcXVERS90N0VIdElnbUE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSW45ZFV2UzdRcVJPN2w1SVAwSmdWMi9IUTRib3lMRGtuZUpCU0JFQ3lZS0E9PQ==");
        map.put("wangJun","ASP.NET_SessionId=1snugl4kbdzu1tcfxsliosny; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMTGhaSHI1SVRGY2xpS0h5K01rbXhqY0JzVE1UZXo3T25YbFd2ekRCYTdYSEE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSlc2UGRLV3AzMCsxMVNkRHJocHZvcDcyeURuRXE2WTdLRFpSTm1qTUJtUkE9PQ==");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}
