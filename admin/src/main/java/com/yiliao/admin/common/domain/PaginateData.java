package com.yiliao.admin.common.domain;

import lombok.Data;

import java.util.List;


@Data
public class PaginateData<T> {
    private Integer total;
    private List<T> records;
    private Integer currentPage;
    private Integer pageSize;
    private Integer pageCount;
}
