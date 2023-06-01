package com.yiliao.admin.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;




import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosDept {

  private long id;
  private String deptName;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createTime;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateTime;
  private long isDel;
  private String deptResp;
  private String deptRespPhone;
  private String deptRespEmail;
  private String deptRemark;

}
