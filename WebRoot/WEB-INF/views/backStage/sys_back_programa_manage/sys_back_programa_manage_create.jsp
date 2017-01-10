<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<div class="panel admin-panel margin-top">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>添加内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="">
				<div class="form-group">
					<div class="label">
						<label>上级栏目：</label>
					</div>
					<div class="field">
						<select name="pid" class="input w50">
							<option value="">请选择栏目</option>
							<option value="">产品分类</option>
							<option value="">产品分类</option>
							<option value="">产品分类</option>
							<option value="">产品分类</option>
						</select>
						<div class="tips">不选择上级默认为一级栏目</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>栏目名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="title" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>描述内容：</label>
					</div>
					<div class="field">
						<textarea type="text" class="input w50" name="tits"
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
									<td> <img alt="未选择图片" src=""></td>
								</tr>
							</table>
							
							<input type="file" class="button bg-blue margin-left" name="tits"
							value="+ 浏览上传"></input>
					</div>
				</div>
								
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>	