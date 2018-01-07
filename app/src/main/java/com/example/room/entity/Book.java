package com.example.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Entitiy间的关系
 * Room不支持Entitiy对象间的直接引用,Room允许通过外键(Foreign Key)来表示Entity之间的关系。
 * 即使你不能使用直接关系，Room仍然允许你定义外键约束在两个entities中。
 * 外键作用:指明当前引用的entity被更新后做什么事！！！
 */
//Book中的user_id,对应User中的id
@Entity(foreignKeys = @ForeignKey(entity = User.class,parentColumns = "uid",childColumns = "user_id"))
public class Book {

    /**
     * @ForeignKey注解中有两个属性 onDelete和 onUpdate， 这两个属性对应 ForeignKey中的 onDelete()和 onUpdate(),
     * 通过这两个属性的值来设置当User对象被删除／更新时，Book对象作出的响应。这两个属性的可选值如下：
     * CASCADE：User删除时对应Book一同删除； 更新时，关联的字段一同更新
     * NO_ACTION：User删除时不做任何响应
     * RESTRICT：禁止User的删除／更新。当User删除或更新时，Sqlite会立马报错。
     * SET_NULL：当User删除时， Book中的userId会设为NULL
     * SET_DEFAULT：与 SET_NULL类似，当User删除时，Book中的userId会设为默认值
     *
     */
    @PrimaryKey
    public int bookId;

    public String title;

    @ColumnInfo(name = "user_id")
    public int userId;

}
