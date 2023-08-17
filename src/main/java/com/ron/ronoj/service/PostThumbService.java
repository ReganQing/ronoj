package com.ron.ronoj.service;

import com.ron.ronoj.model.entity.PostThumb;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ron.ronoj.model.entity.User;

/**
 * 题目点赞服务
 *
 * @author ron
 * 
 */
public interface PostThumbService extends IService<PostThumb> {

    /**
     * 点赞
     *
     * @param postId
     * @param loginUser
     * @return
     */
    int doPostThumb(long postId, User loginUser);

    /**
     * 题目点赞（内部服务）
     *
     * @param userId
     * @param postId
     * @return
     */
    int doPostThumbInner(long userId, long postId);
}
