package com.li.service;


import java.util.Map;

public interface BrowseResourcesService {

    Map<String,String> getZyInfo(String sess, String ktBh) throws Exception;

    void browseZy(String sess, String zyBh) throws Exception;

}
