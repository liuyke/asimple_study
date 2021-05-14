package com.liuyk.asimple.leetcode;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class BatchImport {

    public static void main(String[] args) {
        // TODO 100万的数据集合
        String result = parallelImport(new ArrayList<>());
    }

    static class ItemResult {

        int lineNum;
        boolean success;
        String errorMsg;

        public ItemResult() {
        }

        public ItemResult(int lineNum, boolean success, String errorMsg) {
            this.lineNum = lineNum;
            this.success = success;
            this.errorMsg = errorMsg;
        }
    }


    private static String parallelImport(List<Long> list) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 线程安排的数据集
        Set<Long> set = Collections.newSetFromMap(new ConcurrentHashMap<>());
        //失败成功标志的队列
        BlockingQueue<ItemResult> okOrFailQueue = new LinkedBlockingQueue<>();

        new Thread(() -> {
            list.parallelStream().anyMatch(o -> {
                if (true) {
                    //导入成功放到结果集中
                    set.add(o);
                    return false;
                } else {
                    ItemResult itemResult = new ItemResult(1, false, "数据错误");
                    // 处理失败，往队列里添加一个失败的标志
                    okOrFailQueue.add(itemResult);
                    //返回true代表终止循环
                    return true;
                }
            });
            //说明处理完了，返回一个成功标志
            okOrFailQueue.add(new ItemResult(0, true, null));
        }).start();

        try {
            //此处会阻塞，直到队列里有值出现
            ItemResult res = okOrFailQueue.take();
            if (Boolean.TRUE.equals(res.success)) {
                //插入successList 里的数据，然后提交事务
                List<Long> successList = new ArrayList<>(set);

                stopWatch.stop();
                return String.format("导入成功%s条，耗时:%sms", successList.size(), stopWatch.getTotalTimeMillis());
            } else {
                //失败信息
                String msg = res.errorMsg;
                //行号
                Integer lineNum = res.lineNum;
                return String.format("第%s行，由于%s原因导致失败", lineNum, msg);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "线程异常";
        }

    }

}
