package com.hawcore.sparkproject.test;

import com.hawcore.sparkproject.jdbc.JDBCHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengq
 */
public class JDBCHelperTest {
    public static void main(String[] args) {
        JDBCHelper jdbcHelper = JDBCHelper.getInstance();

        jdbcHelper.executeUpdate("insert into t_user_test(name) values(?)", new Object[]{"zhangsan"});


        jdbcHelper.executeQuery("select * from t_user_test where id>=?", new Object[]{1}, (rs) -> {
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        });

        List<Object[]> paramList = new ArrayList<>();
        paramList.add(new Object[]{"里斯", 12});
        paramList.add(new Object[]{"王五", 12});
        paramList.add(new Object[]{"六六", 12});
        jdbcHelper.executeBatch("insert into t_user_test(name, age) values(?,?)", paramList);


    }
}
