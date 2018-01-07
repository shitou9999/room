package com.example.app2.base;

/**
 * BaseView得想好做什么事,必须是你的项目里所有view都有的共性
 *不仅是acitivity和fragment,还有控件
 */
public interface BaseView {
    /**
     * 切换夜间模式
     * @param isNight 是否切换为夜间模式
     */
    void isNightMode(boolean isNight);
}