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
    public View addBookcardInfo(@RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("deposit") String deposit, @RequestParam("createDate") String createDate) {
        System.out.println(111);
        System.out.println(name);
        System.out.println(sex);
        System.out.println(createDate);
        System.out.println(deposit);
        System.out.println(222);
        BookcardInfoService service = new BookcardInfoServiceImpl();
        service.add(name, sex, createDate, deposit);
        return new JsonView(success());
    }

    @RequestMapping("/bookcardInfo/get")
    public View getBookcardInfo() {
        BookcardInfoService service = new BookcardInfoServiceImpl();
        return new JsonView(success(service.get()));
    }
}
