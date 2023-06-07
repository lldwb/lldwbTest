package top.lldwb.servlet;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String userName;
    private Integer age;
    private Integer[] tel;
}
