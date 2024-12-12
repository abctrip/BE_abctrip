package com.ssafy.abctrip.comment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(title = "CommentDto : 댓글 정보", description = "댓글의 상세 정보를 나타낸다.")
public class CommentDto {
	
	@Schema(description = "댓글 ID")
	private int freeCommentId;
	@Schema(description = "댓글 내용")
	private String freeCommentContent;
	// 추후 추가
//	@Schema(description = "댓글 ID")
//	private int parentCommentId;
	@Schema(description = "댓글단 게시물 ID")
	private int freePostId;
	@Schema(description = "작성자 아이디")
	private String userId;
	@Schema(description = "작성자 닉네임")
	private String nickName;
	@Schema(description = "작성일")
	private String createdAt;
	@Schema(description = "수정일")
	private String updatedAt;

}
