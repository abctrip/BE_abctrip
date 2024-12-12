package com.ssafy.abctrip.map.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.abctrip.map.model.AttractionTypeDto;
import com.ssafy.abctrip.map.model.GugunCodeDto;
import com.ssafy.abctrip.map.model.SidoCodeDto;

@Mapper
public interface MapMapper {

	List<SidoCodeDto> getSido() throws SQLException;
	List<GugunCodeDto> getGugunInSido(String sido) throws SQLException;
	List<AttractionTypeDto> getAttractionType() throws SQLException;
	
}
