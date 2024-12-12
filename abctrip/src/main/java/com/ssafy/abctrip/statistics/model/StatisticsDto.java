package com.ssafy.abctrip.statistics.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(title = "StatisticsDto : 통계 정보", description = "통계 정보들을 받아온다.")
public class StatisticsDto {
	
	@Schema(description = "관광지명")
	private String attractionTitle;
	@Schema(description = "좋아요 숫자")
	private int attractionLikeCount;
}
