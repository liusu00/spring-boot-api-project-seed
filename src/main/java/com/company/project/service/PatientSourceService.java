package com.company.project.service;
import com.company.project.model.PatientSource;
import com.company.project.core.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2020/11/12.
 */
public interface PatientSourceService extends Service<PatientSource> {
    List<Map> findIdAndName();

}
