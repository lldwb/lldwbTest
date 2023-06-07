package top.lldwb.abc;

public class A extends ABC {
    String name = "";
    A(){

    }A(String name){
        super();
        this.name = name;
    }
    public void output() {
        System.out.println("A");
    }
}
