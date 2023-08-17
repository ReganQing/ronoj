package com.ron.ronoj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ron.ronoj.model.entity.Post;
import java.util.Date;
import java.util.List;

/**
 * 题目数据库操作
 *
 * @author ron
 * 
 */
public interface PostMapper extends BaseMapper<Post> {

    /**
     * 查询题目列表（包括已被删除的数据）
     */
    List<Post> listPostWithDelete(Date minUpdateTime);

}




