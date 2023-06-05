package top.lldwb.templateMethod;

/**
 * 老师接口
 */
public interface Teacher {
    /**
     * 点名
     */
    void callTheRoll();

    /**
     * 讲课
     */
    void prelection();

    /**
     * 作业
     */
    void assignment();

    /**
     * 这就是模版方法，将业务执行的步骤顺序封装在这个方法中
     * 并暴露给客户端调用
     */
    default void attendClass() {
        callTheRoll();
        prelection();
        //判断钩子是否剔除了此方法
        if (hook()){
            assignment();
        }
    }

    /**
     * 钩子方法，子类负责重写这个方法来剔除不需要的步骤，
     * 默认值为true表示不剔除
     * @return
     */
    default Boolean hook(){
        return true;
    }
}
