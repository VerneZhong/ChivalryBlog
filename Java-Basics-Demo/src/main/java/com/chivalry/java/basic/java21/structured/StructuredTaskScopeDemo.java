package com.chivalry.java.basic.java21.structured;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.StructuredTaskScope;
import java.util.stream.Collectors;

/**
 * 结构化并发示例
 *
 * @author Mr.Zxb
 * @description
 * @date 2025/03/11 20:58
 */
public class StructuredTaskScopeDemo {

    public static void main(String[] args) {

        // 结构化并发非常适合虚拟线程，虚拟线程是 JDK 实现的轻量级线程
        Callable<String> task1 = () -> "task1";
        Callable<String> task3 = () -> "task3";
        Callable<Integer> task2 = () -> 2;

        List<Callable<String>> callables = List.of(task1, task3);

        try (var scope = new StructuredTaskScope<>()) {
            // 使用fork方法派生线程来执行子任务
            StructuredTaskScope.Subtask<String> fork1 = scope.fork(task1);
            StructuredTaskScope.Subtask<Integer> fork2 = scope.fork(task2);

            List<StructuredTaskScope.Subtask<String>> subtasks = callables.stream().map(scope::fork).toList();

            // 等待线程完成
            scope.join();
            // 结果的处理可能包括处理或重新抛出异常

            Map<Boolean, Set<StructuredTaskScope.Subtask<String>>> map = subtasks.stream()
                    .collect(Collectors.partitioningBy(h -> h.state() == StructuredTaskScope.Subtask.State.SUCCESS,
                            Collectors.toSet()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
