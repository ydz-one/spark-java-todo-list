package com.sparktodolistapp.spark_todo_list_app;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		HomePageHandler homePageHandler = new HomePageHandler();
		TodoListHandler todoListHandler = new TodoListHandler();
		RewardHandler rewardHandler = new RewardHandler();
		
		port(8080);
		
		get("/", homePageHandler);
		get("/todo", todoListHandler);
		get("/taskdone", todoListHandler);
		get("/reward", rewardHandler);
		post("/createtodo", todoListHandler);
	}
}
