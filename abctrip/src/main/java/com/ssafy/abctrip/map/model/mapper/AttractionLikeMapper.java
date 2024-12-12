package com.ssafy.abctrip.map.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AttractionLikeMapper {
	
	// 좋아요 추가
	void insertLike(@Param("contentId") String contentId, @Param("userId") String userId);

	// 좋아요 삭제
	void deleteLike(@Param("contentId") String contentId, @Param("userId") String userId);

	// 좋아요 수 증가
	void increaseLikeCount(@Param("contentId") String contentId);

	// 좋아요 수 감소
	void decreaseLikeCount(@Param("contentId") String contentId);

	// 전체 좋아요 수 조회
	int getLikeCount(@Param("contentId") String contentId);

	// 사용자의 좋아요 여부 확인
	boolean hasUserLiked(@Param("contentId") String contentId, @Param("userId") String userId);
}
