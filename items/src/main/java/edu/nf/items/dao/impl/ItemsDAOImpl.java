package edu.nf.items.dao.impl;

import edu.nf.items.dao.ItemsDAO;
import edu.nf.items.entity.Items;
import edu.nf.items.utils.MySqlUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class ItemsDAOImpl implements ItemsDAO {
    @Override
    public void add(String itemName, BigDecimal itemPrice, LocalDateTime createTime, int status) {
        MySqlUtil.update("insert into Item_info(Item_name, Item_price, create_time, status) values (?,?,?,?)", itemName, itemPrice, createTime, status);
    }

    @Override
    public void upd(int itemId, String itemName, BigDecimal itemPrice, LocalDateTime createTime, int status) {
        MySqlUtil.update("update Item_info set itemName=?, itemPrice=?, createTime=?, status=? where Item_id=?", itemName, itemPrice, createTime, status, itemId);
    }

    @Override
    public void del(int itemId) {
        MySqlUtil.update("delete from Item_info where Item_id=?", itemId);
    }

    @Override
    public List<Items> get() {
        return MySqlUtil.queryList(Items.class, "select Item_id,Item_name,Item_price,create_time,status from Item_info");
    }

    @Override
    public List<Items> getByStatus(int status) {
        return MySqlUtil.queryList(Items.class, "select Item_id,Item_name,Item_price,create_time,status from Item_info sex status=?", status);
//        Item_id,Item_name,Item_price,create_time,status
    }
}

