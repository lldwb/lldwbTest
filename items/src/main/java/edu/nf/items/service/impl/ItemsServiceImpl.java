package edu.nf.items.service.impl;

import edu.nf.items.dao.ItemsDAO;
import edu.nf.items.dao.impl.ItemsDAOImpl;
import edu.nf.items.entity.Items;
import edu.nf.items.service.ItemsService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class ItemsServiceImpl implements ItemsService {
    @Override
    public void add(String itemName, BigDecimal itemPrice, LocalDateTime createTime, int status) {
        ItemsDAO dao = new ItemsDAOImpl();
        dao.add(itemName, itemPrice, createTime, status);
    }

    @Override
    public void upd(int itemId, String itemName, BigDecimal itemPrice, LocalDateTime createTime, int status) {
        ItemsDAO dao = new ItemsDAOImpl();
        dao.upd(itemId, itemName, itemPrice, createTime, status);
    }

    @Override
    public void del(int itemId) {
        ItemsDAO dao = new ItemsDAOImpl();
        dao.del(itemId);
    }

    @Override
    public List<Items> get(int status) {
        ItemsDAO dao = new ItemsDAOImpl();
        if ("".equals(status)||status==-1) {
            return dao.get();
        } else
            return dao.getByStatus(status);
    }
}
