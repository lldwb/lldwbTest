package top.lldwb.city.controller;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.DefaultView;
import org.nf.web.servlet.view.JsonView;
import org.nf.web.servlet.view.RedirectView;
import top.lldwb.city.dao.CityInfoDAO;
import top.lldwb.city.entity.CityInfo;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CityInfoController {
    @RequestMapping("/selectCityInfo")
    public View selectCityInfo(@RequestParam("pagination") int pagination, @RequestParam("count") int count) {
        CityInfoDAO cityInfoDAO = new CityInfoDAO();
        List<CityInfo> list = cityInfoDAO.selectPagination(pagination, count);
        JsonView view = new JsonView(list);
        return view;
    }

    @RequestMapping("/deleteCityInfo")
    public View deleteCityInfo(@RequestParam("cityId") int cityId){
        System.out.println(cityId);
        CityInfoDAO cityInfoDAO = new CityInfoDAO();
        cityInfoDAO.deleteCityInfo(cityId);
        System.out.println(cityId);
        return null;
    }
}
