package com.ssafy.abctrip.map.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.abctrip.map.model.AttractionTypeDto;
import com.ssafy.abctrip.map.model.GugunCodeDto;
import com.ssafy.abctrip.map.model.SidoCodeDto;
import com.ssafy.abctrip.map.model.service.MapService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/map")
@Tag(name = "시도 구군 컨트롤러", description = "시도 구군정보를 처리하는 클래스.")
@Slf4j
public class MapController {
	
	private final MapService mapService;

	public MapController(MapService mapService) {
		super();
		this.mapService = mapService;
	}

	@Operation(summary = "시도 정보", description = "전국의 시도를 반환한다.")
	@GetMapping("/sido")
	public ResponseEntity<List<SidoCodeDto>> sido() throws Exception {
		log.info("sido - 호출");
		return new ResponseEntity<List<SidoCodeDto>>(mapService.getSido(), HttpStatus.OK);
	}

	@Operation(summary = "구군 정보", description = "시도에 속한 구군을 반환한다.")
	@GetMapping("/gugun/{sido}")
	public ResponseEntity<List<GugunCodeDto>> gugun(@PathVariable String sido) throws Exception {
		log.info("gugun - 호출");
		System.out.println("sido : " + sido);
		return new ResponseEntity<List<GugunCodeDto>>(mapService.getGugunInSido(sido), HttpStatus.OK);
	}
	
	@Operation(summary = "관광지 타입 정보", description = "관광지 타입 정보를 반환한다.")
	@GetMapping("/attraction-type")
	public ResponseEntity<List<AttractionTypeDto>> attractionType() throws Exception {
	   log.info("attractionType - 호출");
	   return new ResponseEntity<List<AttractionTypeDto>>(mapService.getAttractionType(), HttpStatus.OK);
	}
	
}
