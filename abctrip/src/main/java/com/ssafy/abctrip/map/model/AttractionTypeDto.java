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
@Schema(title = "AttractionTypeDto : 관광지", description = "관광지 코드를 나타낸다.")
public class AttractionTypeDto {

	@Schema(description = "관광지 코드")
	private String contentId;
	@Schema(description = "관광지 이름")
	private String contentName;
	
}
