package com.newtouch.fbf.dao;

import com.newtouch.fbf.entity.TUserAddress;
import com.newtouch.fbf.entity.TUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserAddressMapper {
    int countByExample(TUserAddressExample example);

    int deleteByExample(TUserAddressExample example);

    int deleteByPrimaryKey(String id);

    int insert(TUserAddress record);

    int insertSelective(TUserAddress record);

    List<TUserAddress> selectByExample(TUserAddressExample example);

    TUserAddress selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TUserAddress record, @Param("example") TUserAddressExample example);

    int updateByExample(@Param("record") TUserAddress record, @Param("example") TUserAddressExample example);

    int updateByPrimaryKeySelective(TUserAddress record);

    int updateByPrimaryKey(TUserAddress record);
}