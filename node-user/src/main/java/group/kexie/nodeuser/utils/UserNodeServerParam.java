package group.kexie.nodeuser.utils;

import group.kexie.logconsumer.utils.BasicNodeServerParam;
import org.springframework.stereotype.Component;

/**
 * @author tangbo
 * @date 2018/11/18 19:16
 * @description: 本服务的常量
 */
@Component
public  class UserNodeServerParam extends BasicNodeServerParam {

    /**下面是从微信服务器端获取信息时的参数*/
    /*微信公共Api*/
    public static final String WeiXinApi="https://api.weixin.qq.com/sns/jscode2session";
    /*HeiKeOnline小程序*/
    public static final String AppId1="wx7247cfc9c0b272b8";
    public static final String Secret1="19815bfbec278cf188c7daa8a8ee1b52";
    /*HeiKeMarkets小程序*/
    public static final String AppId2="wx17a8b182dd169e9e";
    public static final String Secret2="eb3ee5173b5d94bedab58af76a28b4bb";

    public static final String RegisteMsg="恭喜你成为黑科Online的首批用户，在今后的相伴的日子里，希望能够得到您的信任和支持。加油吧 黑科大学子^_^";



}
