package com.ssafy.abctrip.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.abctrip.comment.model.CommentDto;
import com.ssafy.abctrip.comment.model.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
	
	private final CommentMapper commentMapper;
	
	public CommentServiceImpl(CommentMapper commentMapper) {
		super();
		this.commentMapper = commentMapper;
	}

	@Override
	public void writeComment(CommentDto commentDto) throws Exception {
		commentMapper.writeComment(commentDto);
	}

	@Override
	public List<CommentDto> getComments(int articleNo) throws Exception {
		// TODO Auto-generated method stub
		return commentMapper.getComments(articleNo);
	}

	@Override
	public void modifyComment(CommentDto commentDto) throws Exception {
		commentMapper.modifyComment(commentDto);
	}

	@Override
	public void deleteComment(int commentNo) throws Exception {
		commentMapper.deleteComment(commentNo);
	}
}
