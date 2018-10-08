package com.cuisongliu.concurrency.example.lock;
/*
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
import com.cuisongliu.concurrency.template.AbstractThreadClass;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2018-09-25 上午11:42
 */
@Slf4j
@ThreadSafe
public class LockExample2 {

    private static int count = 0;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception{

        new AbstractThreadClass() {
            @Override
            public void testExec() {
                add();
            }

            @Override
            public void testExec(int count) {
            }

            @Override
            public String log4j() {
                return count+"";
            }
        }.main();
    }
    private static void add() {
        lock.lock();
        try {
            count++;
        }finally {
            lock.unlock();
        }
    }
}
