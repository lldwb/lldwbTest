package top.lldwb.city.controller;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.city.dao.CityInfoDAO;
import top.lldwb.city.entity.CityInfo;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CityInfoController {
    @RequestMapping("/getUser")
    public View getUser(@RequestParam("pagination") int pagination, @RequestParam("count") int count) {
        System.out.println(1234567);
        CityInfoDAO cityInfoDAO = new CityInfoDAO();
        List<CityInfo> list = cityInfoDAO.selectPagination(pagination, count);
        JsonView view = new JsonView(list);
        System.out.println("421fa");
        System.out.println(list);
        return view;
    }
}
