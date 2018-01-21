package com.example.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import java.util.Date;
import java.util.UUID;

/**
 * 一个简单的Entitiy
 * 为了持久化一个字段，Room必须有它的入口。你可以使字段为public，或者你可以提供一个setter或者getter。
 * 如果你使用setter或者getter方法，记住在Room中他们遵守Java Beans的惯例。
 *
 * 默认情况下，Room使用类名作为数据库的表名。如果你希望表有一个不同的名称，设置@Entity注解的tableName属性，
 * SQLite中的表名是大小写敏感的！！！！！！！！！！！！
 */

@Entity(tableName = "user",indices ={@Index(value = {"firstName","lastName"})} )
public class User {
//    @Entity(tableName="table_name**") 注解POJO类，定义数据表名称;
//    @PrimaryKey 定义主键，如果一个Entity使用的是复合主键，可以通过
//    @Entity注解的 primaryKeys 属性定义复合主键： @Entity(primaryKeys={"firstName","lastName"})
//    @ColumnInfo(name=“column_name”) 定义数据表中的字段名
//    @Ignore 用于告诉Room需要忽略的字段或方法
//    建立索引：在 @Entity注解的 indices属性中添加索引字段。
//    例如： indices={@Index(value={"first_name","last_name"},unique=true),...}, unique=true可以确保表中不会出现
//    {"first_name","last_name"} 相同的数据。

    //你可能希望索引确切的字段去加速你的数据库查询。
//    在索引或者组合索引中列出你希望包含的列的名称
//@Entity(indices = {@Index("name"), @Index("last_name", "address")})
//    确切的字段和组字段必须是独一无二的。你可以强加这个独一无二的特性通过设置一个@Index注解的unique属性为true。
//    @Entity(indices = {@Index(value = {"first_name", "last_name"}, unique = true)}) //阻止了表拥有两行包含同样的firstName和last列的值集合。

    //每个entity必须定义至少一个字段作为主键
    @PrimaryKey
    private String uid;

//    定义数据表中的字段名 字段名称作为列名称
    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    //表示对象的嵌套 嵌入字段也包括其他嵌入字段
//    如果一个字段有多个同一类型的嵌入字段，你能保持每个列是独一无二的通过
//    设置prefix属性。Room然后将所提供的值添加到嵌入对象中每个列名的开头
    //@Embedded来表示一个对象，将其分解为表中的子字段/然后可以像对其他单个列一样查询嵌入式字段
    @Embedded
    public Address address;

    //如果一个实体具有相同类型的多个内嵌字段，则可以通过设置前缀属性(prefix)使每个列保持惟一。
    // 然后将所提供的值添加到嵌入对象中每个列名的开头
//    @Embedded(prefix = "foo_")
//    Coordinates coordinates;


    private Date birthday;

    @Ignore
    Bitmap picture;

    //每个entity字段被持久化到数据库中除非你注解它通过@Ignore.
    @Ignore
    public User(String firstName, String lastName) {
        this.uid = UUID.randomUUID().toString();
        this.firstName = firstName;
        this. lastName = lastName;
    }

    public User(String id, String firstName, String lastName) {
        this.uid = id;
        this.firstName = firstName;
        this. lastName = lastName;
    }

    // Getters and setters
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
