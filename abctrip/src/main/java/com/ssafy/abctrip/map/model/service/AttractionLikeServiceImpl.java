package com.ssafy.abctrip.map.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.abctrip.map.model.mapper.AttractionLikeMapper;

@Service
public class AttractionLikeServiceImpl implements AttractionLikeService {

	private AttractionLikeMapper attractionLikeMapper;

	public AttractionLikeServiceImpl(AttractionLikeMapper attracionLikeMapper) {
		this.attractionLikeMapper = attracionLikeMapper;
	}

	@Override
	@Transactional
	public boolean toggleLike(String contentId, String userId) {
		// 이미 좋아요 했는지 확인
		boolean alreadyLiked = attractionLikeMapper.hasUserLiked(contentId, userId);

		if (alreadyLiked) {
			// 좋아요 취소
			attractionLikeMapper.deleteLike(contentId, userId);
			// 전체 좋아요 수 감소
			attractionLikeMapper.decreaseLikeCount(contentId);
			return false;
		} else {
			// 좋아요 추가
			attractionLikeMapper.insertLike(contentId, userId);
			// 전체 좋아요 수 증가
			attractionLikeMapper.increaseLikeCount(contentId);
			return true;
		}
	}

	@Override
	public int getLikeCount(String contentId) {
		return attractionLikeMapper.getLikeCount(contentId);
	}

	@Override
	public boolean hasUserLiked(String contentId, String userId) {
		return attractionLikeMapper.hasUserLiked(contentId, userId);
	}
}
