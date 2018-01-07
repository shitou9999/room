package com.example.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.room.entity.Book;

import java.util.List;

/**
 * 用与展示联表查询**你的一些查询可能访问多个表去计算结果
 * 接口定义上与其他查询差别不大， 主要还是sql语句的差别
 *
 */
@Dao
public interface MyDao {

    @Query("SELECT * FROM book "
            + "INNER JOIN loan ON loan.book_id = book.id "
            + "INNER JOIN user ON user.id = loan.user_id "
            + "WHERE user.name LIKE :userName")
    List<Book> findBooksBorrowedByNameSync(String userName);
//    当前正在借出的书和借的有书的人的信息。

    @Query("SELECT user.name AS userName, pet.name AS petName "
            + "FROM user, pet " + "WHERE user.id = pet.user_id")
    LiveData<List<UserPet>> loadUserAndPetNames();

    // You can also define this class in a separate file, as long as you add the
    // "public" access modifier.
    static class UserPet {
        public String userName;
        public String petName;
    }



}
