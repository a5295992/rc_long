package com.rc_long.Entity;
import com.rc_long.Anrequest.TableName;
import com.rc_long.anotation.RcLongTable;

@RcLongTable(name=TableName.SysRecommentSearch)
public class SysRecommentSearch extends EntitiBaseBean<SysRecommentSearch>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String rec_id;
	
	private String rec_name;
	
	private String rec_title;

	public String getRec_id() {
		return rec_id;
	}

	public void setRec_id(String rec_id) {
		this.rec_id = rec_id;
	}

	public String getRec_name() {
		return rec_name;
	}

	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}

	public String getRec_title() {
		return rec_title;
	}
}
