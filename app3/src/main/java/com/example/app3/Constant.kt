package com.example.app3

/**
 * 使用object和companion object修饰静态类和静态方法
 */
class Constant {

    /**
     * Kotlin语言中使用"object"修饰静态类，被修饰的类，可以使用类名.方法名的形式调用
     * Kotlin语言中使用"companion object"修饰静态方法，可以使用类名.方法名的形式调用
     *
     */
    companion object {
        val PAGESIZE:Int = 20
        val url = "http://api.douban.com/"
        val ENABLE_PLACEHOLDERS:Boolean =true
    }


}
