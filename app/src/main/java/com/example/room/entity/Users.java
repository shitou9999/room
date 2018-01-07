package com.example.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.graphics.Bitmap;

/**
 * 每个entity必须定义至少一个字段作为主键。
 * 即使这里只有一个字段，你仍然需要使用@PrimaryKey注解这个字段。
 * 并且，如果你想Room动态给entities分配IDs，你可以设置@PrimaryKey’s 的autoGenerate属性。
 * 如果entity有个组合的主键，你可以使用@Entity注解的primaryKeys的属性，正如如下片段展示的那样
 */
@Entity(primaryKeys = {"firstName", "lastName"})
public class Users {

    public String firstName;
    public String lastName;

    @Ignore
    Bitmap picture;



}
