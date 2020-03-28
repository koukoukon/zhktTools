package com.li.serviceImpl;

import com.li.httpclient.SendHttpRequest;
import com.li.service.BrowseResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Scope
public class BrowseResourcesServiceImpl implements BrowseResourcesService {

    @Autowired
    SendHttpRequest sendHttpRequest;

    @Override
    public Map<String, String> getZyInfo(String sess, String ktBh) throws Exception {
        return sendHttpRequest.getZyList(sess, ktBh);
    }

    @Override
    public void browseZy(String sess, String zyBh) throws Exception {
        sendHttpRequest.browseZyRequest(sess, zyBh);
    }
}
