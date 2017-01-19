package com.example;

import com.google.common.cache.CacheBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@org.springframework.context.annotation.Configuration
@EnableAutoConfiguration
@EnableCaching
public class Configuration extends CachingConfigurerSupport {

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager() {
            @Override
            protected Cache createConcurrentMapCache(final String name) {
                return new ConcurrentMapCache(name, CacheBuilder.newBuilder()
                                                                .expireAfterWrite(60, TimeUnit.SECONDS)
                                                                .maximumSize(100)
                                                                .build().asMap(), false);
            }
        };
    }

}
