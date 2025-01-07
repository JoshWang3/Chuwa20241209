package com.db_practice.repository;

import com.db_practice.entity.OmsCompanyAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OmsCompanyAddressDao {
    int deleteByPrimaryKey(Long id);

    int insert(OmsCompanyAddress record);

    int insertSelective(OmsCompanyAddress record);

    OmsCompanyAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmsCompanyAddress record);

    int updateByPrimaryKey(OmsCompanyAddress record);

    List<OmsCompanyAddress> fetchAll();

    List<OmsCompanyAddress> fetchTopThree();

    int updateAllPhone(String phone);
}