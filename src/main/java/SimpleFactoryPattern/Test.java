package SimpleFactoryPattern;

import calculator.lldwb.top.ContainerFactory;
import top.lldwb.abc.User;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        System.out.println(ContainerFactory.getBean("user").getClass().getName());
        User user = ContainerFactory.getBean("user");
        user.setUserId(1);
        user = ContainerFactory.getBean("user");
        System.out.println(user.getUserId());
    }
}
