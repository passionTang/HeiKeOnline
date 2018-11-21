package group.kexie.logconsumer.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author tangbo
 * @date 2018/11/18 19:16
 * @description: 本服务的常量
 * 注意:三个属性会让子类继承到
 */
@Component
public  class BasicNodeServerParam {

    /*本服务名*/
    @Value("${spring.application.name}")
    protected String NodeServerName;
    /*端口号*/
    @Value("${server.port}")
    protected String NodeServerPort;
    /*IpAdress*/
    protected String NodeServerHost=setNodeServerHost();


    protected String setNodeServerHost(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "unknown";
        }
    }

    /**
     * 以下方法提供给本服务调用
     * @return
     */
    public  String getNodeServerHost(){
        return NodeServerHost;
    }
    public String getNodeServerName(){
        return NodeServerName;
    }
    public String getNodeServerPort(){
        return NodeServerPort;
    }



   


}
