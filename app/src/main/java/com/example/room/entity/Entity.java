package com.example.room.entity;

//public @interface Entity {

    /*
    //Entity注解可选参数
    //定义表名
    String tableName() default "";
    //定义索引
    Index[] indices() default {};
    //设为true则父类的索引会自动被当前类继承
    boolean inheritSuperIndices() default false;
    //定义主键
    String[] primaryKeys() default {};
    //定义外键
    ForeignKey[] foreignKeys() default {};



Index索引注解可选参数
    public @interface Index {
      //定义需要添加索引的字段
      String[] value();
      //定义索引的名称
      String name() default "";
      //true-设置唯一键，标识value数组中的索引字段必须是唯一的，不可重复
      boolean unique() default false;
    }
ForeignKey外键注解可选参数
    public @interface ForeignKey {
          //引用外键的表的实体*********************
          Class entity();
          //要引用的外键列*********************
          String[] parentColumns();
          //要关联的列*********************
          String[] childColumns();
          //当父类实体(关联的外键表)从数据库中删除时执行的操作
          @Action int onDelete() default NO_ACTION;
          //当父类实体(关联的外键表)更新时执行的操作
          @Action int onUpdate() default NO_ACTION;
          //在事务完成之前，是否应该推迟外键约束
          boolean deferred() default false;
          //给onDelete，onUpdate定义的操作
          int NO_ACTION = 1;
          int RESTRICT = 2;
          int SET_NULL = 3;
          int SET_DEFAULT = 4;
          int CASCADE = 5;
          @IntDef({NO_ACTION, RESTRICT, SET_NULL, SET_DEFAULT, CASCADE})
          @interface Action {
            }
        }



    */




//}