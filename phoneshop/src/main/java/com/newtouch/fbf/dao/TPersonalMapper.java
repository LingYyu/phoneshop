package com.newtouch.fbf.dao;

import com.newtouch.fbf.entity.TPersonal;
import com.newtouch.fbf.entity.TPersonalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPersonalMapper {
    int countByExample(TPersonalExample example);

    int deleteByExample(TPersonalExample example);

    int deleteByPrimaryKey(String id);

    int insert(TPersonal record);

    int insertSelective(TPersonal record);

    List<TPersonal> selectByExample(TPersonalExample example);

    TPersonal selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TPersonal record, @Param("example") TPersonalExample example);

    int updateByExample(@Param("record") TPersonal record, @Param("example") TPersonalExample example);

    int updateByPrimaryKeySelective(TPersonal record);

    int updateByPrimaryKey(TPersonal record);
}