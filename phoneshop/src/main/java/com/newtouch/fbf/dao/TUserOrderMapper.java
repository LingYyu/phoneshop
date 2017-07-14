package com.newtouch.fbf.dao;

import com.newtouch.fbf.entity.TUserOrder;
import com.newtouch.fbf.entity.TUserOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserOrderMapper {
    int countByExample(TUserOrderExample example);

    int deleteByExample(TUserOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(TUserOrder record);

    int insertSelective(TUserOrder record);

    List<TUserOrder> selectByExample(TUserOrderExample example);

    TUserOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TUserOrder record, @Param("example") TUserOrderExample example);

    int updateByExample(@Param("record") TUserOrder record, @Param("example") TUserOrderExample example);

    int updateByPrimaryKeySelective(TUserOrder record);

    int updateByPrimaryKey(TUserOrder record);
}