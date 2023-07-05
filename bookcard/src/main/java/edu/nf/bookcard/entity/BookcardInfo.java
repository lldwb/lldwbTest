package edu.nf.bookcard.entity;

import lombok.Data;
import org.nf.db.util.Column;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class BookcardInfo {
    @Column("cid")
    private Integer cid;
    @Column("name")
    private String name;
    @Column("sex")
    private String sex;
    @Column("create_date")
    private Object createDate;
    @Column("deposit")
    private BigDecimal deposit;
}
