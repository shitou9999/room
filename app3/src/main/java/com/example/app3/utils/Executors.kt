package com.example.app3.utils

import java.util.concurrent.Executors

/**
 * Created by PVer on 2018/1/7.
 */
private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

/**
 * 在专用后台线程上运行块的实用方法，用于io /数据库工作
 * Utility method to run blocks on a dedicated background thread, used for io/database work.
 */
fun ioThread(f : () -> Unit) {
    IO_EXECUTOR.execute(f)
}