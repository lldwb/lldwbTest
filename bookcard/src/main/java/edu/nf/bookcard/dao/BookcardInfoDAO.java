package edu.nf.bookcard.dao;

import edu.nf.bookcard.entity.BookcardInfo;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public interface BookcardInfoDAO {
    /**
     * 添加借书卡
     *
     * @param name       名字
     * @param sex        性别
     * @param createDate 时间
     * @param deposit    押金
     */
    void add(String name, String sex, Date createDate, BigDecimal deposit);

    /**
     * 查询所有借书卡
     *
     * @return 借书卡集合
     */
    List<BookcardInfo> get();
}
