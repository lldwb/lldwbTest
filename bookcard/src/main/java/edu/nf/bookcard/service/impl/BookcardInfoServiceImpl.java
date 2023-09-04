package edu.nf.bookcard.service.impl;

import edu.nf.bookcard.dao.BookcardInfoDAO;
import edu.nf.bookcard.dao.impl.BookcardInfoDAOImpl;
import edu.nf.bookcard.entity.BookcardInfo;
import edu.nf.bookcard.service.BookcardInfoService;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class BookcardInfoServiceImpl implements BookcardInfoService {
    @Override
    public void add(String name, String sex, String createDate, String deposit) {
        BookcardInfoDAO dao = new BookcardInfoDAOImpl();
        dao.add(name, sex, createDate, deposit);
    }

    @Override
    public void upd(int cid, String name, String sex, String createDate, String deposit) {
        BookcardInfoDAO dao = new BookcardInfoDAOImpl();
        dao.upd(cid, name, sex, createDate, deposit);
    }

    @Override
    public void del(int cid) {
        BookcardInfoDAO dao = new BookcardInfoDAOImpl();
        dao.del(cid);
    }

    @Override
    public List<BookcardInfo> get(String sex) {
        BookcardInfoDAO dao = new BookcardInfoDAOImpl();
        if ("".equals(sex)|| sex ==null|| sex.isEmpty()){
            return dao.get();
        }else
            return  dao.getBySex(sex);
    }
}
