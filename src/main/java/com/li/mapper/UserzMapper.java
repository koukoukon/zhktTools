package com.li.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.bean.Userz;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserzMapper extends BaseMapper<Userz> {

    int getCount();

}


