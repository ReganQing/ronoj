package com.ron.ronoj.model.dto.postfavour;

import java.io.Serializable;
import lombok.Data;

/**
 * 题目收藏 / 取消收藏请求
 *
 * @author ron
 * 
 */
@Data
public class PostFavourAddRequest implements Serializable {

    /**
     * 题目 id
     */
    private Long postId;

    private static final long serialVersionUID = 1L;
}