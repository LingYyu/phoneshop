package com.newtouch.fbf.dao;

import com.newtouch.fbf.entity.TCart;
import com.newtouch.fbf.entity.TCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCartMapper {
    int countByExample(TCartExample example);

    int deleteByExample(TCartExample example);

    int deleteByPrimaryKey(String id);

    int insert(TCart record);

    int insertSelective(TCart record);

    List<TCart> selectByExample(TCartExample example);

    TCart selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TCart record, @Param("example") TCartExample example);

    int updateByExample(@Param("record") TCart record, @Param("example") TCartExample example);

    int updateByPrimaryKeySelective(TCart record);

    int updateByPrimaryKey(TCart record);
}