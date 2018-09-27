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

import com.cuisongliu.concurrency.annoations.Recommend;
import com.cuisongliu.concurrency.annoations.ThreadSafe;

/**
 * 枚举实现单例
 * 最安全
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2018-09-27 上午10:15
 */
@ThreadSafe
@Recommend
public class SingletonExample30 {

    private SingletonExample30() {
    }

    public static SingletonExample30 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
    private enum Singleton {
        /**
         * 实例枚举
         */
        INSTANCE;
        private SingletonExample30 singleton;
        /**
         * JVM保证这个方法绝对只执行一次
         */
        Singleton() {
            singleton = new SingletonExample30();
        }
        public SingletonExample30 getInstance(){
            return singleton;
        }
    }
}
