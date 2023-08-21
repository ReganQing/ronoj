package com.ron.ronoj.judge.strategy;

import com.ron.ronoj.judge.codesandbox.model.JudgeInfo;

/**
 * 判题策略
 */
public interface JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext 判题需要的参数
     * @return 返回判题信息
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
