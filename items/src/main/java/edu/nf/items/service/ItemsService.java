package edu.nf.items.service;

import edu.nf.items.entity.Items;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public interface ItemsService {
    /**
     * 添加借书卡
     */
    void add(String itemName, BigDecimal itemPrice, LocalDateTime createTime, int status);

    /**
     * 修改
     */
    void upd(int itemId, String itemName, BigDecimal itemPrice, LocalDateTime createTime, int status);

    /**
     * 删除
     */
    void del(int itemId);

    /**
     * 查询所有借书卡
     *
     * @return 借书卡集合
     */
    List<Items> get(int status);
}
