package com.example.room.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;

import com.example.room.Converters;
import com.example.room.dao.UserDao;
import com.example.room.entity.User;

/**
 * 除了持有DB外它还负责持有相关数据表（Entity）的数据访问对象（DAO）
 * 在运行时，你能获得一个实例通过调用Room.databaseBuilder()或者 Room.inMemoryDatabaseBuilder()
 * 你必须遵守单例模式当初始化一个AppDatabase对象，因为每个RoomDatabase实例是相当昂贵的，并且你几乎不需要访问多个实例
 * 因为SQLite是个关系型数据库，你能够指明两个对象的关系。
 * 虽然大多数ORM库支持entity对象引用其他的。Room明确的禁止这样！！！！！！！！
 */

@Database(entities = {User.class}, version = 1)
@TypeConverters({Converters.class}) //告知数据库要依赖哪些转换类
public abstract class AppDatabase extends RoomDatabase {

//    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//            AppDatabase.class, "database-name").build();

//    Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name")
//            .addMigrations(MIGRATION_1_2, MIGRATION_2_3).build();
//    注意：Room不允许在主线程中访问数据库除非你在建造器中调用allowMainThreadQueries()，因为它可能长时间的锁住UI。
//    异步查询（返回LiveData或者RxJava流的查询）是从这个规则中豁免的因为它们异步的在后台线程中进行查询。

    /**
     * 数据库升级
     * 在创建Migration类时需要指定startVersion和endVersion代码中MIGRATION_1_2和MIGRATION_2_3的startVersion和endVersion是递增的
     * Migration其实是支持从版本1直接升到版本3，只要其migrate()方法里执行的语句正常即可
     * 其实本质上还是调用SQLiteOpenHelper.onUpgrade，Room中自己实现了一个SQLiteOpenHelper在onUpgrade()方法被调用时触发Migration，
     * 当第一次访问数据库时，Room做了以下几件事：
     *  创建Room Database实例
     *  SQLiteOpenHelper.onUpgrade被调用，并且触发Migration
     *  打开数据库
     *  注意：如果你不提供必需的migrations类，Room重建数据库，也就意味你将丢失数据库中的所有数据。
     *
     */
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, "
                    + "`name` TEXT, PRIMARY KEY(`id`))");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Book "
                    + " ADD COLUMN pub_year INTEGER");
        }
    };

    public abstract UserDao userDao();


    /**
     * 注意:
     *  为了使迁移逻辑保持正常运行，请使用完整的查询语句，即使用硬编码（对这里推荐硬编码）。而不是用一些字符串引用。
     * 当迁移过程结束，Room验证schema去保证迁移成功。如果Room发现问题，它将抛出不匹配异常。
     */


    /**
     * Testing migrations
     * 迁移并不是一件简单的事情，如果不能正确编写将会造成应用崩溃。为了保证你应用的稳定性，
     * 你应该在提交前测试你的迁移类。Room提供一个测试Maven组件去协助测试过程。
     * 为了让这个组件工作，你需要导出你的数据库schema
     */

}
