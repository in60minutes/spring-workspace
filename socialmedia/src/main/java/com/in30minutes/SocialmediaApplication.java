package com.in30minutes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

//@SpringBootApplication
public class SocialmediaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SocialmediaApplication.class, args);

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Scanner scanner = new Scanner(System.in);
		User user = (User) context.getBean("user");

		System.out.println("Enter your username:\n");
		String userName = scanner.next();
		user.setUsername(userName);



		PostList postList = (PostList) context.getBean("postList");

		while (true){
			System.out.println("Choose from bellow\n1. Create a Post\n2. See All your Post");
			int userSelect = scanner.nextInt();

			switch (userSelect){
				case 1:{
					Post post = (Post) context.getBean("post");
					scanner.nextLine();
					String message = scanner.nextLine();
					post.setMessage(message);
					postList.setPost(post);
					user.setPostList(postList);
					break;
				}
				case 2:{
					postList.getAllPost().forEach(item->
							System.out.println(item.getMessage()));
					break;
				}
			}
		}
	}

}
