package com.ssafy.abctrip.comment.service;

import java.util.List;

import com.ssafy.abctrip.comment.model.CommentDto;

public interface CommentService {

	// 뎃글 작성하기
	void writeComment(CommentDto commentDto) throws Exception;
	
	// 게시물 댓글 불러오기
	List<CommentDto> getComments(int commentNo) throws Exception;
	
	// 댓글 수정하기
	void modifyComment(CommentDto commentDto) throws Exception;
	
	// 댓글 삭제하기
	void deleteComment(int commentNo) throws Exception;
	
}
