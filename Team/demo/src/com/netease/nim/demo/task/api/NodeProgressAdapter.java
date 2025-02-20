package com.netease.nim.demo.task.api;

import com.netease.nim.demo.task.view.LogisticsData;

import java.util.List;

/**
 * User: Daidingkang(ddk19941017@Gmail.com)
 * Date: 2016-06-28
 * Time: 14:30
 * FIXME
 */
public interface NodeProgressAdapter{

    /**
     * 返回集合大小
     *
     * @return
     */
    int getCount();

    /**
     * 适配数据的集合
     *
     * @return
     */
    List<LogisticsData> getData();

}
