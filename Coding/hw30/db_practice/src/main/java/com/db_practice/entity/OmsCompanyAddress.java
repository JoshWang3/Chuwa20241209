package com.db_practice.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 公司收发货地址表
 * oms_company_address
 */
@Data
public class OmsCompanyAddress implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 地址名称
     */
    private String addressName;

    /**
     * 默认发货地址：0->否；1->是
     */
    private Integer sendStatus;

    /**
     * 是否默认收货地址：0->否；1->是
     */
    private Integer receiveStatus;

    /**
     * 收发货⼈姓名
     */
    private String name;

    /**
     * 收货⼈电话
     */
    private String phone;

    /**
     * 省/直辖市
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String region;

    /**
     * 详细地址
     */
    private String detailAddress;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public String getAddressName() {
        return addressName;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public Integer getReceiveStatus() {
        return receiveStatus;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getDetailAddress() {
        return detailAddress;
    }
}