package com.github.pettyfer.generate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Petty
 * @date 2018/4/26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableInfo implements Serializable {
    private static final long serialVersionUID = 1024760738713278668L;
    String tableName;
    String tableRemark;
    List<String> columnNames;
    List<String> columnRemarks;
    List<String> columnTypeNames;
    List<FieldTypeInfo> fieldTypeInfos;
}
