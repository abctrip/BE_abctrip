package com.ssafy.abctrip.comment.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.abctrip.comment.model.CommentDto;

@Mapper
public interface CommentMapper {
	
	void writeComment (CommentDto commentDto) throws SQLException;
	
	List<CommentDto> getComments(int articleNo) throws SQLException;
	
	void modifyComment (CommentDto commentDto) throws SQLException;
	
	void deleteComment(int commentNo) throws SQLException;
}
