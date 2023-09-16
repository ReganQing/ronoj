package com.ron.ronoj.judge;

import com.ron.ronoj.model.entity.QuestionSubmit;

/**
 * 判题服务
 * @author Ron_567
 */
public interface JudgeService {
    /**
     * 判题
     * @param questionSubmitId 题目提交Id
     * @return 返回执行结果
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
