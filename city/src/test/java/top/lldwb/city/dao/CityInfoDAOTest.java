package top.lldwb.city.dao;

import org.junit.jupiter.api.Test;
import top.lldwb.city.entity.CityInfo;
import top.lldwb.city.utils.MySqlUtil;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CityInfoDAOTest {

    @Test
    public void selectPagination(){
        List<CityInfo> list = new CityInfoDAO().selectPagination(0,41);
        list.forEach(cityInfo -> System.out.println(cityInfo.getCityName()));
    }
}
