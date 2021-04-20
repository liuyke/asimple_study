package com.liuyk.asimple.dao;

import com.liuyk.asimple.entity.UriStatistic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UriStatisticDao {

    void batchAdd(@Param("index") int index, @Param("uriStatisticList") List<UriStatistic> uriStatisticList);

}
