package top.lldwb.city.dao;

import top.lldwb.city.model.CityInfo;
import top.lldwb.city.utils.MySqlUtil;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CityInfoDAO {

    public Long selectLength(){
        return MySqlUtil.selectColumn("select count(*) from city_info");
    }

    public Long selectLength(String name){
        return MySqlUtil.selectColumn("select count(*) from city_info where city_name like ?","%" + name + "%");
    }

    /**
     * 分页查询
     *
     * @param begin  当前页数
     * @param length 最大显示
     * @return
     */
    public List<CityInfo> selectPagination(int begin, int length) {
        return MySqlUtil.selectList("select city_id,city_name,city_code,province from city_info limit ?,?", new CityInfo(), begin, length);
    }

    /**
     * 分页查询 + 模糊查询
     *
     * @param name   查询值
     * @param begin  当前页数
     * @param length 最大显示
     * @return
     */
    public List<CityInfo> selectPagination(int begin, int length,String name) {
        return MySqlUtil.selectList("select city_id,city_name,city_code,province from city_info where city_name like ? limit ?,?", new CityInfo(), "%" + name + "%", begin, length);
    }

    /**
     * 删除
     *
     * @param cityId 需要删除的 Id
     */
    public void deleteCityInfo(int cityId) {
        MySqlUtil.update("delete from city_info where city_id=?", cityId);
    }

    public void updateCityInfo(CityInfo cityInfo) {
        MySqlUtil.update("update city_info set city_name=?,city_code=?,province=? where city_id=?", cityInfo.getCityName(), cityInfo.getCityCode(), cityInfo.getProvince(), cityInfo.getCityId());
    }
}
