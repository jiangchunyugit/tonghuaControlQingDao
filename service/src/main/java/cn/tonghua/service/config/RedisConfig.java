package cn.tonghua.service.config;

import cn.tonghua.core.config.GsonSerializer;
import cn.tonghua.core.security.model.SecurityUser;
import cn.tonghua.service.utils.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@EnableRedisRepositories
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setValueSerializer(new StringRedisSerializer());
        template.setKeySerializer(new StringRedisSerializer());

        template.afterPropertiesSet();

        return template;
    }

    @Bean
    public RedisTemplate<String, SecurityUser> userRedisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, SecurityUser> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        template.setValueSerializer(new GsonSerializer(Object.class));
        template.setKeySerializer(new StringRedisSerializer());

        template.afterPropertiesSet();

        return template;
    }
    @Bean
    public RedisTemplate<String, Object> objRedisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(factory);

        template.setValueSerializer(new GsonSerializer(Object.class));
        template.setKeySerializer(new StringRedisSerializer());

        template.afterPropertiesSet();

        return template;
    }

    /**
     * 注入封装RedisTemplate
     * @Title: redisUtils
     * @return RedisUtils
     * @autor lpl
     * @date 2017年12月21日
     * @throws
     */
    @Bean(name = "redisUtils")
    public RedisUtils redisUtil(RedisTemplate<String, Object> redisTemplate) {
        RedisUtils redisUtil = new RedisUtils();
        redisUtil.setRedisTemplate(redisTemplate);
        return redisUtil;
    }


}
