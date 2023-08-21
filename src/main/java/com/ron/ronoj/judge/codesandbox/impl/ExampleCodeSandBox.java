package com.ron.ronoj.judge.codesandbox.impl;

import com.ron.ronoj.judge.codesandbox.CodeSandBox;
import com.ron.ronoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.ron.ronoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.ron.ronoj.judge.codesandbox.model.JudgeInfo;
import com.ron.ronoj.model.enums.JudgeInfoMeaasgeEnum;
import com.ron.ronoj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱(仅为了跑通流程)
 *
 * @author Ron_567
 */
public class ExampleCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();

        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMeaasgeEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);

        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
