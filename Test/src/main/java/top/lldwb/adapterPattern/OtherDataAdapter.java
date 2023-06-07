package top.lldwb.adapterPattern;

/**
 * @author wangl
 * @date 2023/6/5
 * 第三方接口的适配器,与自身系统的业务接口进行对接
 */
public class OtherDataAdapter implements UserDataService {
    /**
     * 声明第三方业务对象
     */
    private OtherDataService service = new OtherDataService();

    @Override
    public User getUser() {
        //调用第三方接口并返回字符串的信息
        String userName = service.getUser();
        //将字符串转换为内部接口的User对象
        User user = new User();
        user.setUserName(userName);
        return user;
    }
}