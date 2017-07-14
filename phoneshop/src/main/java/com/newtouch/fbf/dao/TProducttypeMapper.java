package com.newtouch.fbf.dao;

import com.newtouch.fbf.entity.TProducttype;
import com.newtouch.fbf.entity.TProducttypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProducttypeMapper {
    int countByExample(TProducttypeExample example);

    int deleteByExample(TProducttypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TProducttype record);

    int insertSelective(TProducttype record);

    List<TProducttype> selectByExample(TProducttypeExample example);

    TProducttype selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TProducttype record, @Param("example") TProducttypeExample example);

    int updateByExample(@Param("record") TProducttype record, @Param("example") TProducttypeExample example);

    int updateByPrimaryKeySelective(TProducttype record);

    int updateByPrimaryKey(TProducttype record);
}