package com.in28minutes.web.common.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.in28minutes.domain.Priority;
import com.in28minutes.web.common.util.TodoListUtils;

import java.io.IOException;



public class PriorityIconTag extends SimpleTagSupport {

	
	private String priority;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		String priorityIcon = TodoListUtils.getPriorityIcon(Priority
				.valueOf(priority));
		out.print(priorityIcon);
	}

	

	public void setPriority(String priority) {
		this.priority = priority;
	}
}
