package com.example.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

//指示数据表实体类
@Entity(tableName = "tb_student",//定义表名
        indices = @Index(value = {"name", "sex"}, unique = true),//定义索引
        foreignKeys = {@ForeignKey(entity = ClassEntity.class,
                parentColumns = "id", childColumns = "class_id")})//定义外键
public class StudentEntity {

    @PrimaryKey //定义主键
    private long id;
    @ColumnInfo(name = "name")//定义数据表中的字段名
    private String name;
    @ColumnInfo(name = "sex")
    private int sex;
    @Ignore//指示Room需要忽略的字段或方法
    private String ignoreText;
    @ColumnInfo(name = "class_id")
    private String class_id;

    //setter and getter
}