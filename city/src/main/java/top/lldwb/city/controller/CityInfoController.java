package top.lldwb.city.controller;

import org.nf.web.annotation.Model;
import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.city.dao.CityInfoDAO;
import top.lldwb.city.model.CityInfo;
import top.lldwb.city.service.CityInfoService;
import top.lldwb.city.vo.PageVO;

import javax.servlet.http.Part;
import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CityInfoController {
    private CityInfoDAO cityInfoDAO = new CityInfoDAO();
    private CityInfoService cityInfoService = new CityInfoService();

    @RequestMapping("/selectCityInfo")
    public View selectCityInfo(@RequestParam("page") int page, @RequestParam("length") int length) {
        PageVO<List<CityInfo>> pageVO = cityInfoService.selectCityInfo(page, length);
        JsonView view = new JsonView(pageVO);
        return view;
    }

    /**
     * 模糊查询
     *
     * @param page
     * @param length
     * @return
     */
    @RequestMapping("/selectCityInfoFuzzy")
    public View selectCityInfoFuzzy(@RequestParam("page") int page, @RequestParam("length") int length, @RequestParam("name") String name) {
        PageVO<List<CityInfo>> pageVO = cityInfoService.selectCityInfo(page, length, name);
        JsonView view = new JsonView(pageVO);
        return view;
    }

    @RequestMapping("/deleteCityInfo")
    public View deleteCityInfo(@RequestParam("cityId") int cityId) {
        cityInfoDAO.deleteCityInfo(cityId);
        return null;
    }

    @RequestMapping("updateCityInfo")
    public View updateCityInfo(@Model CityInfo cityInfo) {
        cityInfoDAO.updateCityInfo(cityInfo);
        return null;
    }

    @RequestMapping("/file")
    public void upload(Part[] parts){
        for (Part part:parts){
            System.out.println(part.getName());
            System.out.println(part.getSize());
            System.out.println(part.getContentType());
            System.out.println("===================-0987654321");
        }
    }
}
