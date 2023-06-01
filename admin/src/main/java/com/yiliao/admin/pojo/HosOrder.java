package com.yiliao.admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosOrder {

  private long id;
  private long sickId;
  private long docId;
  private long seeId;
  private String medType;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date orderTime;
  private String seeStatus;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createTime;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateTime;
  private long isDel;

}
