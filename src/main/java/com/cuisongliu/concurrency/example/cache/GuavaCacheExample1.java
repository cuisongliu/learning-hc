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
package com.cuisongliu.concurrency.example.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2018-10-11 上午9:31
 */
@Slf4j
public class GuavaCacheExample1 {
    public static void main(String[] args) {
        LoadingCache<String,Integer> cache = CacheBuilder.newBuilder()
                .maximumSize(10)//最多存放的数据
                .expireAfterWrite(10, TimeUnit.SECONDS) //缓存10秒
                .recordStats() //开启记录状态数据功能
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String s) throws Exception {
                        return -1;
                    }
                });
        log.info("{}",cache.getIfPresent("key1"));
        cache.put("key1",1);
        log.info("{}",cache.getIfPresent("key1"));
        cache.invalidate("key1");
        log.info("{}",cache.getIfPresent("key1"));
        try{
            log.info("{}",cache.get("key2"));
            cache.put("key2",2);
            log.info("{}",cache.get("key2"));
            log.info("{}",cache.size());
            for (int i=3 ; i<13 ; i++){
                cache.put("key"+i,i);
            }
            log.info("{}",cache.size());
            log.info("{}",cache.getIfPresent("key2"));
            Thread.sleep(11000);
            log.info("{}",cache.get("key5"));
            log.info("{},{}",cache.stats().hitCount(),cache.stats().missCount());
            log.info("{},{}",cache.stats().hitRate(),cache.stats().missRate());

        }catch (Exception e){
            log.error("exception",e);
        }
    }
}
