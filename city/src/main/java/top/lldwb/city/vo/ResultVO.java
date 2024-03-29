package top.lldwb.city.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class ResultVO<T> {
    /**
     * 业务状态码
     */
    private Integer code;
    /**
     * 响应的消息
     */
    private String message;
    /**
     * 响应的数据
     */
    private T data;
}
