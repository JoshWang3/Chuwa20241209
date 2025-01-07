package com.db_practice.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.io.Serializable;

@Document(collection = "oms_company_address")
@Data
public class OmsCompanyAddressMongo implements Serializable {
    /**
     * id
     */
    @Id
    private String id;

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

    public String getId() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public void setReceiveStatus(Integer receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
