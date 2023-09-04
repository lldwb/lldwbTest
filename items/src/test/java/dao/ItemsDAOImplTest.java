package dao;

import edu.nf.items.dao.impl.ItemsDAOImpl;
import edu.nf.items.dao.ItemsDAO;
import org.junit.jupiter.api.Test;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class ItemsDAOImplTest {
    @Test
    public void add(){
        ItemsDAO dao = new ItemsDAOImpl();
//        dao.add("1","a",new Date(), BigDecimal.valueOf(11));
    }
    @Test
    public void get(){
        ItemsDAO dao = new ItemsDAOImpl();
        System.out.println(dao.get());
    }
}
