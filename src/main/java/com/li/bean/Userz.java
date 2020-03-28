package com.li.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.google.gson.annotations.Expose;

import java.beans.Transient;
import java.util.Map;

public class Userz {

  public Userz(String account, String password, String name, String identity, Integer autoSign, String zSess, String latelyDate) {
    this.account = account;
    this.password = password;
    this.name = name;
    this.identity = identity;
    this.autoSign = autoSign;
    this.zSess = zSess;
    this.latelyDate = latelyDate;
  }

  public Userz() {
  }

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String account;

  @Expose(serialize = false,deserialize = false)
  private String password;
  private String name;
  private String identity;
  private Integer autoSign;
  private String latelyDate;

  public String getLatelyDate() {
    return latelyDate;
  }

  public void setLatelyDate(String latelyDate) {
    this.latelyDate = latelyDate;
  }
//  //用户下课堂编号及课堂名称
//  @TableField(exist = false)
//  private Map<String, String> ktMap;

  //用户下资源编号及是否已浏览
//  @TableField(exist = false)
//  private Map<String, String> zyMap;
//
//  public Map<String, String> getZyMap() {
//    return zyMap;
//  }
//
//  public void setZyMap(Map<String, String> zyMap) {
//    this.zyMap = zyMap;
//  }
//  public Map<String, String> getKtMap() {
//    return ktMap;
//  }
//
//  public void setKtMap(Map<String, String> ktMap) {
//    this.ktMap = ktMap;
//  }

  public String getzSess() {
    return zSess;
  }

  public void setzSess(String zSess) {
    this.zSess = zSess;
  }

  @Expose(serialize = false,deserialize = false)
  private String  zSess;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getIdentity() {
    return identity;
  }

  public void setIdentity(String identity) {
    this.identity = identity;
  }


  public Integer getAutoSign() {
    return autoSign;
  }

  public void setAutoSign(Integer autoSign) {
    this.autoSign = autoSign;
  }


  public String getZSess() {
    return zSess;
  }

  public void setZSess(String zSess) {
    this.zSess = zSess;
  }



  @Override
  public String toString() {
    return "Userz{" +
            "id=" + id +
            ", account='" + account + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", identity='" + identity + '\'' +
            ", autoSign=" + autoSign +
            ", latelyDate='" + latelyDate + '\'' +
            ", zSess='" + zSess + '\'' +
            '}';
  }
}
