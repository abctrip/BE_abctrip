package com.ssafy.abctrip.statistics.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.abctrip.statistics.model.StatisticsDto;

@Mapper
public interface StatisticsMapper {

	// 상위 5개의 좋아요를 불러오는 mapper 호출
	 List<StatisticsDto> getHotplaceRank() throws SQLException;
}
