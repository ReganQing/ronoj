package com.ron.ronoj.judge.codesandbox.impl;

import com.ron.ronoj.judge.codesandbox.CodeSandBox;
import com.ron.ronoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.ron.ronoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 远程调用代码沙箱（实际调用接口的沙箱）
 * @author Ron_567
 */
public class RemoteCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程调用代码沙箱");
        return null;
    }
}
