package top.lldwb.abc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.security.Key;
import java.util.*;

public class ABCTest {
    /**
     * 密钥
     */
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * 签发人
     */
    private static final String ISS = "lldwb.top";

    /**
     * 主题
     */
    private static final String SUBJECT = "JWT_AUTH";

    @Test
    public void test() throws IllegalAccessException, InstantiationException, JsonProcessingException {
        User user = new User();
        user.setUserName("1");
        user.setUserPassword("1");
        user.setUserMail("lldwb@lldwb.top");
        Map<String, String> claims = new HashMap<String, String>();
        claims.put("data", new ObjectMapper().writeValueAsString(user));
        System.out.println(new ObjectMapper().writeValueAsString(KEY));
        System.out.println();

        String token = Jwts.builder()
                // 签名 - 通过KEY定义的HS256的算法进行加密
                .signWith(KEY)
                // 设置签发人
                .setIssuer(ISS)
                // 设置主题
                .setSubject(SUBJECT)
                // 设置数据内容
                .setClaims(claims)
                // 设置签发时间
                .setIssuedAt(new Date())
                // 设置过期时间
                // new Date(毫秒):将毫秒转换为Date格式
                // System.currentTimeMillis():获取当前时间返回毫秒
                // 5 * 60 * 1000:5分钟
                .setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                // 设置jwt唯一标识
                .setId(UUID.randomUUID().toString())
                // 创建 jwt 令牌字符串
                .compact();

        // 打印出JWS字符串
        System.out.println(token);
        System.out.println();

        String string = Jwts.parserBuilder()
                // 设置签名密钥 - 通过 KEY 定义的HS256的算法进行解密
                .setSigningKey(KEY)
                .build()
                // 解析 token 中的数据载体部分
                .parseClaimsJws(token)
                // 获取载体数据
                .getBody()
                // 根据 name 和 type 获取对应的 value
                .get("data", String.class);

        System.out.println(string);
        System.out.println();
        User user1 = new ObjectMapper().readValue(string, User.class);
        System.out.println(user1.getUserName());
        System.out.println(user1.getUserMail());
    }
    @Test
    public void fss(){
        System.out.println("E:\\我的世界\\测压工具\\EndMinecraftPlus-master".replaceAll("\\\\[^\\\\]*$",""));
    }
}