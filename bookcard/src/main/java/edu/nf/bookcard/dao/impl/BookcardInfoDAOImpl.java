package edu.nf.bookcard.dao.impl;

import edu.nf.bookcard.dao.BookcardInfoDAO;
import edu.nf.bookcard.entity.BookcardInfo;
import edu.nf.bookcard.utils.MySqlUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class BookcardInfoDAOImpl implements BookcardInfoDAO {
    @Override
    public void add(String name, String sex, Date createDate, BigDecimal deposit) {
        MySqlUtil.update("insert into bookcard_info(name, sex, create_date, deposit) values (?,?,?,?);", name, sex, createDate, deposit);
    }

    @Override
    public List<BookcardInfo> get() {
        return MySqlUtil.queryList(BookcardInfo.class, "select cid,name, sex, create_date, deposit from bookcard_info");
    }
}
