package com.hawcore.sparkproject.jdbc;

import com.hawcore.sparkproject.conf.ConfigurationManager;
import com.hawcore.sparkproject.constant.Constants;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * @author fengq
 */
public class JDBCHelper {

    private static JDBCHelper instance = null;

    static {
        try {
            Class.forName(ConfigurationManager.getProperty(Constants.JDBC_DRIVER_NAME));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static LinkedList<Connection> dataSource = new LinkedList<Connection>();

    private JDBCHelper() {

        int connectPoolSize = ConfigurationManager.getInteger(Constants.CONNECT_POOL_SIZE);
        String userName = ConfigurationManager.getProperty(Constants.JDBC_USER_NAME);
        String passWorld = ConfigurationManager.getProperty(Constants.JDBC_PASS_WORLD);
        String url = ConfigurationManager.getProperty(Constants.JDBC_URL);
        for (int i = 0; i < connectPoolSize; i++) {
            try {
                Connection connection = DriverManager.getConnection(url, userName, passWorld);
                dataSource.push(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static JDBCHelper getInstance() {
        if (null == instance) {
            synchronized (JDBCHelper.class) {
                if (null == instance) {
                    instance = new JDBCHelper();
                }
            }
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        while (dataSource.size() == 0) {
        }
        return dataSource.poll();
    }

    private void release(Connection connection) {
        if (connection != null) {
            dataSource.push(connection);
        }
    }


    public int executeUpdate(String sql, Object[] params) {
        Connection conn = null;
        PreparedStatement ps;
        int r = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            r = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(conn);
        }
        return r;
    }

    public void executeQuery(String sql, Object[] params, QueryCallback callback) {
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            rs = ps.executeQuery();
            callback.process(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(conn);
        }
    }

    interface QueryCallback {
        void process(ResultSet rs) throws Exception;
    }
}
