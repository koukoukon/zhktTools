package com.li.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.bean.Userz;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface UserzService extends IService<Userz> {

    Userz selectUser(String account);

    int addUser(Userz userz);

    int updateUser(Userz userz, Integer id);

    List<Userz> selectOpenedUserSess();

    int getCount();

    Map<String, String> getKtList(String sess, String stuNumb) throws Exception;

}
