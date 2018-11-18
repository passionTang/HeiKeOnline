package group.kexie.nodeuser;

import group.kexie.logconsumer.messagechannel.LogSendChannel;
import group.kexie.logconsumer.messageprovide.LogProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
@MapperScan("group.kexie.nodeuser.dao")
/*启用feign声明式服务*/
@EnableFeignClients
/*向注册中心注册*/
@EnableDiscoveryClient
/*创建消息通道实例*/
@EnableBinding(value =LogSendChannel.class)
@SpringBootApplication
public class NodeUserApplication {


    public static void main(String[] args) {
        SpringApplication.run(NodeUserApplication.class, args);
    }


    /**
     * 消息日志工具类
     * @return
     */
    @Bean(name = "logProvider")
    public LogProvider logProvider(){
        return new LogProvider();
    }


    /**
     * 使用redis作为缓存 @CacheEvit等注解的实现体层选择
     */
    @Bean(name="cacheManager")
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }
    /**
     *这里定义了两个bean，一个是redisTemplate，另一个是stringRedisTemplate，
     * 它们的序列化方式不同，前者默认jdk序列方式，后者默认string的序列化方式，
     * 后者一般专门用于存储string格式，前者我们可以用来保存对象等，
     * 这里我们都配置上，根据不同业务进行不同使用。
     * */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        return stringRedisTemplate;
    }



}
