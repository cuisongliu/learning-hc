package com.cuisongliu.concurrency.example.syncContainer;
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

import com.cuisongliu.concurrency.annoations.ThreadUnSafe;

import java.util.Vector;

/**
 * VectorExample1
 *
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2018-09-28 19:40
 */
@ThreadUnSafe
public class VectorExample2 {
    private static Vector<Integer> vector = new Vector<>();
    public static void main(String[] args) throws Exception {
        for(;;){
            for (int i =0;i< 1000 ; i++){
                vector.add(i);
            }

            new Thread(() -> {
                for (int i =0;i< vector.size() ; i++){
                    vector.remove(i);
                }
            }).start();

            new Thread(() -> {
                for (int i =0;i< vector.size() ; i++){
                    vector.get(i);
                }
            }).start();
        }

    }
}
