package com.ron.ronoj.judge.strategy;

import com.ron.ronoj.judge.codesandbox.model.JudgeInfo;
import com.ron.ronoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 * @author Ron_567
 */
@Service
public class JudgeManager {
    /**
     * 执行判题
     * @param judgeContext 判题需要的参数
     * @return 返回判题信息
     */
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String questionSubmitLanguage = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(questionSubmitLanguage)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
