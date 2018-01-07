package com.example.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import com.example.room.entity.NameTuple;
import com.example.room.entity.User;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;

/**
 * 创建数据访问对象（DAO）
 * 查询语句及返回对象
 */
@Dao
public interface UserDao {

    //查询所有
    @Query("SELECT * FROM user")
    List<User> getAll();

    //根据id查询所有 方法中传递参数arg, 在sql语句中用:arg即可。编译时Room会匹配对应的参数。
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    //过滤操作
    @Query("SELECT * FROM user WHERE age > :minAge")
    User[] loadAllUsersOlderThan(int minAge);

    //如果在传参中没有匹配到:arg对应的参数, Room会在编译时报错。
    @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    //如果@Insert方法接收只有一个参数，它可以返回一个插入item的新rowId 的long值，
    // 如果参数是一个集合的数组，它应该返回long[]或者List<Long> Room在实现insert方法的实现时会在一个事务进行所有参数的插入。
    @Insert
    void insertAll(List<User> users);

    //@Insert的参数存在冲突时， 可以设置onConflict属性的值来定义冲突的解决策略，
    // 比如代码中定义的是@Insert(onConflict = OnConflictStrategy.REPLACE), 即发生冲突时替换原有数据
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsers(User... users);

    @Insert
    void insertBothUsers(User user1, User user2);

    @Insert
    void insertUsersAndFriends(User user, List<User> friends);

    //    它使用主键找到要删除的entities 你能够拥有这个方法返回int值指示数据库中删除的数量
    @Delete
    void delete(User user);

    @Delete
    void deleteUsers(User... users);

    //@Update和@Delete 可以定义int类型返回值，指更新／删除的函数-----它使用query来匹配每个entity的主键。
    //尽管通常不是必须的，你能够拥有这个方法返回int值指示数据库中更新的数量。
    @Update
    void updateUsers(List<User> users);

    //Room理解查询返回first_name和last_name的列值并且这些值被映射到NameTuple类的字段中
    //Room能够生成合适的代码。如果查询返回太多columns，或者一个列不存在，Room将会报警。
    //注意：这些POJOs也使用@Embedded注解
    @Query("SELECT first_name, last_name FROM user")
    List<NameTuple> loadFullName();

    //你的部分查询可能需要你传入可变数量的参数，确切数量的参数直到运行时才知道--如你可能想提取来自某个地区所有用户的信息
    //Room理解当一个参数代表一个集合并且自动的在运行时扩展它根据提供的参数数量
    @Query("SELECT first_name, last_name FROM user WHERE region IN (:regions)")
    List<NameTuple> loadUsersFromRegions(List<String> regions);

    //数据变化驱动UI刷新的需求 Room生成所有需要的代码去更新LiveData当数据库被更新。
//    注意：在1.0版本，Room使用被访问的table列表在查询中决定是否更新数据对象。
    @Query("SELECT first_name, last_name FROM user WHERE region IN (:regions)")
    LiveData<List<User>> loadUsersFromRegionsSync(List<String> regions);

    //Flowablbe<T> Maybe<T> Single<T>:
    //Room 支持返回RxJava2 的Flowablbe, Maybe和Single对象 android.arch.persistence.room:rxjava2。
    @Query("SELECT * from user where id = :id LIMIT 1")
    Flowable<User> loadUserById(int id);

    //    通过传入多个参数一个查询当中
    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
    User[] loadAllUsersBetweenAges(int minAge, int maxAge);

    //多次引用它们在一个查询当中
    @Query("SELECT * FROM user WHERE first_name LIKE :search " + "OR last_name LIKE :search")
    List<User> findUserWithName(String search);

    @Query("SELECT * FROM user WHERE birthday BETWEEN :from AND :to")
    List<User> findUsersBornBetweenDates(Date from, Date to);
    //    返回Cursor是为了支持现有项目中使用Cursor的场景，官方不建议直接返回Cursor.
    //注意：非常不建议使用Cursor API 因为它不能保证行是否存在或者行包含什么值。
    // 使用这个功能仅仅是因为你已经有期望返回一个cursor的代码并且你不能轻易的重构。
    @Query("SELECT * FROM user WHERE age > :minAge LIMIT 5")
    Cursor loadRawUsersOlderThan(int minAge);
}
