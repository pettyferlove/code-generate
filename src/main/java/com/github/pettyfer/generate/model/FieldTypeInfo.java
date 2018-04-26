package com.github.pettyfer.generate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Petty
 * @date 2018/4/26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldTypeInfo implements Serializable {

    private static final long serialVersionUID = -8697776386274145732L;

    String modelFieldType;
    String mybatisFieldType;
    String importClass;
}
