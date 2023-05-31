package SimpleFactoryPattern;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        Animal.judge("狗").cry();
        Animal.judge("猪").cry();
    }
}
