package top.lldwb.templateMethod;

/**
 * 体育老师
 */
public class SportsTeacher implements Teacher{
    @Override
    public void callTheRoll() {
        System.out.println("体育老师点名");
    }

    @Override
    public void prelection() {
        System.out.println("体育老师讲课");
    }

    @Override
    public void assignment() {}

    @Override
    public Boolean hook(){
        return false;
    }
}
