package com.rc_long.utils;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HandleJspTag_simple<T> implements SimpleTag {
	private Pager<T> pager;


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
				sb.append("<a href='javascript:void(0)'"
						+ " onclick='last()'>上一页</a>");
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
						sb.append("<a href='javascript:void(0)'"
								+ " onclick='crrent("+i+")'>"+(i + 1)+"</a>");
					}
				}
			}

			if (pager.getPageNum() == pager.getPage() - 1) {
				sb.append("<span>下一页</span>");

			} else {
				sb.append("<a href='javascript:void(0)'"
						+ " onclick='next()'>下一页</a>");
			}

			sb.append("<a href='javascript:void(0)'"
					+ " onclick='end()'>尾页</a>");

			sb.append("<a href='#'>总共" + pager.getPage() + "页</a>");
			sb.append("<input type='text' name='inputPageNum' size='2px' />");
			sb.append("<a href='javascript:void(0)' onclick='turnPage()'>GO</a>");
			sb.append("</div>");
			out.write(sb.toString());
		} else {
			sb.append("</div>");
		}
		sb.append("</td>");
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
