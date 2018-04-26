package com.github.pettyfer.generate.db;

import com.github.pettyfer.generate.common.TypeConvertUtils;
import com.github.pettyfer.generate.model.FieldTypeInfo;
import com.github.pettyfer.generate.model.TableInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 数据库信息驱动包
 *
 * @author Petty
 * @version 1.0
 * @date 2018/4/26
 */

public class DbInfoUtils {

    private static final Logger logger = LoggerFactory.getLogger(DbInfoUtils.class);

    /**
     * @param driver   驱动名称
     * @param username 用户名
     * @param password 密码
     * @param url      数据库URL
     * @param table    表名
     * @return TableInfo
     */
    public TableInfo getTableInfo(String driver, String username, String password, String url, String table) {
        TableInfo tableInfo = null;
        Connection connection = getConnection(driver, username, password, url);
        try {
            tableInfo = new TableInfo();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(null, "%", table, new String[]{"TABLE"});
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                String tableRemark = resultSet.getString("REMARKS");
                tableInfo.setTableName(tableName);
                tableInfo.setTableRemark(tableRemark);
                if (tableName.equals(table)) {
                    ResultSet rs = connection.getMetaData().getColumns(null, getSchema(connection), tableName.toUpperCase(), "%");
                    List<String> columnNames = new ArrayList<>();
                    List<String> columnRemarks = new ArrayList<>();
                    List<String> columnTypeNames = new ArrayList<>();
                    List<FieldTypeInfo> fieldTypeInfos = new ArrayList<>();
                    while (rs.next()) {
                        String columnName = rs.getString("COLUMN_NAME");
                        columnNames.add(columnName);
                        columnRemarks.add(rs.getString("REMARKS"));
                        String typeName = rs.getString("TYPE_NAME");
                        columnTypeNames.add(typeName);
                        fieldTypeInfos.add(convertType(columnName, typeName));
                    }
                    tableInfo.setColumnNames(columnNames);
                    tableInfo.setColumnRemarks(columnRemarks);
                    tableInfo.setColumnTypeNames(columnTypeNames);
                    tableInfo.setFieldTypeInfos(fieldTypeInfos);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tableInfo;
    }

    private FieldTypeInfo convertType(String columnName, String columnType) {
        columnType = columnType.toUpperCase();
        TypeConvertUtils typeConvertUtils = TypeConvertUtils.getInstance();
        FieldTypeInfo fieldTypeInfo = typeConvertUtils.getFieldTypeInfoMap().get(columnType);
        if (fieldTypeInfo == null) {
            logger.warn("{}字段类型未定义映射，当前类型为{}，自动转换为VARCHAR", columnName, columnType);
            fieldTypeInfo = typeConvertUtils.getFieldTypeInfoMap().get("VARCHAR");
        }
        return fieldTypeInfo;
    }

    private String getSchema(Connection conn) throws Exception {
        String schema;
        schema = conn.getMetaData().getUserName();
        if ((schema == null) || (schema.length() == 0)) {
            throw new Exception("ORACLE数据库模式不允许为空");
        }
        return schema.toUpperCase();
    }


    /**
     * @param driver   驱动名称
     * @param username 用户名
     * @param password 密码
     * @param url      数据库URL
     * @return Connection
     */
    private Connection getConnection(String driver, String username, String password, String url) {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.put("user", username);
            properties.put("password", password);
            properties.setProperty("remarks", "true");
            properties.setProperty("useInformationSchema", "true");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
