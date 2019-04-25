package com.sparktodolistapp.spark_todo_list_app;

import spark.Request;
import spark.Response;
import spark.Route;

public class RewardHandler implements Route{
	private final String htmlHead = "<html><head><title>Todo List App</title></head>";

	public Object handle(Request request, Response response) throws Exception {
		return htmlHead + "<body><h3>Good job!<h3></body></html>";
	}
	
}
