package com.example.room.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

import com.example.room.entity.User;

/**
 * 原有SQLite数据库迁移至Room
 * 我们需要定义好Entity, DAO, Database, 然后创建Database时添加一个空实现的Migraton即可。
 * 需要注意的是，即使对数据库没有任何升级操作也需要升级版本，否则会抛异常IllegalStateException.
 */
@Database(entities = {User.class}, version = 2)
public abstract class UsersDatabase extends RoomDatabase {

//    database =  Room.databaseBuilder(context.getApplicationContext(),
//    UsersDatabase.class, "Sample.db").addMigrations(MIGRATION_1_2).build();

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    };


}
