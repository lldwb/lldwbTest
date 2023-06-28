package top.lldwb.city.model;

import lombok.Data;
import org.nf.db.util.Column;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@Data
public class CityInfo {
    @Column("city_id")
    private Integer cityId;
    @Column("city_name")
    private String cityName;
    @Column("city_code")
    private String cityCode;
    @Column("province")
    private String province;
}
