package top.lldwb.city.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class PageVO<T> extends ResultVO<T>{
    /**
     * 总记录数
     */
    private Long count;
}
