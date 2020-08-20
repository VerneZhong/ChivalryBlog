package com.chivalry.design.patterns.command;

/**
 * 命令接口
 * @author Mr.zxb
 * @date 2020-08-16 20:42:17
 */
public interface Command {
    /**
     * 执行命令接口
     */
    void execute();

    /**
     * 撤销命令
     */
    void undo();
}
