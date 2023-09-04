package edu.nf.items.entity;

import lombok.Data;
import org.nf.db.util.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class Items {
    @Column("Item_id")
    private Integer itemId;
    @Column("Item_name")
    private String itemName;
    @Column("Item_price")
    private BigDecimal itemPrice;
    @Column("create_time")
    private LocalDateTime createTime;
    @Column("status")
    private Integer status;
}
