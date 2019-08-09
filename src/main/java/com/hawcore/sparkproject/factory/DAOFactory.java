package com.hawcore.sparkproject.factory;

import com.hawcore.sparkproject.dao.ITaskDAO;
import com.hawcore.sparkproject.dao.impl.TaskDAOImpl;

/**
 * @author xn025665
 */
public class DAOFactory {

    public static ITaskDAO getTaskDAO() {
        return new TaskDAOImpl();
    }


}
