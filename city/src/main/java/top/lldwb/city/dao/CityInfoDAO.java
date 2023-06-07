package top.lldwb.city.dao;

import org.nf.db.util.SqlExecutor;
import top.lldwb.city.entity.CityInfo;
import top.lldwb.city.utils.MySqlUtil;

import java.util.List;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class CityInfoDAO {

    /**
     * 分页查询
     * @param pagination 当前页数
     * @param count 最大显示
     * @return
     */
    public List<CityInfo> selectPagination(int pagination,int count){
        System.out.println(pagination+":"+count);
        return MySqlUtil.select("select city_id,city_name,city_code,province from city_info limit ?,?",new CityInfo(),pagination,count);
    }
}
