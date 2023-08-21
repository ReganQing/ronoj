package com.ron.ronoj.judge.codesandbox.impl;

import com.ron.ronoj.judge.codesandbox.CodeSandBox;
import com.ron.ronoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.ron.ronoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 第三方代码沙箱（调用网上现成的代码沙箱）
 * @author Ron_567
 */
public class ThirdPartyCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
