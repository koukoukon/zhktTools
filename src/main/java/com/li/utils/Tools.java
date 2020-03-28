package com.li.utils;

import com.li.bean.Userz;
import com.li.service.UserzService;
import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tools {

    public static final int JRQD = 1;
    public static final int ZZQD = 2;
    public static final int KQQDZS = 3;
    public static final int GXSS = 4;

    public static String getTime () {
        return new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String time () {
        long time = new Date().getTime();
        return String.valueOf(time);
    }

    public static String flushSessTime () {
        return new SimpleDateFormat("HHmm").format(new Date());
    }

    public static void logs(int l, String str) {
        try{
                switch (l) {
                    case 1:
                        File jrqd = new File("c://log/JRQD.txt");
                        FileUtils.write(jrqd,str,"UTF-8",true);
                        break;
                    case 2:
                        File zzqd = new File("c://log/ZZQD.txt");
                        FileUtils.write(zzqd,str,"UTF-8",true);
                        break;
                    case 3:
                        File kqqdzsFile = new File("c://log/KQQDZS.txt");
                        FileUtils.write(kqqdzsFile,str,"UTF-8",false);
                        break;
                    case 4:
                        File gxssFile = new File("c://log/GXSS.txt");
                        FileUtils.write(gxssFile,str,"UTF-8",false);
                        break;
                }

        }catch (Exception e){

        }

    }

    public String[] bhL(String xml) throws DocumentException {

        String[] str = new String[2];
        Document doc = DocumentHelper.parseText(xml);
        Element rootElement = doc.getRootElement();
        List<Element> rList = rootElement.elements("r");
        int flag = Integer.parseInt(rList.get(2).getText());
        rList.remove(0);
        rList.remove(0);
        rList.remove(0);

        if (flag != 0) {
            str[0] = rList.get(1).getText();
            str[1] = rList.get(0).getText();
        } else {
            str[0] = null;
            str[1] = null;
        }


        return str;
    }

    public Map<String, String> parserKtBh(String xml) throws Exception{
        if (xml != null) {

            Document doc = DocumentHelper.parseText(xml);
            Element rootElement = doc.getRootElement();
            List<Element> rList = rootElement.elements("r");
            int partition = Integer.parseInt(rList.get(2).getText());
            rList.remove(0);
            rList.remove(0);
            rList.remove(0);
            Map<String, String> ktMap = new HashMap<>();
            for (int i = 0; i < rList.size();){
                ktMap.put(rList.get(i+1).getText(), rList.get(i).getText());
                i += partition;
            }
            return ktMap;

        } else {
            return null;
        }
    }

    public Map<String, String> parserZyBh(String xml) throws Exception{
        if (xml != null){
            Document doc = DocumentHelper.parseText(xml);
            Element rootElement = doc.getRootElement();
            List<Element> rList = rootElement.elements("r");
            int partitionFlag = Integer.parseInt(rList.get(2).getText());
            rList.remove(0);
            rList.remove(0);
            rList.remove(0);

            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < rList.size();) {
                map.put((rList.get(i).getText()),(rList.get(i+5).getText()).equals("-")?"否":(rList.get(i+5).getText()));
                i += partitionFlag;
            }
            return map;
        }
        return null;
    }

}
