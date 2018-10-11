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

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 缓存控制器
 *
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2018-10-11 上午10:49
 */
@RestController
@RequestMapping("/cache")
@Slf4j
public class CacheController {
    @Autowired
    private RedisClient redisClient;

    @RequestMapping(value = "/set",method = RequestMethod.GET)
    public String set(@RequestParam("k")String k ,@RequestParam("v")String v){
        try {
            redisClient.set(k, v);
            return "SUCCESS";
        } catch (Exception e) {
            log.error("exception",e);
        }
        return "ERROR";
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String get(@RequestParam("k")String k){
        try {
            return redisClient.get(k);
        } catch (Exception e) {
            log.error("exception",e);
        }
        return "ERROR";
    }
}
