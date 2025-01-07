package com.db_practice.controller;

import com.alibaba.fastjson2.JSON;
import com.db_practice.entity.OmsCompanyAddress;
import com.db_practice.entity.mongo.OmsCompanyAddressMongo;
import com.db_practice.repository.OmsCompanyAddressDao;
import com.db_practice.service.OmsCompanyAddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/oms/company-address")
public class TestController {

    private final OmsCompanyAddressDao omsCompanyAddressDao;
    private final OmsCompanyAddressService omsCompanyAddressService;

    public TestController(OmsCompanyAddressDao omsCompanyAddressDao, OmsCompanyAddressService omsCompanyAddressService) {
        this.omsCompanyAddressDao = omsCompanyAddressDao;
        this.omsCompanyAddressService = omsCompanyAddressService;
    }

    @GetMapping("/mysql")
    public String queryAllAddress(){
        List<OmsCompanyAddress> list = omsCompanyAddressDao.fetchAll();
        return JSON.toJSONString(list);
    }

    @GetMapping("/mysql/top-three")
    public String queryTopThree(){
        List<OmsCompanyAddress> list = omsCompanyAddressDao.fetchTopThree();
        return JSON.toJSONString(list);
    }

    @GetMapping("/mysql/all-phone")
    public String updateAllPhone(@RequestParam String phone){
        omsCompanyAddressDao.updateAllPhone(phone);
        List<OmsCompanyAddress> list = omsCompanyAddressDao.fetchAll();
        return JSON.toJSONString(list);
    }

    @GetMapping("/mysql/")
    public String updateAllPhone(@RequestParam Long id){
       omsCompanyAddressDao.deleteByPrimaryKey(id);
        return JSON.toJSONString("SUCCESS");
    }

    @GetMapping("/mongodb/")
    public String queryAllByMongo() {
        List<OmsCompanyAddressMongo> list = omsCompanyAddressService.findAll();

        return list.stream().map(OmsCompanyAddressMongo::getId).toList().toString();
    }

    @GetMapping("/mongodb/city")
    public String queryOneByMongo(@RequestParam String city) {
        List<OmsCompanyAddressMongo> list = omsCompanyAddressService.findByCity(city);
        return list.stream().map(OmsCompanyAddressMongo::getId).toList().toString();
    }

    @GetMapping("/mongodb/city-modification")
    public String updateByMongo(@RequestParam String id, @RequestParam String newCity) {
        Optional<OmsCompanyAddressMongo> omsCompanyAddressMongo = omsCompanyAddressService.findById(id);
        omsCompanyAddressMongo.ifPresent((info) -> {
                info.setCity(newCity);
                omsCompanyAddressService.save(info);
        });

        return JSON.toJSONString("SUCCESS");
    }

    @GetMapping("/mongodb/id")
    public String removeByMongo(@RequestParam String id) {
        omsCompanyAddressService.deleteById(id);
        return JSON.toJSONString("SUCCESS");
    }
}
