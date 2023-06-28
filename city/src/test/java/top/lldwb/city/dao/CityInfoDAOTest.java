package top.lldwb.city.dao;

import org.junit.jupiter.api.Test;
import top.lldwb.city.controller.CityInfoController;
import top.lldwb.city.model.CityInfo;
import top.lldwb.city.service.CityInfoService;
import top.lldwb.city.utils.PageUtil;
import top.lldwb.city.vo.PageVO;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CityInfoDAOTest {
    @Test
    public void selectColumnTest(){
        System.out.println(new CityInfoController().selectCityInfo(1,10).toString());
    }

    @Test
    public void updateCityInfoTest(){
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCityId(101010400);
        cityInfo.setCityName("顺义");
        cityInfo.setCityCode("shunyi");
        cityInfo.setProvince("北京和河北");
        new CityInfoDAO().updateCityInfo(cityInfo);
    }
}
