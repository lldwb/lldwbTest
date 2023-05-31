package top.lldwb.abc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 *
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 用户ID，自增1，主键，非空
     */
    private int userId;
    /**
     * 用户名，最长15个字符，非空，唯一
     */
    private String userName;
    /**
     * 密码，(密码+名字)使用MD5加密，最长32个字符，非空
     */
    private String userPassword;
    /**
     * 邮箱，最长255个字符，非空，唯一
     */
    private String userMail;

    /**
     * 用户状态，0表示未邮箱认证，1表示通过认证，2表示注销，非空
     */
    private int userState;
    /**
     * 访问秘钥，(用户名+用户邮箱)+(时间戳+密码)使用MD5加密，非空，唯一
     */
    private String userKey;
}
