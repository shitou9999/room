package com.example.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tb_class")
public class ClassEntity {

    @PrimaryKey
    private long id;


}