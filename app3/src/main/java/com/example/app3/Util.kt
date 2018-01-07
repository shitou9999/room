package com.example.app3

/**
 * Kotlin语言中使用"object"修饰静态类，被修饰的类，可以使用类名.方法名的形式调用
 */
object Util {

    fun getCurrentVersion(): String {
        return BuildConfig.VERSION_NAME
    }
}