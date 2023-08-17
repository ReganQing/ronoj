package com.ron.ronoj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ron.ronoj.common.ErrorCode;
import com.ron.ronoj.exception.BusinessException;
import com.ron.ronoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.ron.ronoj.model.entity.Question;
import com.ron.ronoj.model.entity.QuestionSubmit;
import com.ron.ronoj.model.entity.QuestionSubmit;
import com.ron.ronoj.model.entity.User;
import com.ron.ronoj.model.enums.QuestionSubmitLanguageEnum;
import com.ron.ronoj.model.enums.QuestionSubmitStatusEnum;
import com.ron.ronoj.service.QuestionService;
import com.ron.ronoj.service.QuestionSubmitService;
import com.ron.ronoj.service.QuestionSubmitService;
import com.ron.ronoj.mapper.QuestionSubmitMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author Ron_567
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
* @createDate 2023-08-16 15:22:04
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService {
    @Resource
    private QuestionService questionService;

    /**
     * 提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        // 校验编程语言是否合法
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if (languageEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "编程语言错误");
        }
        long questionId = questionSubmitAddRequest.getQuestionId();
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已提交
        long userId = loginUser.getId();
        // 每个用户串行提交
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(language);
        // 设置初始状态
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITTING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据插入失败");
        }
        return questionSubmit.getId();
    }
}