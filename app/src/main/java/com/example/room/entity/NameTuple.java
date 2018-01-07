package com.example.room.entity;

import android.arch.persistence.room.ColumnInfo;


/**
 * 在实际某个业务场景中， 我们可能仅关心一个表部分字段的值，这时我仅需要查询关心的列即可。
 * 定义子集的POJO类:
 * 这里定义的POJO也支持使用@Embedded
 * 返回列中的子集
 */
public class NameTuple {
//    多数时候，你仅仅需要获取一个entity中的部分字段。例如，你的UI可能只展示user’s第一个和最后一个名称，
//    而不是所有关于用户的细节。你保存有价值的资源通过获取展示在你app’s的UI的列，你的查询完成的更快。
    /**
     * Room允许你返回任何java对象从查询中只要列结果集能够被映射到返回的对象中
     */

    @ColumnInfo(name="first_name")
    public String firstName;

    @ColumnInfo(name="last_name")
    public String lastName;


}
