package com.company.project.core;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import java.util.List;

public interface InsertUidListMapper<T> {
    @InsertProvider(type = MySpecialProvider.class, method = "dynamicSQL")
    int insertList(List<T> recordList);

}
