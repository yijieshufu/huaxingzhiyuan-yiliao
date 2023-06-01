package com.yiliao.admin.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosDoc {

  private long id;
  private String docName;
  private String docCode;
  private String docPos;
  private String docNick;
  private String docPwd;
  private long docDeptId;
  private String docSex;
  private String docPhone;
  private String docIntro;
  private String docSkill;
  private long powId;
  private long picId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createTime;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateTime;
  private long isDel;
  private long roleId;

}
