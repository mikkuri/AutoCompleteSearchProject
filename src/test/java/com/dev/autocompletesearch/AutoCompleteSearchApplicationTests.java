package com.dev.autocompletesearch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AutoCompleteSearchApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void redisConnectionTest() {
        final String key = "a";
        final String data = "1";
        final int score = 0;

        final ZSetOperations valueOperations = redisTemplate.opsForZSet();
        valueOperations.add(key, data, score);

        final Set<String> result = valueOperations.range(key, 0, 1);

        for (String value : result)
            assertEquals(data, value);
    }

}
