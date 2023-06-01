package com.yiliao.admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosSickIll {

  private long id;
  private String sickPrinc;
  private String docDiag;
  private String sickHis;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createTime;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateTime;
  private long isDel;
  private String sickProject;
  private String appraise;

}
