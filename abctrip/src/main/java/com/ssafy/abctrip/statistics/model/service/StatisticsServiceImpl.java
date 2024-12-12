package com.ssafy.abctrip.statistics.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.abctrip.statistics.model.StatisticsDto;
import com.ssafy.abctrip.statistics.model.mapper.StatisticsMapper;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	
private final StatisticsMapper statisticsMapper;
	
	public StatisticsServiceImpl(StatisticsMapper statisticsMapper) {
		super();
		this.statisticsMapper = statisticsMapper;
	}

	// 상위 5개의 좋아요를 불러오는 logic
	@Override
	public List<StatisticsDto> getHotplaceRank() throws SQLException {
		return statisticsMapper.getHotplaceRank();
	}

}
