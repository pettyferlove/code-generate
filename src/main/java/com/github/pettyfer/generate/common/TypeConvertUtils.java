package com.github.pettyfer.generate.common;

import com.github.pettyfer.generate.model.FieldTypeInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Petty
 * @date 2018/4/26
 */
public class TypeConvertUtils {

    private static TypeConvertUtils ourInstance = new TypeConvertUtils();

    private Map<String, FieldTypeInfo> fieldTypeInfoMap = new HashMap<>();

    public static TypeConvertUtils getInstance() {
        return ourInstance;
    }

    private TypeConvertUtils() {
        initMap();
        initMap();
    }

    public Map<String, FieldTypeInfo> getFieldTypeInfoMap() {
        return fieldTypeInfoMap;
    }

    private void initMap() {
        //VARCHAR2
        FieldTypeInfo fieldVarchar2 = new FieldTypeInfo();
        fieldVarchar2.setModelFieldType("String");
        fieldVarchar2.setMybatisFieldType("VARCHAR");
        fieldVarchar2.setImportClass("");
        fieldTypeInfoMap.put("VARCHAR2", fieldVarchar2);

        //VARCHAR
        FieldTypeInfo fieldVarchar = new FieldTypeInfo();
        fieldVarchar.setModelFieldType("String");
        fieldVarchar.setMybatisFieldType("VARCHAR");
        fieldVarchar.setImportClass("");
        fieldTypeInfoMap.put("VARCHAR", fieldVarchar);

        //NVARCHAR
        FieldTypeInfo fieldNvarchar = new FieldTypeInfo();
        fieldNvarchar.setModelFieldType("String");
        fieldNvarchar.setMybatisFieldType("VARCHAR");
        fieldNvarchar.setImportClass("");
        fieldTypeInfoMap.put("NVARCHAR", fieldNvarchar);

        //BLOB
        FieldTypeInfo fieldBlob = new FieldTypeInfo();
        fieldBlob.setModelFieldType("String");
        fieldBlob.setMybatisFieldType("VARCHAR");
        fieldBlob.setImportClass("");
        fieldTypeInfoMap.put("BLOB", fieldBlob);

        //CLOB
        FieldTypeInfo fieldClob = new FieldTypeInfo();
        fieldClob.setModelFieldType("String");
        fieldClob.setMybatisFieldType("VARCHAR");
        fieldClob.setImportClass("");
        fieldTypeInfoMap.put("CLOB", fieldClob);

        //NUMBER
        FieldTypeInfo fieldNumber = new FieldTypeInfo();
        fieldNumber.setModelFieldType("Integer");
        fieldNumber.setMybatisFieldType("NUMERIC");
        fieldNumber.setImportClass("");
        fieldTypeInfoMap.put("NUMBER", fieldNumber);

        //NUMBER
        FieldTypeInfo fieldInt = new FieldTypeInfo();
        fieldInt.setModelFieldType("Integer");
        fieldInt.setMybatisFieldType("NUMERIC");
        fieldInt.setImportClass("");
        fieldTypeInfoMap.put("INT", fieldInt);

        //TIMESTAMP
        FieldTypeInfo fieldTimestamp = new FieldTypeInfo();
        fieldTimestamp.setModelFieldType("Date");
        fieldTimestamp.setMybatisFieldType("TIMESTAMP");
        fieldTimestamp.setImportClass("java.util.Date");
        fieldTypeInfoMap.put("TIMESTAMP", fieldTimestamp);

        //TIMESTAMP
        FieldTypeInfo fieldDate = new FieldTypeInfo();
        fieldDate.setModelFieldType("Date");
        fieldDate.setMybatisFieldType("DATE");
        fieldDate.setImportClass("java.util.Date");
        fieldTypeInfoMap.put("DATE", fieldDate);
    }
}
