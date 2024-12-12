package com.ssafy.abctrip.board.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(title = "BoardDto : 게시글정보", description = "게시글의 상세 정보를 나타낸다.")
public class BoardDto {

	@Schema(description = "글번호")
	private int freePostId;
	@Schema(description = "글제목")
	private String freeTitle;
	@Schema(description = "글내용")
	private String freeContent;
	@Schema(description = "조회수")
	private int freeViews;
	@Schema(description = "작성일")	
	private String createdAt;
	@Schema(description = "수정일")	
	private String updatedAt;
	@Schema(description = "작성자 아이디")
	private String userId;
	@Schema(description = "작성자 닉네임")
	private String nickName;

}
