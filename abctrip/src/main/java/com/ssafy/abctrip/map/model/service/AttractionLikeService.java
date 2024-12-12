package com.ssafy.abctrip.map.model.service;

public interface AttractionLikeService {

	boolean toggleLike(String contentId, String userId);

	int getLikeCount(String contentId);

	boolean hasUserLiked(String contentId, String userId);

}
