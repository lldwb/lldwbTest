package top.lldwb.city.service;

import org.nf.web.annotation.RequestMapping;
import org.nf.web.annotation.RequestParam;
import org.nf.web.servlet.View;
import org.nf.web.servlet.view.JsonView;
import top.lldwb.city.dao.CityInfoDAO;
import top.lldwb.city.model.CityInfo;
import top.lldwb.city.utils.PageUtil;
import top.lldwb.city.vo.PageVO;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CityInfoService {
    private CityInfoDAO cityInfoDAO = new CityInfoDAO();

    public PageVO<List<CityInfo>> selectCityInfo(int page, int length) {
        Long count = cityInfoDAO.selectLength();
        List<CityInfo> list = cityInfoDAO.selectPagination(PageUtil.page(page, length), length);
        return PageUtil.toPageVO(list,count);
    }

    /**
     * 模糊查询
     *
     * @param page
     * @param length
     * @return
     */
    public PageVO<List<CityInfo>> selectCityInfo(int page, int length, String name) {
        List<CityInfo> list = cityInfoDAO.selectPagination(PageUtil.page(page, length), length,name);
        Long count = cityInfoDAO.selectLength(name);
        return PageUtil.toPageVO(list,count);
    }
}
