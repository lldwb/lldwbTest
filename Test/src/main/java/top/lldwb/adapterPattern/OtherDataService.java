package top.lldwb.adapterPattern;

/**
 * @author wangl
 * @date 2023/6/5
 * 第三方的接口服务，同样是返回用户信息
 */
public class OtherDataService {

    /**
     * 调用第三方接口返回的用户信息，是一个字符串
     * @return
     */
    public String getUser() {
        System.out.println("调用第三方接口...");
        return "user1";
    }
}