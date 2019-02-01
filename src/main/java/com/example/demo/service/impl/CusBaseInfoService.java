package com.example.demo.service.impl;

import com.example.demo.bean.CusBaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qianduoduo
 * @date 2019/2/1  11:32
 */
public class CusBaseInfoService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CusBaseInfo> getAllCusBaseInfo() {
        //查询客户信息
        List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from cus_base_info");
        List<CusBaseInfo> cusBaseInfoList=new ArrayList<>();
        for (Map<String,Object> map:list ) {
            CusBaseInfo cusBaseInfo=new CusBaseInfo();
            //客户ID
            cusBaseInfo.setCusId(map.get("CUS_ID").toString());
            //客户编码
            cusBaseInfo.setCusCode(map.get("CUS_CODE").toString());
            //客户名称
            cusBaseInfo.setCusName(map.get("CUS_NAME").toString());
            //客户简称
            cusBaseInfo.setCusAbbr(map.get("CUS_ABBR").toString());
            //客户地址
            cusBaseInfo.setAddress(map.get("ADDRESS").toString());
            cusBaseInfoList.add(cusBaseInfo);
        }
        return cusBaseInfoList;
    }

    public CusBaseInfo saveCusBaseInfo(CusBaseInfo cusBaseInfo) {
        cusBaseInfo.setCusId("1");
        String sql="insert into cus_base_info(cus_id,cus_code,cus_name,cus_abbr,address) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{cusBaseInfo.getCusId(),
                cusBaseInfo.getCusCode(),
                cusBaseInfo.getCusName(),
                cusBaseInfo.getCusAbbr(),
                cusBaseInfo.getAddress()},new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR});
        //获取客户信息
        return getCusBaseInfoById(cusBaseInfo.getCusId());
    }

    public CusBaseInfo getCusBaseInfoById(String cusId) {
        Map<String,Object> map=jdbcTemplate.queryForMap("select * from cus_base_info where cus_id = ?",cusId);
        CusBaseInfo cusBaseInfo=new CusBaseInfo();
        //客户ID
        cusBaseInfo.setCusId(map.get("CUS_ID").toString());
        //客户编码
        cusBaseInfo.setCusCode(map.get("CUS_CODE").toString());
        //客户名称
        cusBaseInfo.setCusName(map.get("CUS_NAME").toString());
        //客户简称
        cusBaseInfo.setCusAbbr(map.get("CUS_ABBR").toString());
        //客户地址
        cusBaseInfo.setAddress(map.get("ADDRESS").toString());
        return cusBaseInfo;
    }

}
