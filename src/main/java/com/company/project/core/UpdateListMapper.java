package com.company.project.core;

import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface UpdateListMapper<T> {
    @UpdateProvider(type = MySpecialProvider.class, method = "dynamicSQL")
    int updateList(List<T> recordList);

    @UpdateProvider(type = MySpecialProvider.class, method = "dynamicSQL")
    int batchBlUpdate(List<T> recordList);

}
