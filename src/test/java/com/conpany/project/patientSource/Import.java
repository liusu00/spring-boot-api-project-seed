package com.conpany.project.patientSource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.project.model.PatientSource;
import com.company.project.service.PatientSourceService;
import com.conpany.project.Tester;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import javafx.scene.control.Cell;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.*;
import java.util.stream.Collectors;

public class Import extends Tester {

    @Autowired
    private PatientSourceService patientSourceService;



    @Test
    @Rollback(false)
    public void imports() throws Exception {

        String result = "[{\"levelOneId\":1203,\"levelOneSourceName\":\"自然到诊\",\"levelTwoId\":1204,\"levelTwoSourceName\":\"自然到诊\",\"levelThreeId\":0,\"levelThreeSourceName\":\"\",\"mobile\":null,\"nameCode\":\"zrdz|zrdz\"},{\"levelOneId\":1205,\"levelOneSourceName\":\"点诊医生\",\"levelTwoId\":1206,\"levelTwoSourceName\":\"点诊医生\",\"levelThreeId\":0,\"levelThreeSourceName\":\"\",\"mobile\":null,\"nameCode\":\"dzys|dzys\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1212,\"levelTwoSourceName\":\"社区义诊\",\"levelThreeId\":0,\"levelThreeSourceName\":\"\",\"mobile\":null,\"nameCode\":\"qd|sqyz\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1212,\"levelTwoSourceName\":\"社区义诊\",\"levelThreeId\":1660,\"levelThreeSourceName\":\"赵亚香\",\"mobile\":null,\"nameCode\":\"qd|sqyz|zyx\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1212,\"levelTwoSourceName\":\"社区义诊\",\"levelThreeId\":2042,\"levelThreeSourceName\":\"贺文胜\",\"mobile\":null,\"nameCode\":\"qd|sqyz|hws\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1212,\"levelTwoSourceName\":\"社区义诊\",\"levelThreeId\":2133,\"levelThreeSourceName\":\"马椠咏\",\"mobile\":null,\"nameCode\":\"qd|sqyz|mqy\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1212,\"levelTwoSourceName\":\"社区义诊\",\"levelThreeId\":2198,\"levelThreeSourceName\":\"刘娌娌\",\"mobile\":null,\"nameCode\":\"qd|sqyz|lll\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1212,\"levelTwoSourceName\":\"社区义诊\",\"levelThreeId\":2259,\"levelThreeSourceName\":\"詹伟\",\"mobile\":null,\"nameCode\":\"qd|sqyz|zw\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1212,\"levelTwoSourceName\":\"社区义诊\",\"levelThreeId\":2270,\"levelThreeSourceName\":\"刘涛\",\"mobile\":null,\"nameCode\":\"qd|sqyz|lt\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1212,\"levelTwoSourceName\":\"社区义诊\",\"levelThreeId\":2298,\"levelThreeSourceName\":\"喻辉\",\"mobile\":null,\"nameCode\":\"qd|sqyz|yh\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1212,\"levelTwoSourceName\":\"社区义诊\",\"levelThreeId\":2299,\"levelThreeSourceName\":\"吕少六\",\"mobile\":null,\"nameCode\":\"qd|sqyz|lsl\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1214,\"levelTwoSourceName\":\"小小牙医\",\"levelThreeId\":0,\"levelThreeSourceName\":\"\",\"mobile\":null,\"nameCode\":\"qd|xxyy\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1216,\"levelTwoSourceName\":\"异业合作\",\"levelThreeId\":0,\"levelThreeSourceName\":\"\",\"mobile\":null,\"nameCode\":\"qd|yyhz\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1216,\"levelTwoSourceName\":\"异业合作\",\"levelThreeId\":1504,\"levelThreeSourceName\":\"番茄田艺术\",\"mobile\":null,\"nameCode\":\"qd|yyhz|fqtys\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1216,\"levelTwoSourceName\":\"异业合作\",\"levelThreeId\":1507,\"levelThreeSourceName\":\"反弹蹦床公园\",\"mobile\":null,\"nameCode\":\"qd|yyhz|fdbcgy\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1216,\"levelTwoSourceName\":\"异业合作\",\"levelThreeId\":1508,\"levelThreeSourceName\":\"山姆会员商店\",\"mobile\":null,\"nameCode\":\"qd|yyhz|smhysd\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1216,\"levelTwoSourceName\":\"异业合作\",\"levelThreeId\":1509,\"levelThreeSourceName\":\"长沙市交通运输局\",\"mobile\":null,\"nameCode\":\"qd|yyhz|cssjtysj\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1216,\"levelTwoSourceName\":\"异业合作\",\"levelThreeId\":1510,\"levelThreeSourceName\":\"招商银行\",\"mobile\":null,\"nameCode\":\"qd|yyhz|zsyx\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1216,\"levelTwoSourceName\":\"异业合作\",\"levelThreeId\":1511,\"levelThreeSourceName\":\"招商信诺\",\"mobile\":null,\"nameCode\":\"qd|yyhz|zsxn\"},{\"levelOneId\":1211,\"levelOneSourceName\":\"渠道\",\"levelTwoId\":1216,\"levelTwoSourceName\":\"异业合作\",\"levelThreeId\":1515,\"levelThreeSourceName\":\"联通湖南分公司\",\"mobile\":null,\"nameCode\":\"qd|yyhz|lthnfgs\"}]";
        JSONArray array = JSON.parseArray(result);
        Iterator<Object> iterator = array.iterator();
        Map<Integer,String> levelOneMap = new HashMap<>();
        Table<Integer,Integer,String> levelTwoMap= HashBasedTable.create();
        Table<Integer,Integer,String> levelThreeMap= HashBasedTable.create();
        while (iterator.hasNext()){
            JSONObject next = (JSONObject)iterator.next();

            String levelOneSourceName = next.getString("levelOneSourceName");
            Integer levelOneId = next.getInteger("levelOneId");
            levelOneMap.put(levelOneId,levelOneSourceName);

            String levelTwoSourceName = next.getString("levelTwoSourceName");
            Integer levelTwoId = next.getInteger("levelTwoId");
            levelTwoMap.put(levelTwoId, levelOneId,levelTwoSourceName);

            String levelThreeSourceName = next.getString("levelThreeSourceName");
            Integer levelThreeId = next.getInteger("levelThreeId");
            if(levelThreeId != 0)
                levelThreeMap.put(levelThreeId, levelTwoId, levelThreeSourceName);

        }

        Iterator<Map.Entry<Integer, String>> levelOneIterator = levelOneMap.entrySet().iterator();
        List<PatientSource> levelOneList = new ArrayList<>();
        List<PatientSource> levelTwoList = new ArrayList<>();
        List<PatientSource> levelThreeList = new ArrayList<>();
        while(levelOneIterator.hasNext()){
            Map.Entry<Integer, String> next = levelOneIterator.next();
            Integer key = next.getKey();
            String value = next.getValue();
            PatientSource info = createPatientSource(key, value, null);
            if("自然到诊".equals(value)){
                info.setParentId("3");
            }else if("点诊医生".equals(value)){
                info.setParentId("4");
            }else if("渠道".equals(value)){
                info.setParentId("2");
            }
            levelOneList.add(info);
        }

        Set<Table.Cell<Integer, Integer, String>> cells = levelTwoMap.cellSet();
        for(Table.Cell<Integer, Integer, String> temp:cells){
            PatientSource info = createPatientSource(temp.getRowKey(), temp.getValue(), temp.getColumnKey());
            levelTwoList.add(info);
        }

        Set<Table.Cell<Integer, Integer, String>> cellss = levelThreeMap.cellSet();
        for(Table.Cell<Integer, Integer, String> temp:cellss){
            PatientSource info = createPatientSource(temp.getRowKey(), temp.getValue(), temp.getColumnKey());
            levelThreeList.add(info);
        }


        List<PatientSource> list = new ArrayList<>();
        list.addAll(levelOneList);
        list.addAll(levelTwoList);
        list.addAll(levelThreeList);
        List<String> ids = list.stream().map(v -> v.getId()).collect(Collectors.toList());
        System.out.println(ids);
        List<PatientSource> byIds = patientSourceService.findByIds(StringUtils.join(ids,","));
        List<String> collect = byIds.stream().map(v -> v.getId()).collect(Collectors.toList());

        list = list.stream().filter(s-> !collect.contains(s.getId()) ).collect(Collectors.toList());

        System.out.println(list);
        patientSourceService.save(list);


    }
    private PatientSource createPatientSource(Integer key, String value, Integer parentId){
        PatientSource patientSource = new PatientSource();
        patientSource.setId(String.valueOf(key));
        patientSource.setName(value);
        patientSource.setDelFlag("0");
        patientSource.setType((byte)1);
        patientSource.setCreateBy("1");
        patientSource.setCreateDate(new Date());
        patientSource.setParentId(String.valueOf(parentId));
        return patientSource;
    }


}
