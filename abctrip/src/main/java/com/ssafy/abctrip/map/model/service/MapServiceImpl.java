package com.ssafy.abctrip.map.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.abctrip.map.model.AttractionTypeDto;
import com.ssafy.abctrip.map.model.GugunCodeDto;
import com.ssafy.abctrip.map.model.SidoCodeDto;
import com.ssafy.abctrip.map.model.mapper.MapMapper;

@Service
public class MapServiceImpl implements MapService {
	
	private final MapMapper mapMapper;

	public MapServiceImpl(MapMapper mapMapper) {
		super();
		this.mapMapper = mapMapper;
	}

	@Override
	public List<SidoCodeDto> getSido() throws Exception {
		return mapMapper.getSido();
	}

	@Override
	public List<GugunCodeDto> getGugunInSido(String sido) throws Exception {
		return mapMapper.getGugunInSido(sido);
	}

	@Override
	public List<AttractionTypeDto> getAttractionType() throws Exception {
		return mapMapper.getAttractionType();
	}

}
