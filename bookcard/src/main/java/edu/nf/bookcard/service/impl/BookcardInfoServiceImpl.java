package edu.nf.bookcard.service.impl;

import edu.nf.bookcard.entity.BookcardInfo;
import edu.nf.bookcard.dao.BookcardInfoDAO;
import edu.nf.bookcard.dao.impl.BookcardInfoDAOImpl;
import edu.nf.bookcard.service.BookcardInfoService;

import java.sql.Date;
import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class BookcardInfoServiceImpl implements BookcardInfoService {
    @Override
    public void add(BookcardInfo bookcardInfo) {
        BookcardInfoDAO dao = new BookcardInfoDAOImpl();
        dao.add(bookcardInfo.getName(),bookcardInfo.getSex(), (Date) bookcardInfo.getCreateDate(),bookcardInfo.getDeposit());
    }

    @Override
    public List<BookcardInfo> get() {
        BookcardInfoDAO dao = new BookcardInfoDAOImpl();
        return dao.get();
    }
}
