package com.sparktodolistapp.spark_todo_list_app;

import spark.Request;
import spark.Response;
import spark.Route;

public class HomePageHandler implements Route{
	private final String htmlHead = "<html><head><title>Todo List App</title></head>";

	public Object handle(Request request, Response response) throws Exception {
		return htmlHead + "<body><h3>Welcome to our TodoList!<h3>" + 
				"<button onclick=\"location.href='/todo'\">Start App</button></body></html>";
	}
	
}
