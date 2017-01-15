<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<tr>
	<th width="100" style="text-align:center; padding-left:20px;">用户ID</th>
	<th width="10%">排序</th>
	<th width="10%">用户状态</th>
	<th>用户头像</th>
	<th>用户姓名</th>
	<th>用户属性</th>
	<th>分类名称</th>
	<th width="10%">更新时间</th>

	<th width="310">操作</th>
</tr>
<%
	int i = 1;
%>
<c:forEach items="${user_bean.list }" var="user">
	<tr>
		<td style="text-align:left; padding-left:20px;"><input
			type="checkbox" name="id[]" value="${user.user_id }" />
			${user.user_ssid }</td>

		<td><input type="text" name="sort[1]" value="<%=i++%>"
			style="width:50px; text-align:center; border:1px solid #ddd; padding:7px 0;" /></td>

		<td><input type="text" name="sort[1]" value="${user.user_flag }"
			style="width:50px; text-align:center; border:1px solid #ddd; padding:7px 0;" /></td>

		<td width="10%"><img src="${base }/www/userImg/${user.user_img}"
			alt="" width="70" height="50" /></td>
		<!-- 用户头像 -->
		<td>${user.user_name }</td>
		<td><font color="#00CC99"> <c:choose>
					<c:when test="${user.user_type==0 }">
          		普通用户
          	</c:when>
					<c:when test="${user.user_type==1 }">
          		会员
          	</c:when>
					<c:when test="${user.user_type==2 }">
          		管理员
          	</c:when>
					<c:when test="${user.user_type==3 }">
          		超级管理员
          	</c:when>
					<c:otherwise>
          		未知用户类型
          	</c:otherwise>
				</c:choose>
		</font></td>
		<td>${user.user_type }</td>
		<td>${user.user_last_time }</td>
		<td><div class="button-group">
				<a class="button border-main"
					href="${base }/sys/back/user/qupdate?user_id=${user.user_id}"><span
					class="icon-edit"></span> 修改</a> <a class="button border-red"
					href="javascript:void(0)" onclick="del('${user.user_id}')"><span
					class="icon-trash-o"></span> 删除</a>
			</div></td>
	</tr>
</c:forEach>