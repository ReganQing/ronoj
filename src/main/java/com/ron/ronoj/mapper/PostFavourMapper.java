package com.ron.ronoj.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ron.ronoj.model.entity.Post;
import com.ron.ronoj.model.entity.PostFavour;
import org.apache.ibatis.annotations.Param;

/**
 * 题目收藏数据库操作
 *
 * @author ron
 * 
 */
public interface PostFavourMapper extends BaseMapper<PostFavour> {

    /**
     * 分页查询收藏题目列表
     *
     * @param page
     * @param queryWrapper
     * @param favourUserId
     * @return
     */
    Page<Post> listFavourPostByPage(IPage<Post> page, @Param(Constants.WRAPPER) Wrapper<Post> queryWrapper,
            long favourUserId);

}




