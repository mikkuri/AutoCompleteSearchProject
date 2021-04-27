package com.dev.autocompletesearch.redis;

import com.dev.autocompletesearch.redis.manager.AutoCompleteManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisData implements ApplicationRunner {
    private final AutoCompleteManager template;
    private final RedisTemplate redisTemplate;
    private ZSetOperations<String, String> zSetOperations;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        template.setRedisTemplate(redisTemplate);

        zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("무", "무탠다드", 4);
        zSetOperations.add("무", "엘무드", 3);
        zSetOperations.add("무", "무지 맨투맨", 4);
        zSetOperations.add("무", "무지티", 1);
        zSetOperations.add("무", "무신사 스탠다드", 2);
        zSetOperations.add("무", "무지 반팔", 0);
        zSetOperations.add("무", "무탠다드 블레이저", 0);

        zSetOperations.add("나이", "나이이", 6);
        zSetOperations.add("나이", "나이키 데이브레이크", 1);
        zSetOperations.add("나이", "나이키 후드티", 2);
        zSetOperations.add("나이", "나이키", 4);
        zSetOperations.add("나이", "나이키 바람막이", 3);
        zSetOperations.add("나이", "나이스고스트클럽", 0);
        zSetOperations.add("나이", "나이키 맨투맨", 3);

        zSetOperations.add("신발", "손신발", 5);
        zSetOperations.add("신발", "신발", 4);
        zSetOperations.add("신발", "신발끈", 4);
        zSetOperations.add("신발", "나이키 신발", 3);
        zSetOperations.add("신발", "반스 신발", 1);
        zSetOperations.add("신발", "슈펜", 0);
        zSetOperations.add("신발", "첼시 부츠", 0);
    }
}
