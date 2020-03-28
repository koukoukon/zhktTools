package com.li.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.bean.Userz;
import com.li.httpclient.SendHttpRequest;
import com.li.mapper.UserzMapper;
import com.li.service.UserzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Scope
@Transactional
public class UserzServiceImpl extends ServiceImpl<UserzMapper, Userz> implements UserzService {

    @Autowired
    UserzMapper userzMapper;

    @Autowired
    SendHttpRequest instance;

    @Override
    public Userz selectUser(String account) {
        return userzMapper.selectOne(new QueryWrapper<Userz>().eq("account", account));
    }

    @Override
    public int addUser(Userz userz) {
        return userzMapper.insert(userz);
    }

    @Override
    public int updateUser(Userz userz, Integer id) {
        return userzMapper.update(userz, new QueryWrapper<Userz>().eq("id", id));
    }

    @Override
    public List<Userz> selectOpenedUserSess() {
        return userzMapper.selectList(new QueryWrapper<Userz>().select("account", "password", "z_sess").eq("auto_sign",1));
    }

    @Override
    public int getCount() {
        return userzMapper.getCount();
    }

    @Override
    public Map<String,String> getKtList(String sess, String stuNumb) throws Exception {
        Map<String, String> ktList = instance.getKtList(sess, stuNumb);
        return ktList;
    }
}
