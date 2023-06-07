package Simple.Factory.Pattern;

interface Animal {
    /**
     * 动物叫
     */
    void cry();
    static Animal judge(String name){
        if ("狗".equals(name)){
            return new Dog();
        } else if ("猪".equals(name)) {
            return new Pig();
        }else {
            return null;
        }
    }
}