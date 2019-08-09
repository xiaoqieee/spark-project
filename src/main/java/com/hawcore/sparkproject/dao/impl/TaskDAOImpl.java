package com.hawcore.sparkproject.dao.impl;

import com.hawcore.sparkproject.dao.ITaskDAO;
import com.hawcore.sparkproject.domain.Task;
import com.hawcore.sparkproject.jdbc.JDBCHelper;

/**
 * @author xn025665
 */
public class TaskDAOImpl implements ITaskDAO {

    @Override
    public Task findById(long taskId) {
        final Task task = new Task();
        JDBCHelper jdbcHelper = JDBCHelper.getInstance();

        String sql = "select * from t_task where task_id=?";
        Object[] params = new Object[]{taskId};

        jdbcHelper.executeQuery(sql, params, (rs) -> {
            if (rs.next()) {
                task.setTaskId(rs.getLong("task_id"));
                task.setTaskName(rs.getString("task_name"));
                task.setCreateTime(rs.getString("create_time"));
                task.setStartTime(rs.getString("start_time"));
                task.setFinishTime(rs.getString("finish_time"));
                task.setTaskParam(rs.getString("task_param"));
                task.setTaskType(rs.getString("task_type"));
                task.setTaskStatus(rs.getString("task_status"));
            }
        });
        return task;
    }
}
