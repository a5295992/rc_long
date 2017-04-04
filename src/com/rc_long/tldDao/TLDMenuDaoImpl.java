package com.rc_long.tldDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rc_long.Entity.ModuleMenu;
import com.rc_long.Entity.SysMenu;
import com.rc_long.utils.C3P0UTils;

public class TLDMenuDaoImpl implements TLDMenuDao {
	
	
	public static TLDMenuDaoImpl tLDMenuDaoImpl;
	private static QueryRunner queryRunner;
	private static Connection connecion;
	
	private static QueryRunner getQueryRunnner(){
		if(queryRunner==null){
			return new QueryRunner();
		}else{
			
			return queryRunner;
		}
	}
	@Override
	public List<ModuleMenu> getMenuList(String sql, Object[] obj) {
		queryRunner = getQueryRunnner();
		connecion = C3P0UTils.getConnection();
		try {
			return queryRunner.query(connecion, sql, new BeanListHandler<ModuleMenu>(ModuleMenu.class),obj);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			C3P0UTils.closeCon(connecion);
		}
		
		return null;
	}
	
	

	@Override
	public SysMenu getMenu(String sql, Object[] obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
