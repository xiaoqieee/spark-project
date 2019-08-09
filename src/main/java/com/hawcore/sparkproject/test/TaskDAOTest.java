package com.hawcore.sparkproject.test;

import com.alibaba.fastjson.JSON;
import com.hawcore.sparkproject.dao.ITaskDAO;
import com.hawcore.sparkproject.factory.DAOFactory;

/**
 * @author xn025665
 */
public class TaskDAOTest {

    public static void main(String[] args) {
        ITaskDAO taskDAO = DAOFactory.getTaskDAO();
        System.out.println(JSON.toJSONString(taskDAO.findById(1)));
    }
}
