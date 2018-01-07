package com.example.room.entity;

import android.arch.persistence.room.ColumnInfo;

/**
 * 对象嵌套
 */

public class Address {

    private String street;
    private String state;
    private String city;

    @ColumnInfo(name = "post_code")
    private int postCode;

    /*
    补充：禁止Entity之间的相互引用
    将数据库中的关系映射到相应的对象模型是一个常见的做法，在服务器端可以很好地运行，在访问它们时，它们可以很方便地加载字段。

    然而，在客户端，延迟加载是不可行的，因为它可能发生在UI线程上，并且在UI线程中查询磁盘上的信息会产生显着的性能问题。
    UI线程有大约16ms的时间来计算和绘制Activity的更新的布局，所以即使一个查询只需要5 ms，你的应用程序仍然可能耗尽用于绘制的时间，
    引起明显的卡顿。更糟糕的是，如果并行运行单独的事务，或者设备忙于其他磁盘重的任务，则查询可能需要更多时间才能完成。
    但是，如果不使用延迟加载，则应用程序将获取比其需要的更多数据，从而产生内存消耗问题。

    ORM通常将此决定留给开发人员，以便他们可以为应用程序的用例做最好的事情。
    不幸的是，开发人员不会在他们的应用程序和UI之间共享模型。UI随着时间的推移而变化，难以预料和调试的问题会不断出现。

    例如，使用加载Book对象列表的UI为例，每本书都有一个Author对象。你可能最初设计你的查询时使用延迟加载，
    以便Book的实例使用getAuthor()方法来返回作者。一段时间后，你意识到需要在应用中显示作者姓名。
    你可以轻松添加方法调用，如以下代码片段所示：

    authorNameTextView.setText(user.getAuthor().getName());
    就这么一个简单的操作，导致了在主线程中访问数据库。如果Author用引用了另一张表，那情况可能更糟糕。
    如果需求变化，这个界面不在需要作者姓名，那么你的代码可能会做无畏的延迟加载。

    基于以上原因，Room禁止Entity之间的引用，如果需要加载相关数据，可以使用显示的方法去加载。
     */


}
