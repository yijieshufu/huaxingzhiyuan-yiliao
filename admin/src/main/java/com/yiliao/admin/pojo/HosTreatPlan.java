package com.yiliao.admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosTreatPlan {

  private long id;
  private long methodId;
  private long docId;
  private long sickId;
  private long nurseId;
  private long seeCount;
  private String seeBefore;
  private String seeAfter;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createTime;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateTime;
  private long isDel;
  private String treatInstru;
  private String treatPow;
  private String treatTiming;
  private String treatPric;
  private String treatmentSite;
  private long treatmentNumber;

}
