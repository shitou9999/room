package com.example.room;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * 复杂数据的处理 TypeConverter
 */
public class Converters {


    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }



}