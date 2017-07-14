package com.newtouch.fbf.dao;

import com.newtouch.fbf.entity.Productmenu;
import com.newtouch.fbf.entity.ProductmenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductmenuMapper {
    int countByExample(ProductmenuExample example);

    int deleteByExample(ProductmenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(Productmenu record);

    int insertSelective(Productmenu record);

    List<Productmenu> selectByExample(ProductmenuExample example);

    Productmenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Productmenu record, @Param("example") ProductmenuExample example);

    int updateByExample(@Param("record") Productmenu record, @Param("example") ProductmenuExample example);

    int updateByPrimaryKeySelective(Productmenu record);

    int updateByPrimaryKey(Productmenu record);
}