package edu.nf.items.controller;

import edu.nf.items.service.ItemsService;
import edu.nf.items.service.impl.ItemsServiceImpl;
import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class ItemsController extends BaseController {
    @RequestMapping("/bookcardInfo/add")
    public View addBookcardInfo(@RequestParam("name") String itemName, @RequestParam("sex") BigDecimal itemPrice, @RequestParam("createDate") LocalDateTime createTime, @RequestParam("deposit") int status) {
        ItemsService service = new ItemsServiceImpl();
        service.add(itemName, itemPrice, createTime, status);
        return new JsonView(success());
    }

    @RequestMapping("/bookcardInfo/upd")
    public View updBookcardInfo(@RequestParam("cid") int itemId, @RequestParam("name") String itemName, @RequestParam("sex") BigDecimal itemPrice, @RequestParam("createDate") LocalDateTime createTime, @RequestParam("deposit") int status) {
        ItemsService service = new ItemsServiceImpl();
        service.upd(itemId, itemName, itemPrice, createTime, status);
        return new JsonView(success());
    }

    @RequestMapping("/bookcardInfo/del")
    public View delBookcardInfo(@RequestParam("cid") int cid) {
        ItemsService service = new ItemsServiceImpl();
        service.del(cid);
        return new JsonView(success());
    }

    @RequestMapping("/bookcardInfo/get")
    public View getBookcardInfo(@RequestParam("status") int status) {
        ItemsService service = new ItemsServiceImpl();
        return new JsonView(success(service.get(status)));
    }
}
