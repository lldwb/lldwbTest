package edu.nf.bookcard.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class BookcardInfo {
    private Integer cid;
    private String name;
    private String sex;
    private Date createDate;
    private BigDecimal deposit;
}
