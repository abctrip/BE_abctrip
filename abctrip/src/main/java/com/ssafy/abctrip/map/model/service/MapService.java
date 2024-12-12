package com.ssafy.abctrip.map.model.service;

import java.util.List;

import com.ssafy.abctrip.map.model.AttractionTypeDto;
import com.ssafy.abctrip.map.model.GugunCodeDto;
import com.ssafy.abctrip.map.model.SidoCodeDto;

public interface MapService {

	List<SidoCodeDto> getSido() throws Exception;
	List<GugunCodeDto> getGugunInSido(String sido) throws Exception;
	List<AttractionTypeDto> getAttractionType() throws Exception;
	
}
