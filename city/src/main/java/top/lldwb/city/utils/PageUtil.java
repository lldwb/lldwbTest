package top.lldwb.city.utils;

import top.lldwb.city.model.CityInfo;
import top.lldwb.city.vo.PageVO;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class PageUtil {
    public static int page(int page, int length) {
        return page <= 1 ? 0 : (page - 1) * length;
    }

    public static PageVO<List<CityInfo>> toPageVO(List<CityInfo> list,Long count){
        PageVO pageVO = new PageVO();
        pageVO.setCount(count);
        pageVO.setData(list);
        pageVO.setCode(0);
        return pageVO;
    }
}
