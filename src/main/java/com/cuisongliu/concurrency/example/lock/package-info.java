/**
 * 关于Lock相关的类
 * 1. 只有少量竞争者的时候 sync是比较好的选择
 * 2. 竞争者不少但是线程增长的趋势是可以预估的ReentrantLock是个比较好的选择
 * 3. sync不会引发死锁
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2018-10-08 下午3:02
 */
package com.cuisongliu.concurrency.example.lock;