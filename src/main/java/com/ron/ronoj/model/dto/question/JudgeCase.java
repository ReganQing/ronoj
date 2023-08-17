package com.ron.ronoj.model.dto.question;

import lombok.Data;

/**
 * 判断用例
 */
@Data
public class JudgeCase {

    /**
     * 输入用例
     */
    private String input;

    /**
     * 输出用例
     */
    private String output;
}
