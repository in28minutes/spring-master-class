package com.in28minutes.web.common.tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HighlightTag extends SimpleTagSupport {

	
	private String pattern;

	
	private String cssClass;

	
	private boolean caseSensitive;

	@Override
	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut();
		StringWriter stringWriter = new StringWriter();
		getJspBody().invoke(stringWriter);
		String highlightedValue = doHighlight(stringWriter.toString());
		out.print(highlightedValue);

	}

	
	private String doHighlight(final String input) {

		String startSpanTag = "<span class=\"" + cssClass + "\">";
		String endSpanTag = "</span>";

		StringBuilder stringBuilder = new StringBuilder(startSpanTag);
		stringBuilder.append(pattern);
		stringBuilder.append(endSpanTag);

		Pattern pattern;

		if (caseSensitive) {
			pattern = Pattern.compile(this.pattern);
		} else {
			pattern = Pattern.compile(this.pattern, Pattern.CASE_INSENSITIVE);
		}
		Matcher matcher = pattern.matcher(input);

		return matcher.replaceAll(stringBuilder.toString());

	}

	

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}
}
