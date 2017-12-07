package com.baoshu.dao.mapper;

import com.baoshu.dao.model.TransLog;
import com.baoshu.dao.model.TransLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransLogMapper {
    long countByExample(TransLogExample example);

    int deleteByExample(TransLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TransLog record);

    int insertSelective(TransLog record);

    List<TransLog> selectByExample(TransLogExample example);

    TransLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TransLog record, @Param("example") TransLogExample example);

    int updateByExample(@Param("record") TransLog record, @Param("example") TransLogExample example);

    int updateByPrimaryKeySelective(TransLog record);

    int updateByPrimaryKey(TransLog record);
}