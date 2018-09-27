package com.cuisongliu.concurrency.example.singleton;/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 cuisongliu@qq.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import com.cuisongliu.concurrency.annoations.ThreadUnSafe;

/**
 * 单例exam1
 * 懒汉式
 * 单例在第一次使用的时候创建  双重同步锁　volatile解决了重排序问题
 * volatile　＋　双重同步锁
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2018-09-27 上午9:26
 */
@ThreadUnSafe
public class SingletonExample14 {

    private static volatile SingletonExample14 instance = null;

    private SingletonExample14() {
    }

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚刚分配的内存

    //JVM和CPU发生指令重排序
    //静态工厂方法
    public static SingletonExample14 getInstance(){
        if (instance == null){
            synchronized (SingletonExample14.class){
                if (instance!=null){
                    instance = new SingletonExample14();
                }
            }
        }
        return SingletonExample14.instance;
    }
}
