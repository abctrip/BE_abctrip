package com.ssafy.abctrip.map.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(title = "관광지 좋아요 정보", description = "관광지의 좋아요 관련 정보를 포함한 DTO")
public class AttractionLikeDto {
   
   @Schema(description = "각 관광지 코드")
   private String contentId;
   
   @Schema(description = "좋아요를 누른 사용자 ID")
   private String userId;
   
   @Schema(description = "관광지의 총 좋아요 수")
   private int likeCount;
}