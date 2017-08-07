package com.in28minutes.web.common.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.in28minutes.domain.Priority;
import com.in28minutes.domain.TodoItem;


public class TodoListUtils {

	private TodoListUtils() {
	}

	public static final String SESSION_USER = "user";

	public static final String DATE_FORMAT = "dd/MM/yyyy";

	
	public static String getPriorityIcon(Priority priority) {

		String priorityIcon = "";

		switch (priority) {
		case HIGH:
			priorityIcon = "up";
			break;
		case MEDIUM:
			priorityIcon = "right";
			break;
		case LOW:
			priorityIcon = "down";
		}

		return priorityIcon;
	}

	
	public static String getStatusStyle(boolean status) {
		return status ? "label-success" : "";
	}

	
	public static String getStatusLabel(boolean status) {
		return status ? "DONE" : "TODO";
	}

	
	public static String highlight(final String input, final String pattern) {

		String cssClass = "label label-warning";
		String startSpanTag = "<span class=\"" + cssClass + "\">";
		String endSpanTag = "</span>";

		StringBuilder stringBuilder = new StringBuilder(startSpanTag);
		stringBuilder.append(pattern);
		stringBuilder.append(endSpanTag);

		Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(input);

		return matcher.replaceAll(stringBuilder.toString());

	}
}
