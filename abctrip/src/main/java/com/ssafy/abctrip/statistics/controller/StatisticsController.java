package com.ssafy.abctrip.statistics.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.abctrip.statistics.model.StatisticsDto;
import com.ssafy.abctrip.statistics.model.service.StatisticsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/statistics")
@Tag(name = "통계", description = "통계 부분 처리하는 클래스.")
@Slf4j
public class StatisticsController {
	
	private final StatisticsService statisticsService;

	public StatisticsController(StatisticsService statisticsService) {
		super();
		this.statisticsService = statisticsService;
	}
	
	@Operation(summary = "상위 5개 좋아요 장소 들고오기", description = "상위 5개 좋아요 장소 들고오기")
	@GetMapping
	public ResponseEntity<List<StatisticsDto>> getHotplaceRank() throws Exception {
		return new ResponseEntity<List<StatisticsDto>>(statisticsService.getHotplaceRank(), HttpStatus.OK);
	}
}
