package edu.nf.bookcard.dao.impl;

import edu.nf.bookcard.dao.BookcardInfoDAO;
import edu.nf.bookcard.entity.BookcardInfo;
import edu.nf.bookcard.utils.MySqlUtil;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class BookcardInfoDAOImpl implements BookcardInfoDAO {
    @Override
    public void add(String name, String sex, String createDate, String deposit) {
        MySqlUtil.update("insert into bookcard_info(name, sex, create_date, deposit) values (?,?,?,?)", name, sex, createDate, deposit);
    }

    @Override
    public void upd(int cid, String name, String sex, String createDate, String deposit) {
        MySqlUtil.update("update bookcard_info set name=?, sex=?, create_date=?, deposit=? where cid=?", name, sex, createDate, deposit, cid);
    }

    @Override
    public void del(int cid) {
        MySqlUtil.update("delete from bookcard_info where cid=?", cid);
    }

    @Override
    public List<BookcardInfo> get() {
        return MySqlUtil.queryList(BookcardInfo.class, "select cid,name, sex, create_date, deposit from bookcard_info");
    }

    @Override
    public List<BookcardInfo> getBySex(String sex) {
        return MySqlUtil.queryList(BookcardInfo.class, "select cid,name, sex, create_date, deposit from bookcard_info sex sex=?",sex);
    }
}
