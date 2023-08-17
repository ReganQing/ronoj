package com.ron.ronoj.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ron.ronoj.model.dto.post.PostQueryRequest;
import com.ron.ronoj.model.entity.Post;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 题目服务测试
 *
 * @author ron
 * 
 */
@SpringBootTest
class PostServiceTest {

    @Resource
    private PostService postService;

    @Test
    void searchFromEs() {
        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setUserId(1L);
        Page<Post> postPage = postService.searchFromEs(postQueryRequest);
        Assertions.assertNotNull(postPage);
    }

}