package edu.nf.bookcard.controller;

import edu.nf.bookcard.service.BookcardInfoService;
import edu.nf.bookcard.service.impl.BookcardInfoServiceImpl;
import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;


/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class BookcardInfoController extends BaseController {
    @RequestMapping("/bookcardInfo/add")
    public View addBookcardInfo(@RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("createDate") String createDate, @RequestParam("deposit") String deposit) {
        BookcardInfoService service = new BookcardInfoServiceImpl();
        service.add(name, sex, createDate, deposit);
        return new JsonView(success());
    }

    @RequestMapping("/bookcardInfo/upd")
    public View updBookcardInfo(@RequestParam("cid") int cid, @RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("createDate") String createDate, @RequestParam("deposit") String deposit) {
        BookcardInfoService service = new BookcardInfoServiceImpl();
        service.upd(cid, name, sex, createDate, deposit);
        return new JsonView(success());
    }

    @RequestMapping("/bookcardInfo/del")
    public View delBookcardInfo(@RequestParam("cid") int cid) {
        BookcardInfoService service = new BookcardInfoServiceImpl();
        service.del(cid);
        return new JsonView(success());
    }

    @RequestMapping("/bookcardInfo/get")
    public View getBookcardInfo() {
        BookcardInfoService service = new BookcardInfoServiceImpl();
        return new JsonView(success(service.get()));
    }
}
