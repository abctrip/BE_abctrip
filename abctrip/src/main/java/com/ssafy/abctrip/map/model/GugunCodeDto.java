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
@Schema(title = "GugunCodeDto : 구군정보", description = "구군의 이름을 나타낸다.")
public class GugunCodeDto {

	@Schema(description = "구군코드")
	private String gugunCode;
	@Schema(description = "구군이름")
	private String gugunName;
	
}
