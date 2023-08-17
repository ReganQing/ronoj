package com.ron.ronoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ron.ronoj.common.BaseResponse;
import com.ron.ronoj.common.ErrorCode;
import com.ron.ronoj.common.ResultUtils;
import com.ron.ronoj.exception.BusinessException;
import com.ron.ronoj.exception.ThrowUtils;
import com.ron.ronoj.model.dto.post.PostQueryRequest;
import com.ron.ronoj.model.dto.postfavour.PostFavourAddRequest;
import com.ron.ronoj.model.dto.postfavour.PostFavourQueryRequest;
import com.ron.ronoj.model.entity.Post;
import com.ron.ronoj.model.entity.User;
import com.ron.ronoj.model.vo.PostVO;
import com.ron.ronoj.service.PostFavourService;
import com.ron.ronoj.service.PostService;
import com.ron.ronoj.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 题目收藏接口
 *
 * @author ron
 * 
 */
@RestController
@RequestMapping("/post_favour")
@Slf4j
public class PostFavourController {

    @Resource
    private PostFavourService postFavourService;

    @Resource
    private PostService postService;

    @Resource
    private UserService userService;

    /**
     * 收藏 / 取消收藏
     *
     * @param postFavourAddRequest
     * @param request
     * @return resultNum 收藏变化数
     */
    @PostMapping("/")
    public BaseResponse<Integer> doPostFavour(@RequestBody PostFavourAddRequest postFavourAddRequest,
            HttpServletRequest request) {
        if (postFavourAddRequest == null || postFavourAddRequest.getPostId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能操作
        final User loginUser = userService.getLoginUser(request);
        long postId = postFavourAddRequest.getPostId();
        int result = postFavourService.doPostFavour(postId, loginUser);
        return ResultUtils.success(result);
    }

    /**
     * 获取我收藏的题目列表
     *
     * @param postQueryRequest
     * @param request
     */
    @PostMapping("/my/list/page")
    public BaseResponse<Page<PostVO>> listMyFavourPostByPage(@RequestBody PostQueryRequest postQueryRequest,
            HttpServletRequest request) {
        if (postQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User loginUser = userService.getLoginUser(request);
        long current = postQueryRequest.getCurrent();
        long size = postQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<Post> postPage = postFavourService.listFavourPostByPage(new Page<>(current, size),
                postService.getQueryWrapper(postQueryRequest), loginUser.getId());
        return ResultUtils.success(postService.getPostVOPage(postPage, request));
    }

    /**
     * 获取用户收藏的题目列表
     *
     * @param postFavourQueryRequest
     * @param request
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<PostVO>> listFavourPostByPage(@RequestBody PostFavourQueryRequest postFavourQueryRequest,
            HttpServletRequest request) {
        if (postFavourQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long current = postFavourQueryRequest.getCurrent();
        long size = postFavourQueryRequest.getPageSize();
        Long userId = postFavourQueryRequest.getUserId();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20 || userId == null, ErrorCode.PARAMS_ERROR);
        Page<Post> postPage = postFavourService.listFavourPostByPage(new Page<>(current, size),
                postService.getQueryWrapper(postFavourQueryRequest.getPostQueryRequest()), userId);
        return ResultUtils.success(postService.getPostVOPage(postPage, request));
    }
}
