package com.ron.ronoj.judge.strategy;

import com.ron.ronoj.model.dto.question.JudgeCase;
import com.ron.ronoj.judge.codesandbox.model.JudgeInfo;
import com.ron.ronoj.model.entity.Question;
import com.ron.ronoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<JudgeCase> judgeCaseList;

    private List<String> inputList;

    private List<String> outputList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
