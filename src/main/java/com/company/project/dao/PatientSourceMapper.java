package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.PatientSource;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface PatientSourceMapper extends Mapper<PatientSource> {
    @Select("SELECT\n" +
            "\tCONCAT_WS( '-', b.NAME, c.NAME, d.NAME ) name,\n" +
            "\tCONCAT_WS( '-', b.id, c.id, d.id ) id \n" +
            "FROM\n" +
            "\tclc_patient_source a\n" +
            "\tLEFT JOIN ( SELECT * FROM clc_patient_source WHERE del_flag = 0 ) b ON a.id = b.parent_id\n" +
            "\tLEFT JOIN ( SELECT * FROM clc_patient_source WHERE del_flag = 0 ) c ON b.id = c.parent_id\n" +
            "\tLEFT JOIN ( SELECT * FROM clc_patient_source WHERE del_flag = 0 ) d ON c.id = d.parent_id \n" +
            "WHERE\n" +
            "\ta.parent_id = '0' \n" +
            "\tAND a.del_flag = '0'")
    List<Map> findIdAndName();

}