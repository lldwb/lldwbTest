package top.lldwb.adapterPattern;

/**
 * @author wangl
 * @date 2023/6/5
 */
public class UserDataServiceImpl implements UserDataService {

    @Override
    public User getUser() {
        System.out.println("从本地数据库中查询用户对象");
        //模拟从数据库查询返回一个user对象
        User user = new User();
        user.setUserName("zing");
        return user;
    }
}