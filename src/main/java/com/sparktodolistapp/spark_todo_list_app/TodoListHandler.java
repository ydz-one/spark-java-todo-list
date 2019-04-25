package com.sparktodolistapp.spark_todo_list_app;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import spark.Request;
import spark.Response;
import spark.Route;

public class TodoListHandler implements Route{
	private final String htmlHead = "<html><head><title>Todo List App</title></head>";
	
	private final String newTaskForm = "<div><form action=\"/createtodo\" method=\"post\">Add new task:"
			+ "<input type=\"text\" name=\"taskname\">"
			+ "<button style=\"margin-left: 10px\" type=\"submit\">Create</button>"
			+ "</form></div>";
	
	private final int TARGET_NUM_OF_TASKS = 5;
	private int tasksCompleted;
	private int idCount;
	private Map<Integer, String> tasks;
	
	public TodoListHandler() {
		tasksCompleted = 0;
		idCount = 0;
		tasks = new HashMap<>();
	}

	public Object handle(Request request, Response response) throws Exception {
		if ("/taskdone".equals(request.pathInfo())) {
			int taskId = Integer.valueOf(request.queryParams("id"));
			tasks.remove(taskId);
			tasksCompleted++;
			
			if (tasksCompleted >= TARGET_NUM_OF_TASKS) {
				response.redirect("/reward");
			}
		} else if ("/createtodo".equals(request.pathInfo())) {
			String taskname = request.queryParams("taskname");
			tasks.put(idCount++, taskname);
		}
		
		return htmlHead + "<body><div><h3>Todo List<h3></div>" +
				taskCounter() + taskList() + newTaskForm + "</body></html>";
	}
	
	public String taskCounter() {
		return "<div><h4>Target Number of Tasks: " + TARGET_NUM_OF_TASKS +
				"</h4><h4>Tasks Completed: " + tasksCompleted + "</h4></div>";
	}
	
	public String taskList() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<div><ul>");
		
		for (Entry<Integer, String> task : tasks.entrySet()) {
			sb.append("<li>" + task.getValue() + "<button style=\"margin-left: 10px\" onclick=\"location.href='/taskdone?id=" + task.getKey() + "'\">DONE</button></li>");
		}
		
		sb.append("</ul></div>");
		
		return sb.toString();
	}
}
