package com.example.room

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/**
 * 持久库Room:Room在SQLite上提供了一个抽象层，以便在利用SQLite的全部功能的同时使流畅的数据库访问。
 * 下次如果设备无法联网用户也能浏览本地数据并进行更改。等下次联网后再和服务器进行同步。
 * get/set操作数据实体   getEntity from db 操作改变数据库  get DAO
 *
 * Database : 持有DB和DAO
 * Entity : 定义POJO类，即数据表结构
 * DAO(Data Access Objects) : 定义访问数据（增删改查）的接口
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Entity对应着数据库中的表格
     * Database类中的方法则用来获取对应的DAO列表。Database是App层与底层SQLite之间的连接点。
     */

    /*
    Entity：此组件的一个实例表示数据库的一行数据，对于每个Entity类来说，都会有对应的table被创建。
    想要这些Entity被创建，就需要写在上面Database的注解参数entities列表中。默认Entity中的所有字段
    都会拿来创建表，除非在该字段上加上@Ignore注解。

    注意：Entity默认都只有空的构造方法（如果DAO类可以访问每个持久化字段），
    或者构造方法的参数与Entity中的字段的类型和名字相匹配。
    Room可以使用全字段构造方法，也可以使用部分字段构造方法。

    DAO：这个组件用来表示具有Data Access Object(DAO)功能的类或接口。DAO类是Room的重要组件，
    负责定义访问数据库的方法。继承RoomDatabase的类必须包含一个0参数且返回DAO类的方法。当在
    编译期生成代码的时候，Room会创建实现此DAO的类。
    注意：通过使用DAO类而不是传统的查询接口来访问数据库，可以做到数据库组件的分离
    同时DAO可以在测试APP时支持Mock数据


    */


}
