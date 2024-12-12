package com.ssafy.abctrip.comment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.abctrip.board.model.BoardDto;
import com.ssafy.abctrip.comment.model.CommentDto;
import com.ssafy.abctrip.comment.service.CommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/comment")
@Tag(name = "댓글 컨트롤러", description = "댓글 등록, 수정, 삭제 등 전반적인 처리를 하는 클래스.")
@Slf4j
public class CommentController {

	private final CommentService commentService;

	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	@Operation(summary = "댓글 작성", description = "새로운 댓글 정보를 입력한다.")
	@PostMapping
	public ResponseEntity<?> writeComment(
			@RequestBody @Parameter(description = "댓글 정보.", required = true) CommentDto commentDto) {
		log.info("writeComment commentDto - {}", commentDto);
		try {
			commentService.writeComment(commentDto);
//			return ResponseEntity.ok().build();
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@Operation(summary = "댓글 수정", description = "댓글 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.")
	@PutMapping
	public ResponseEntity<String> modifyComment(
			@RequestBody @Parameter(description = "수정할 댓글정보.", required = true) CommentDto commentDto) throws Exception {
		log.info("modifyComments- 호출 {}", commentDto);
		commentService.modifyComment(commentDto);
		return ResponseEntity.ok().build();
	}
	
	@Operation(summary = "게시판 댓글보기", description = "글번호에 해당하는 게시글의 정보를 반환한다.")
	@GetMapping("/{articleno}")
	public ResponseEntity<List<CommentDto>> getComments(
			@PathVariable("articleno") @Parameter(name = "articleno", description = "댓글들을 얻어올 글의 글번호.", required = true) int articleno)
			throws Exception {
		log.info("getComments - 호출 글번호 : " + articleno);
		return new ResponseEntity<List<CommentDto>>(commentService.getComments(articleno), HttpStatus.OK);
	}

	@Operation(summary = "댓글 삭제", description = "댓글번호에 해당하는 댓글 삭제. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.")
	@DeleteMapping("/{commentNo}")
	public ResponseEntity<String> deleteComment(
			@PathVariable("commentNo") @Parameter(name = "commentNo", description = "살제할 댓글번호.", required = true) int commentNo)
			throws Exception {
		log.info("deleteComment - 호출" + commentNo);
		commentService.deleteComment(commentNo);
		return ResponseEntity.ok().build();
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
