package com.rc_long.utils;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HandleJspTag<T> implements SimpleTag {
	private Pager<T> pager;

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Pager<T> getPager() {
		return pager;
	}

	public void setPager(Pager<T> pager) {
		this.pager = pager;
	}

	public PageContext getPageContext() {
		return pageContext;
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	private PageContext pageContext;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = pageContext.getOut();
		StringBuilder sb = new StringBuilder();
		sb.append("<td colspan='8'>");
		sb.append("<div class='pagelist'>");
		if (pager != null) {
			if (pager.getPageNum() == 0) {
				sb.append("<span>上一页</span>");
			} else {
				sb.append("<a href='" + path + "?pageNum="
						+ (pager.getPageNum() - 1) + "'>上一页</a>");
			}
			for (int i = 0; i < pager.getPage(); i++) {
				if (i > 2 && i < pager.getPage() - 2) {
					sb.append("..");
					if (i == pager.getPageNum()) {
						sb.append("<span class='current'>" + (i + 1)
								+ "</span>");
					}
				} else {
					if (i == pager.getPageNum()) {
						sb.append("<span class='current'>" + (i + 1)
								+ "</span>");
					} else {
						sb.append("<a href='"+path+"?pageNum="+i+"'>" + (i + 1)
								+ "</a>");
					}
				}
			}

			if (pager.getPageNum() == pager.getPage() - 1) {
				sb.append("<span>下一页</span>");

			} else {
				sb.append("<a href='" + path + "?pageNum="
						+ (pager.getPageNum() + 1) + "'>下一页</a>");
			}

			sb.append("<a href='" + path + "?pageNum=" + (pager.getPage() - 1)
					+ "'>尾页</a>");

			sb.append("<a href=''>总共" + pager.getPage() + "页</a>");
			sb.append("<input type='text' name='inputPageNum' value='"
					+ pager.getPageNum() + "' size='2px' />");
			sb.append("<a href='javascript:void(0)' onclick='turnPage()'>GO</a>");
			sb.append("</div>");
			out.write(sb.toString());
		} else {
			sb.append("</div>");
		}
	}

	@Override
	public JspTag getParent() {
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {

	}

	@Override
	public void setJspContext(JspContext jspContext) {
		// 得到jsp页面对象
		pageContext = (PageContext) jspContext;
	}

	@Override
	public void setParent(JspTag arg0) {

	}

}
