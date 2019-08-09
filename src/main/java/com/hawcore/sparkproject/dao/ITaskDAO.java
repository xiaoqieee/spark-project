package com.hawcore.sparkproject.dao;

import com.hawcore.sparkproject.domain.Task;

/**
 * @author xn025665
 */
public interface ITaskDAO {

    /**
     * 根据taskId获取task相关数据
     *
     * @param taskId
     * @return task
     */
    Task findById(long taskId);
}
