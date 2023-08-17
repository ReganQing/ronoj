package com.ron.ronoj.service;

import com.ron.ronoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.ron.ronoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ron.ronoj.model.entity.User;

/**
* @author Ron_567
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2023-08-16 15:22:04
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 提交
     *
     * @param questionSubmitAddRequest 题目提交信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);
}

