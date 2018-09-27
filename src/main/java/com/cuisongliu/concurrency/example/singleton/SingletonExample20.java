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

import com.cuisongliu.concurrency.annoations.ThreadSafe;
import com.cuisongliu.concurrency.annoations.UnRecommend;

/**
 * 单例exam2
 * 饿汉式
 * 单例在类装载的时候创建
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2018-09-27 上午9:26
 */
@UnRecommend
@ThreadSafe
public class SingletonExample20 {
    //step1
    private static SingletonExample20 instance = null;
    //step2
    static {
        instance = new SingletonExample20();
    }
    //切记静态代码块和声明静态变量的顺序
    private SingletonExample20() {
    }
    //静态工厂方法
    public static SingletonExample20 getInstance(){
        return SingletonExample20.instance;
    }
}
