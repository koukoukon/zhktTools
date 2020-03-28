package com.li.httpclient;

import com.li.utils.Tools;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SendHttpRequest {

    static Object o = new Object();

    public Map<String,String> queryUserInfo(String sess) throws Exception {

        CloseableHttpClient client = HttpClients.createDefault();
        String[] str = {"yhmc","yhlx"};
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < 2; i ++) {


            List<NameValuePair> nmList = new ArrayList<>();
            nmList.add(new BasicNameValuePair("commandType","get_session_value"));
            nmList.add(new BasicNameValuePair("cssl","1"));
            nmList.add(new BasicNameValuePair("cslist",str[i]));
            nmList.add(new BasicNameValuePair("zfj","%E4%B8%AD"));
            nmList.add(new BasicNameValuePair("time", Tools.getTime()));

            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nmList, "utf-8");
            urlEncodedFormEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

            String url = "http://zhkt.zmdvtc.cn/zhjx/servlet/ServletCzy";
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(new BasicHeader("Cookie",sess));
            httpPost.setEntity(urlEncodedFormEntity);

            HttpResponse response = client.execute(httpPost);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String s = EntityUtils.toString(entity, "UTF-8");
                Document doc = DocumentHelper.parseText(s);
                Element rootElement = doc.getRootElement();
                List<Element> rList = rootElement.elements("r");

                map.put(str[i],rList.get(0).getText());
            }

        }
        client.close();
        return map;
    }

    public void signIn(String ac, String sess) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();
        String url1 = "http://zhkt.zmdvtc.cn/zhjx/servlet/ServletXskq?commandType=zb_getList&cssl=6&cslist=1&cslist=1&cslist=_kqzb.id,-kongge-_kqmx.id,-kongge-_kqzb.qdfs&cslist=-jinhao-DQXQ-jinhao--kongge-$a-n-d$-kongge-_kqmx.qdsj-kongge-is-kongge-null-kongge-$a-n-d$-kongge-_kqmx.id_xs=-danyinhao_en-" + ac + "-danyinhao_en--kongge-$a-n-d$-kongge-_kqzb.zt=-danyinhao_en--jinhao-ZT_JXZ-jinhao--danyinhao_en-&cslist=_kqzb.id-kongge-desc&cslist=&time=" + Tools.time() + "&zfj=%D6%D0";

        HttpPost getBhPost = new HttpPost(url1);

        getBhPost.addHeader(new BasicHeader("User-Agent","mozilla/5.0 (linux; u; android 4.1.2; zh-cn; mi-one plus build/jzo54k) applewebkit/534.30 (khtml, like gecko) version/4.0 mobile safari/534.30 micromessenger/5.0.1.352"));
        getBhPost.addHeader(new BasicHeader("Cookie",sess));
        getBhPost.addHeader(new BasicHeader("Referer","http://zhkt.zmdvtc.cn/zhjx/pages/weixin/shouye_xs.jsp?cslist=backpage=/zhjx/pages/weixin/kthd_xs/dmInfo_wx.jsp"));

        HttpResponse response = client.execute(getBhPost);
        HttpEntity en = response.getEntity();
        String string = EntityUtils.toString(en, "UTF-8");
        client.close();
        if (response.getStatusLine().getStatusCode() == 200) {

            Tools tools = new Tools();
            String[] bhL = tools.bhL(string);

            if (bhL[0] == null || bhL[0] == "") {
                Tools.logs(Tools.KQQDZS, Tools.getTime() + "---进入签到---响应实体：" + string + "---SESS:" + sess + "\n\n");
//                    System.out.println("没有签到活动--:" + string + "--" + sess);
            }else {
                Tools.logs(Tools.JRQD, Tools.getTime() + "---进入签到---响应实体：" + string + "---SESS:" + sess + "\n\n");
//                System.out.println("---进入签到---响应实体：" + string + "---SESS---:" + sess + "\n");

                sign(bhL[0],bhL[1],sess);

            }

        } else {
            Tools.logs(Tools.JRQD, Tools.getTime() + "---进入签到时连接不通---响应实体：" + string + "---SESS:" + sess + "\n\n");
//            System.out.println("---进入签到时连接不通---响应实体：" + string + "---SESS:" + sess + "\n");
        }
    }

    private void sign(String cbh, String dbh, String sess) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        String url2 = "http://zhkt.zmdvtc.cn/zhjx/servlet/ServletXskq?commandType=wx_xsqd&cssl=4&cslist=" + cbh + "&cslist=" + dbh + "&cslist=&cslist=%C6%D5%CD%A8&time=" + Tools.time() + "&zfj=%D6%D0";

        HttpPost httpPost = new HttpPost(url2);
        httpPost.addHeader(new BasicHeader("User-Agent","mozilla/5.0 (linux; u; android 4.1.2; zh-cn; mi-one plus build/jzo54k) applewebkit/534.30 (khtml, like gecko) version/4.0 mobile safari/534.30 micromessenger/5.0.1.352"));
        httpPost.addHeader(new BasicHeader("Cookie",sess));
        httpPost.addHeader(new BasicHeader("Referer","http://zhkt.zmdvtc.cn/zhjx/pages/weixin/kthd_xs/dmInfo_wx.jsp?cslist=backpage=/zhjx/pages/weixin/shouye_xs.jsp;kqzbid=" + dbh + ";kqmxid=" + cbh + ";qdfs=%E6%99%AE%E9%80%9A"));

        HttpResponse response = client.execute(httpPost);
        HttpEntity en = response.getEntity();
        String string = EntityUtils.toString(en, "utf-8");

        client.close();
        if (response.getStatusLine().getStatusCode() == 200) {

            Document doc = DocumentHelper.parseText(string);
            Element rootElement = doc.getRootElement();
            Element result = rootElement.element("result");
            if ("1".equals(result.getText()) || "1" == result.getText() || Integer.valueOf(result.getText()) == 1) {
                Tools.logs(Tools.ZZQD,  Tools.getTime() + "---签到成功---响应实体：" + string + "---SESS---" + sess + "\n");
//                System.out.println("签到成功");
            } else {
                Tools.logs(Tools.ZZQD,  Tools.getTime() + "---签到失败---响应实体：" + string + "---SESS---" + sess + "\n");
//                System.out.println("签到失败");
            }

        }else {
            Tools.logs(Tools.ZZQD, Tools.getTime() + "---签到时连接不通---响应实体：" + string + "---SESS:" + sess + "\n\n");
//            System.out.println("---签到时连接不通---响应实体：" + string + "---SESS---:" + sess + "\n");
        }
    }

    public Map<String, String> getKtList(String sess, String stuNumb) throws Exception{

        CloseableHttpClient client = HttpClients.createDefault();
        String url2 = "http://zhkt.zmdvtc.cn/zhjx/servlet/ServletKt";

        ArrayList<NameValuePair> formList = new ArrayList<>();
        formList.add(new BasicNameValuePair("commandType", "wx_getKtList"));
        formList.add(new BasicNameValuePair("cssl", "6"));
        formList.add(new BasicNameValuePair("cslist", "1"));
        formList.add(new BasicNameValuePair("cslist", "1000"));
        formList.add(new BasicNameValuePair("cslist", "_a.id,_a.kcmc,_a.bjms,-danyinhao_en--danyinhao_en-"));
        formList.add(new BasicNameValuePair("cslist", "exists-kongge-(%E5%BD%93%E5%89%8D%E5%AD%A6%E7%94%9F%E8%AF%BE%E5%A0%82=-danyinhao_en-" + stuNumb + "-danyinhao_en-)-kongge-$a-n-d$-kongge-_a.sfxs=-danyinhao_en-%E6%98%AF-danyinhao_en-"));
        formList.add(new BasicNameValuePair("cslist", "_a.kcmc,_a.bjms"));
        formList.add(new BasicNameValuePair("cslist", "ZHJX_J_KT_ZB"));
        formList.add(new BasicNameValuePair("zfj", "%E4%B8%AD"));
        formList.add(new BasicNameValuePair("time", Tools.time()));
        UrlEncodedFormEntity rqeEntity = new UrlEncodedFormEntity(formList, "utf-8");
        rqeEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

        HttpPost httpPost = new HttpPost(url2);
        httpPost.addHeader(new BasicHeader("Cookie",sess));
        httpPost.setEntity(rqeEntity);
        HttpResponse response = client.execute(httpPost);
        HttpEntity en = response.getEntity();
        String string = EntityUtils.toString(en, "utf-8");

        client.close();

        Tools tools = new Tools();
        Map<String, String> stringStringMap = tools.parserKtBh(string);

        return stringStringMap;
    }

    public Map<String, String> getZyList(String sess, String ktBh) throws Exception{

        CloseableHttpClient client = HttpClients.createDefault();
        String url2 = "http://zhkt.zmdvtc.cn/zhjx/servlet/ServletKtzy";

        ArrayList<NameValuePair> formList = new ArrayList<>();
        formList.add(new BasicNameValuePair("commandType", "zy_getZyList"));
        formList.add(new BasicNameValuePair("cssl", "5"));
        formList.add(new BasicNameValuePair("cslist", "1"));
        formList.add(new BasicNameValuePair("cslist", "5000"));
        formList.add(new BasicNameValuePair("cslist", "_zyzb.ID,_zyzb.BT,-zuokuohao--jinhao-Z-jinhao-Y-jinhao-N-jinhao-R-jinhao--youkuohao-,_zyzb.LX,-zuokuohao--jinhao-S-jinhao-F-jinhao-Z-jinhao-H-jinhao--youkuohao-,-zuokuohao--jinhao-S-jinhao-F-jinhao-L-jinhao-L-jinhao--youkuohao-"));
        formList.add(new BasicNameValuePair("cslist", "_zyzb.id_kt=-danyinhao_en-" + ktBh + "-danyinhao_en--kongge-$a-n-d$-kongge-_zyzb.zt=-danyinhao_en-%E5%B7%B2%E5%8F%91%E5%B8%83-danyinhao_en-"));
        formList.add(new BasicNameValuePair("cslist", "_zyzb.fbsj-kongge-desc,_zyzb.id"));
        formList.add(new BasicNameValuePair("zfj", "%E4%B8%AD"));
        formList.add(new BasicNameValuePair("time", Tools.time()));
        UrlEncodedFormEntity rqeEntity = new UrlEncodedFormEntity(formList, "utf-8");
        rqeEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

        HttpPost httpPost = new HttpPost(url2);
        httpPost.addHeader(new BasicHeader("Cookie",sess));
        httpPost.setEntity(rqeEntity);
        HttpResponse response = client.execute(httpPost);
        HttpEntity en = response.getEntity();
        String string = EntityUtils.toString(en, "utf-8");
        client.close();
//        System.out.println(string);
        Tools tools = new Tools();
        Map<String, String> map = tools.parserZyBh(string);
        return map;
    }

    public void browseZyRequest(String sess, String zyBh) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();

        ArrayList<NameValuePair> formList = new ArrayList<>();
        formList.add(new BasicNameValuePair("commandType", "zy_setLl"));
        formList.add(new BasicNameValuePair("cssl", "1"));
        formList.add(new BasicNameValuePair("cslist", zyBh));
        formList.add(new BasicNameValuePair("zfj", "%E4%B8%AD"));
        formList.add(new BasicNameValuePair("time", Tools.time()));

        UrlEncodedFormEntity rqeEntity = new UrlEncodedFormEntity(formList, "utf-8");
        rqeEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

        HttpPost post = new HttpPost("http://zhkt.zmdvtc.cn/zhjx/servlet/ServletKtzy");
        post.addHeader(new BasicHeader("Cookie", sess));
        post.setHeader("Connection", "keep-alive");
        post.setEntity(rqeEntity);
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        String mes = EntityUtils.toString(entity, "utf-8");
//        System.out.println(mes);
        client.close();
    }


}
