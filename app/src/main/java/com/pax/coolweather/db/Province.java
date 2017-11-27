package com.pax.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * 省信息实体类
 *
 * @author ligq
 */
public class Province extends DataSupport {
    private int id;
    private String province;
    private int provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}