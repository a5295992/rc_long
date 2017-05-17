package com.rc_long.dao.dataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import org.springframework.core.annotation.AnnotationUtils;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Entity.LiveRoom;
import com.rc_long.Entity.SysVideo;

public class HQLCostants {

	public static String getALL(String string) {
		String hql = "select count(*) as count from ";
		StringBuilder sb = new StringBuilder();
		sb.append(hql);

		sb.append(string);

		sb.append(" ");
		return sb.toString();
	}

	public static String getSQL(QueryCondition queryCondition) {

		// 判断 等下是否要用到 自定义条件数组
		List<Object> conditionList = new ArrayList<Object>();

		StringBuilder sb = new StringBuilder();
		sb.append("FROM ");
		sb.append(queryCondition.getClazz().getSimpleName());

		String condition = queryCondition.getCondition();

		if (!StringUtils.isNullOrEmpty(condition)) {

			sb.append(" " + condition);
			Object[] obj = queryCondition.getConditionObject();
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					conditionList.add(obj[i]);
				}
			}

		}

		String like = queryCondition.getLike();

		if (!StringUtils.isNullOrEmpty(like)) {
			Object likeName = queryCondition.getLikeName();
			if (likeName!="") {
				if (!sb.toString().toLowerCase().contains("where")) {
					sb.append(" WHERE ");
				} else {
					sb.append(" AND ");
				}
				sb.append(like + " like '%"+likeName+"%'");
			}
		}

		String groupBy = queryCondition.getGroupByName();

		if (!StringUtils.isNullOrEmpty(groupBy)) {
			sb.append(" GROUP BY " + groupBy);

		}

		String orderBy = queryCondition.getOrderBy();

		if (!StringUtils.isNullOrEmpty(orderBy)) {

			if (!StringUtils.isNullOrEmpty(queryCondition.getOrder())) {

				sb.append(" ORDER BY " + orderBy + " "
						+ queryCondition.getOrder());
			}

		}
		Object object[] = conditionList.toArray();

		queryCondition.setObj(object);

		return sb.toString();
	}

	public static void main(String[] args) {

		/*QueryCondition queryCondition = new QueryCondition();
		queryCondition.setBegin(0);
		queryCondition.setClazz(SysVideo.class);

		queryCondition.setCondition("where video_id= ?");

		queryCondition.setConditionObject(new Object[] { "10001" });

		queryCondition.setLike("video_id");

		queryCondition.setLikeName("10001");

		queryCondition.setOrderBy("video_id");

		queryCondition.setOrder("desc");

		queryCondition.setGroupByName("user_id");

		System.out.println(getSQL(queryCondition));*/
		
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setClazz(SysVideo.class);
		queryCondition.setLike("video_id");

		queryCondition.setLikeName("10001");
		
		System.out.println(getALL(queryCondition));
		System.out.println(queryCondition.getObj().length);
	}

	public static String getALL(QueryCondition queryCondition) {
		List<Object> conditionList = new ArrayList<Object>();

		StringBuilder sb = new StringBuilder();

		sb.append("select ");

		sb.append("count(" + queryCondition.getCount() + ") ");
		sb.append(" from ");
		String tableName = AnnotationUtils.findAnnotation(
				queryCondition.getClazz(), Table.class).name();

		sb.append(tableName);

		String condition = queryCondition.getCondition();

		if (!StringUtils.isNullOrEmpty(condition)) {

			sb.append(" " + condition);
			Object[] obj = queryCondition.getConditionObject();
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					conditionList.add(obj[i]);
				}
			}

		}

		String like = queryCondition.getLike();

		if (!StringUtils.isNullOrEmpty(like)) {
			Object likeName = queryCondition.getLikeName();
			if (likeName != null) {
				if (!sb.toString().toLowerCase().contains("where")) {
					sb.append(" WHERE ");
				} else {
					sb.append(" AND ");
				}
				sb.append(like + " like '%"+likeName+"%'");

			}
		}
		
		Object object[] = conditionList.toArray();

		queryCondition.setObj(object);
		return sb.toString();
	}

	public static String updateById(Class<LiveRoom> class1, String string,
			Map<String, Object> map) {
		
		
		return null;
	}

}
