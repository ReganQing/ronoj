package com.ron.ronoj.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.ron.ronoj.model.dto.question.JudgeCase;
import com.ron.ronoj.model.dto.question.JudgeConfig;
import com.ron.ronoj.judge.codesandbox.model.JudgeInfo;
import com.ron.ronoj.model.entity.Question;
import com.ron.ronoj.model.enums.JudgeInfoMeaasgeEnum;

import java.util.List;

/**
 * JavaScript程序判题策略
 */
public class JavaScriptLanguageJudgeStrategy implements JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext 判题需要的参数
     * @return
     */
    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        Long memory = judgeInfo.getMemory();
        Long time = judgeInfo.getTime();
        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList();
        Question question = judgeContext.getQuestion();
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        JudgeInfoMeaasgeEnum judgeInfoMeaasgeEnum = JudgeInfoMeaasgeEnum.ACCEPTED;
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMemory(memory);
        judgeInfoResponse.setTime(time);

        // 先判断沙箱执行的结果输出数量是否和预期输出数量相等
        if (outputList.size() != inputList.size()) {
            judgeInfoMeaasgeEnum = JudgeInfoMeaasgeEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMeaasgeEnum.getValue());
            return judgeInfoResponse;
        }
        // 依次判断每一项输出和预期输出是否相等
        for (int i = 0; i < judgeCaseList.size(); i++) {
            JudgeCase judgeCase = judgeCaseList.get(i);
            if (!judgeCase.getOutput().equals(outputList.get(i))) {
                judgeInfoMeaasgeEnum = JudgeInfoMeaasgeEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMeaasgeEnum.getValue());
                return judgeInfoResponse;
            }
        }
        // 判断题目限制是否符合要求

        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        Long expectedTimeLimit = judgeConfig.getTimeLimit();
        Long expectedMemoryLimit = judgeConfig.getMemoryLimit();
        if (memory > expectedMemoryLimit) {
            judgeInfoMeaasgeEnum = JudgeInfoMeaasgeEnum.MEMORY_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMeaasgeEnum.getValue());
            return judgeInfoResponse;
        }
        // JavaScript程序执行时间减去 2s
        long JAVASCRIPT_PROGRAME_TIME = 2000;
        if (time - JAVASCRIPT_PROGRAME_TIME > expectedTimeLimit) {
            judgeInfoMeaasgeEnum = JudgeInfoMeaasgeEnum.TIME_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMeaasgeEnum.getValue());
            return judgeInfoResponse;
        }
        judgeInfoResponse.setMessage(judgeInfoMeaasgeEnum.getValue());
        return judgeInfoResponse;
    }
}
