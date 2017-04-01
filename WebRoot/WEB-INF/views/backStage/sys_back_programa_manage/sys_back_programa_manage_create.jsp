<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<div class="panel admin-panel margin-top">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span><span id="span_m">添加内容</span></strong>
		</div>
		<div class="body-content">
			<form class="form-x" id="create_form" action="${base }/group/create" method="post">
				<div class="form-group">
					<div class="label">
						<label>上级栏目：</label>
					</div>
					<div class="field">
						<select  class="input w50" >
							<option name="group_pid" value="" >请选择</option>
							<c:forEach items="${videoGroup.list }" var="videoGroup">
							<option name="group_pid" value="${videoGroup.group_id }" >${videoGroup.group_name }</option>
							</c:forEach>
						</select>
						<div class="tips">不选择上级默认为一级栏目</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>栏目名称：</label>
					</div>
					<div class="field">
						<input type="hidden" name="group_id">
						<input type="text" class="input w50" name="group_name" value=""/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>描述内容：</label>
					</div>
					<div class="field">
						<textarea type="text" class="input w50" name="group_desc"
							style="height:150px;" placeholder="请添加描述，最多不超过100字"></textarea>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>上传封面：</label>
					</div>
					<div class="field">
						<!-- <input type="text" class="input tips" name="tits"
							></input> -->
							<table align="left"  border="1" height="100px" width="100px">
								<tr>
									<td>
										<img alt="" src="" id="img_input">
										<input  type="hidden"class="input w50" name="group_img" value=""/>
								</tr>
							</table>
							
							<input type="button" class="button bg-blue margin-left" name="tits"
							value="+ 浏览上传" onclick="openRecource()"></input>
					</div>
				</div>
							
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit" id="create_form_sumbit">
							提交</button>
					</div>
				</div>
			</form>	
		</div>
	</div>	