package com.rc_long.Entity;

import com.rc_long.anotation.RcLongTable;
import com.rc_long.Anrequest.TableName;
/**
 * 栏目实体类
 * @author longge
 *
 */
@RcLongTable(name=TableName.ProgramaBean)
public class ProgramaBean extends EntitiBaseBean<ProgramaBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String programa_name;//栏目名称
	
	private String programa_id;//栏目id
	
	private String programa_pid;//上级id
	
	private String programa_desc;//描述
	
	private String programa_img;//封面
	
	private Integer programa_wathers;//栏目人气
	
	private Integer programa_videos;//视频数


	public String getPrograma_img() {
		return programa_img;
	}

	public void setPrograma_img(String programa_img) {
		this.programa_img = programa_img;
	}

	
	public String getPrograma_name() {
		return programa_name;
	}

	public void setPrograma_name(String programa_name) {
		this.programa_name = programa_name;
	}

	public String getPrograma_id() {
		return programa_id;
	}

	public void setPrograma_id(String programa_id) {
		this.programa_id = programa_id;
	}

	public String getPrograma_pid() {
		return programa_pid;
	}

	public void setPrograma_pid(String programa_pid) {
		this.programa_pid = programa_pid;
	}

	public Integer getPrograma_wathers() {
		return programa_wathers;
	}

	public void setPrograma_wathers(Integer programa_wathers) {
		this.programa_wathers = programa_wathers;
	}

	public Integer getPrograma_videos() {
		return programa_videos;
	}

	public void setPrograma_videos(Integer programa_videos) {
		this.programa_videos = programa_videos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String getPrograma_desc() {
		return programa_desc;
	}

	public void setPrograma_desc(String programa_desc) {
		this.programa_desc = programa_desc;
	}
}
