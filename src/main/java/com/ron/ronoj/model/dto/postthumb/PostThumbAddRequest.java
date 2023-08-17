package com.ron.ronoj.model.dto.postthumb;

import java.io.Serializable;
import lombok.Data;

/**
 * 题目点赞请求
 *
 * @author ron
 * 
 */
@Data
public class PostThumbAddRequest implements Serializable {

    /**
     * 题目 id
     */
    private Long postId;

    private static final long serialVersionUID = 1L;
}