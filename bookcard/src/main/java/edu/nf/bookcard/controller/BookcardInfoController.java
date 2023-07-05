package edu.nf.bookcard.controller;

import edu.nf.bookcard.entity.BookcardInfo;
import edu.nf.bookcard.service.BookcardInfoService;
import edu.nf.bookcard.service.impl.BookcardInfoServiceImpl;
import org.nf.web.annotation.Model;
import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;

import java.util.List;


/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class BookcardInfoController extends BaseController {
    @RequestMapping("/bookcardInfo/add")
    public View add(@Model BookcardInfo bookcardInfo) {
        BookcardInfoService service = new BookcardInfoServiceImpl();
        service.add(bookcardInfo);
        return new JsonView(success());
    }

    @RequestMapping("/bookcardInfo/get")
    public View get() {
        BookcardInfoService service = new BookcardInfoServiceImpl();
        return new JsonView(success(service.get()));
    }
}
