package group.kexie.nodewebsocket;

import group.kexie.logconsumer.messagechannel.LogSendChannel;
import group.kexie.logconsumer.messageprovide.LogProvider;
import group.kexie.nodewebsocket.handle.UserWebSocketHandle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
@EnableBinding(value = LogSendChannel.class)
/*启用feign声明式服务*/
@EnableFeignClients
/*向注册中心注册*/
@EnableDiscoveryClient
/*使用websocket*/
@EnableWebSocket
@SpringBootApplication
public class NodeWebsocketApplication implements WebSocketConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(NodeWebsocketApplication.class, args);
    }

    /**
     * 消息日志工具类
     * @return
     */
    @Bean
    public LogProvider logProvider(){
        return new LogProvider();
    }


    /*会自动去注册@ServerEndpoint修饰的websocket接口连接类*/
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }


    /**
     * 使用redis作为缓存 @CacheEvit等注解的实现体层选择
     */
    @Bean(name="cacheManager")
    public CacheManager cacheManager(RedisTemplate<String,Object> redisTemplate) {
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }
    /**
     *这里定义了两个bean，一个是redisTemplate，另一个是stringRedisTemplate，
     * 它们的序列化方式不同，前者默认jdk序列方式，后者默认string的序列化方式，
     * 后者一般专门用于存储string格式，前者我们可以用来保存对象等，
     * 这里我们都配置上，根据不同业务进行不同使用。
     * */
    @Bean(name = "objRedisTemplate")
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
    /*注册websocket连接处理类*/
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(userWebSocketHandle(), "/webSocketServer.do").setAllowedOrigins("*");

    }
   /*手动申明bean*/
    @Bean
    public UserWebSocketHandle userWebSocketHandle(){
        return new UserWebSocketHandle();
    }

}
