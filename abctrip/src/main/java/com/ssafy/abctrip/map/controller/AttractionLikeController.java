package com.ssafy.abctrip.map.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.abctrip.map.model.service.AttractionLikeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

//@RestController
//@RequestMapping("/map/attraction")
//@Tag(name = "관광지 좋아요 컨트롤러", description = "관광지 좋아요 정보를 처리하는 클래스")
//@Slf4j
//public class AttractionLikeController {
//	
//	private final AttractionLikeService attractionLikeService;
//
//    public AttractionLikeController(AttractionLikeService attractionLikeService) {
//        this.attractionLikeService = attractionLikeService;
//    }
//
//    @Operation(summary = "좋아요 토글", description = "관광지 좋아요를 토글한다.")
//    @PostMapping("/{contentId}/like")
//    public ResponseEntity<Map<String, Object>> toggleLike(
//            @PathVariable String contentId,
//            @RequestParam String userId) throws Exception {
//        log.info("toggleLike - 호출 : contentId = {}, userId = {}", contentId, userId);
//        
//        System.out.println(123412314);
//        
//        boolean isLiked = attractionLikeService.toggleLike(contentId, userId);
//        int likeCount = attractionLikeService.getLikeCount(contentId);
//        
//        Map<String, Object> response = new HashMap<>();
//        response.put("isLiked", isLiked);
//        response.put("likeCount", likeCount);
//        
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//    
//    @Operation(summary = "좋아요 여부 확인", description = "사용자의 관광지 좋아요 여부를 확인한다.")
//    @GetMapping("/{contentId}/count")
//    public ResponseEntity<Boolean> hasUserLiked(
//            @PathVariable String contentId,
//            @RequestParam String userId) throws Exception {
//        log.info("hasUserLiked - 호출 : contentId = {}, userId = {}", contentId, userId);
//        return new ResponseEntity<>(attractionLikeService.hasUserLiked(contentId, userId), HttpStatus.OK);
//    }
//}


@RestController
@RequestMapping("/map/attraction")
@Tag(name = "관광지 좋아요 컨트롤러", description = "관광지 좋아요 정보를 처리하는 클래스")
@Slf4j
public class AttractionLikeController {
    
    private final AttractionLikeService attractionLikeService;

    public AttractionLikeController(AttractionLikeService attractionLikeService) {
        this.attractionLikeService = attractionLikeService;
    }

    @Operation(summary = "좋아요 토글", description = "관광지 좋아요를 토글한다.")
    @PostMapping("/{contentId}/like")
    public ResponseEntity<Map<String, Object>> toggleLike(
            @PathVariable String contentId,
            @RequestParam String userId) throws Exception {
        log.info("toggleLike - 호출 : contentId = {}, userId = {}", contentId, userId);
        
        boolean isLiked = attractionLikeService.toggleLike(contentId, userId);
        int likeCount = attractionLikeService.getLikeCount(contentId);
        
        Map<String, Object> response = new HashMap<>();
        response.put("isLiked", isLiked);
        response.put("likeCount", likeCount);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @Operation(summary = "좋아요 여부 확인", description = "사용자의 관광지 좋아요 여부를 확인한다.")
    @GetMapping("/{contentId}/like")
    public ResponseEntity<Boolean> hasUserLiked(
            @PathVariable String contentId,
            @RequestParam String userId) throws Exception {
        log.info("hasUserLiked - 호출 : contentId = {}, userId = {}", contentId, userId);
        return new ResponseEntity<>(attractionLikeService.hasUserLiked(contentId, userId), HttpStatus.OK);
    }

    @Operation(summary = "좋아요 수 조회", description = "관광지의 총 좋아요 수를 조회한다.")
    @GetMapping("/{contentId}/count")
    public ResponseEntity<Integer> getLikeCount(
            @PathVariable String contentId) throws Exception {
        log.info("getLikeCount - 호출 : contentId = {}", contentId);
        return new ResponseEntity<>(attractionLikeService.getLikeCount(contentId), HttpStatus.OK);
    }
}