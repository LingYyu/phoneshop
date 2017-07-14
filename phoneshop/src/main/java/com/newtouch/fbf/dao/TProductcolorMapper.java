package com.newtouch.fbf.dao;

import com.newtouch.fbf.entity.TProductcolor;
import com.newtouch.fbf.entity.TProductcolorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductcolorMapper {
    int countByExample(TProductcolorExample example);

    int deleteByExample(TProductcolorExample example);

    int deleteByPrimaryKey(String id);

    int insert(TProductcolor record);

    int insertSelective(TProductcolor record);

    List<TProductcolor> selectByExample(TProductcolorExample example);

    TProductcolor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TProductcolor record, @Param("example") TProductcolorExample example);

    int updateByExample(@Param("record") TProductcolor record, @Param("example") TProductcolorExample example);

    int updateByPrimaryKeySelective(TProductcolor record);

    int updateByPrimaryKey(TProductcolor record);
}