package com.rc_long.Entity;

import com.rc_long.anotation.RcLongTable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@RcLongTable(name="live_room")
@Entity
@Table(name="liveroom")
public class LiveRoom extends EntitiBaseBean<LiveRoom>
{
  private static final long serialVersionUID = 1L;
  private String live_img;

  @Id
  private String live_id;
  private String live_name;
  private Date creare_time;
  private Integer auth;
  private String live_desc;
  private Integer live_status;
  private String live_path;
  private Integer is_recoment;
  private Integer menu_id;
  private String user_id;

  @OneToOne(cascade={javax.persistence.CascadeType.ALL}, targetEntity=SysUser.class)
  @JoinColumn(name="user_id", insertable=false, updatable=false)
  @NotFound(action=NotFoundAction.IGNORE)
  private SysUser sysUser;

  @ManyToOne(cascade={javax.persistence.CascadeType.ALL}, targetEntity=ModuleMenu.class)
  @JoinColumn(name="menu_id", insertable=false, updatable=false)
  @NotFound(action=NotFoundAction.IGNORE)
  private ModuleMenu moduleMenu;

  public Integer getMenu_id()
  {
    return this.menu_id;
  }

  public void setMenu_id(Integer menu_id) {
    this.menu_id = menu_id;
  }

  public SysUser getSysUser() {
    return this.sysUser;
  }

  public void setSysUser(SysUser sysUser) {
    this.sysUser = sysUser;
  }

  public ModuleMenu getModuleMenu() {
    return this.moduleMenu;
  }

  public void setModuleMenu(ModuleMenu moduleMenu) {
    this.moduleMenu = moduleMenu;
  }

  public String getLive_img() {
    return this.live_img;
  }

  public void setLive_img(String live_img) {
    this.live_img = live_img;
  }

  public String getLive_id() {
    return this.live_id;
  }

  public void setLive_id(String live_id) {
    this.live_id = live_id;
  }

  public String getLive_name() {
    return this.live_name;
  }

  public void setLive_name(String live_name) {
    this.live_name = live_name;
  }

  public Integer getLive_status()
  {
    return this.live_status;
  }

  public void setLive_status(Integer live_status) {
    this.live_status = live_status;
  }

  public String getLive_path() {
    return this.live_path;
  }

  public void setLive_path(String live_path) {
    this.live_path = live_path;
  }

  public Integer getIs_recoment() {
    return this.is_recoment;
  }

  public void setIs_recoment(Integer is_recoment) {
    this.is_recoment = is_recoment;
  }

  public Date getCreare_time() {
    return this.creare_time;
  }

  public void setCreare_time(Date creare_time) {
    this.creare_time = creare_time;
  }

  public Integer getAuth() {
    return this.auth;
  }

  public void setAuth(Integer auth) {
    this.auth = auth;
  }

  public String getLive_desc() {
    return this.live_desc;
  }

  public void setLive_desc(String live_desc) {
    this.live_desc = live_desc;
  }

  public String getUser_id() {
    return this.user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }
}