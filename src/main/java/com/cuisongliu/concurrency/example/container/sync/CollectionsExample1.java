package com.cuisongliu.concurrency.example.container.sync;
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
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * Collections
 *
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2018-09-28 19:40
 */
@ThreadSafe
public class CollectionsExample1 {
    public static void main(String[] args) throws Exception {
        new AbstractThreadClass() {
            // Collections.synchronized* 可转化线程安全的方法
            private List<Integer> list = Collections.synchronizedList(Lists.newArrayList());
            @Override
            public void testExec() {
                list.add(1);
            }

            @Override
            public void testExec(int count) {
            }

            @Override
            public String log4j() {
                return list.size()+"";
            }
        }.main();
    }
}
