package top.lldwb.templateMethod;

/**
 * 英语老师
 */
public class EnglishTeacher implements Teacher{
    @Override
    public void callTheRoll() {
        System.out.println("英语老师点名");
    }

    @Override
    public void prelection() {
        System.out.println("英语老师讲课");
    }

    @Override
    public void assignment() {
        System.out.println("英语老师布置作业");
    }
}
