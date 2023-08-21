package com.ron.ronoj.judge.codesandbox;

import com.ron.ronoj.judge.codesandbox.impl.ExampleCodeSandBox;
import com.ron.ronoj.judge.codesandbox.impl.RemoteCodeSandBox;
import com.ron.ronoj.judge.codesandbox.impl.ThirdPartyCodeSandBox;


public class CodeSandBoxFactory {
    /**
     * 创建代码沙箱示例
     * @param type 沙箱类型
     * @return
     */
    public static CodeSandBox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandBox();
            case "remote":
                return new RemoteCodeSandBox();
            case "thirdParty":
                return new ThirdPartyCodeSandBox();
            default:
                return new ExampleCodeSandBox();
        }
    }
}
