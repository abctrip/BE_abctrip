package com.ssafy.abctrip.statistics.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.abctrip.statistics.model.StatisticsDto;

public interface StatisticsService {

	// 상위 5개의 좋아요를 불러오는 logic
	 List<StatisticsDto> getHotplaceRank() throws SQLException;
	 
}
