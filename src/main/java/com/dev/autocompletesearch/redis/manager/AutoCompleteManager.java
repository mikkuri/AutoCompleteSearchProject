package com.dev.autocompletesearch.redis.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AutoCompleteManager {

    private static RedisTemplate redisTemplate;
    private final static int minScore = 0;
    private final static int maxScore = 4;
    private final static int maxCount = 5;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public static Set<ZSetOperations.TypedTuple<String>> complete(final String keyword) {
        return complete(keyword, minScore, maxScore, maxCount);
    }

    public static Set<ZSetOperations.TypedTuple<String>> complete(final String keyword, final int min, final int max, final int count) {

        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> completSet = zSetOperations.reverseRangeByScoreWithScores(keyword, min, max, 0, count);

        return completSet;
    }
}
