package com.yiliao.admin.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosSick {

  private long id;
  private String sickName;
  private String sickAge;
  private long sickSex;
  private String sickCard;
  private String sickPhone;
  private long sickIllId;
  private long sickTreatId;
  private String sickAddr;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createTime;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateTime;
  private long isDel;
  private String cardId;
  private long sickStatus;
  private long orderId;


}
