package edu.nf.items.dao;

import edu.nf.items.entity.Items;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public interface ItemsDAO {
    void add(String itemName, BigDecimal itemPrice, LocalDateTime createTime, int status);

    void upd(int itemId, String itemName, BigDecimal itemPrice, LocalDateTime createTime, int status);

    void del(int itemId);

    List<Items> get();

    List<Items> getByStatus(int status);
}
