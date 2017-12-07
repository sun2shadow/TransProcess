package com.baoshu.dao.mapper;

import com.baoshu.dao.model.QueryLog;
import com.baoshu.dao.model.QueryLogExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface QueryLogMapper {
    long countByExample(QueryLogExample example);

    int deleteByExample(QueryLogExample example);

    int deleteByPrimaryKey(String ordersNo);

    int insert(QueryLog record);

    int insertSelective(QueryLog record);

    List<QueryLog> selectByExample(QueryLogExample example);

    QueryLog selectByPrimaryKey(String ordersNo);

    int updateByExampleSelective(@Param("record") QueryLog record, @Param("example") QueryLogExample example);

    int updateByExample(@Param("record") QueryLog record, @Param("example") QueryLogExample example);

    int updateByPrimaryKeySelective(QueryLog record);

    int updateByPrimaryKey(QueryLog record);
    
    Map<String, Object> totalMoneyAndAmount(String ordersNo);
}