package dao;

import edu.nf.bookcard.dao.impl.BookcardInfoDAOImpl;
import edu.nf.bookcard.dao.BookcardInfoDAO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class BookcardInfoDAOImplTest {
    @Test
    public void add(){
        BookcardInfoDAO dao = new BookcardInfoDAOImpl();
        dao.add("1","a",new Date(), BigDecimal.valueOf(11));
    }
    @Test
    public void get(){
        BookcardInfoDAO dao = new BookcardInfoDAOImpl();
        System.out.println(dao.get());
    }
}
