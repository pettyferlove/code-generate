package com.github.pettyfer.generate;

import com.github.pettyfer.generate.db.DbInfoUtils;
import com.github.pettyfer.generate.model.TableInfo;

/**
 * @author Petty
 * @date 2018/4/26
 */
public class Demo {
    public static void main(String[] args) {
        DbInfoUtils dbInfoUtils = new DbInfoUtils();
        String driver = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/petty_platform?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=Hongkong";
        String table = "system_user";
        TableInfo tableInfo = dbInfoUtils.getTableInfo(driver, username, password, url, table);
        System.out.println(tableInfo);
    }
}
