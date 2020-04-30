package com.na.consumeapi;

import com.na.consumeapi.domain.Post;
import com.na.consumeapi.service.FileWriteService;
import com.na.consumeapi.service.PostService;
import com.na.consumeapi.service.impl.FileWriteServiceImpl;
import com.na.consumeapi.service.impl.PostServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class ConsumeApiApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ConsumeApiApplication.class, args);
		PostService postService = applicationContext.getBean(PostServiceImpl.class);
		FileWriteService fileWriteService = applicationContext.getBean(FileWriteServiceImpl.class);
		List<Post> postList = postService.getPosts();
		fileWriteService.savePostListToFile(postList);
		((ConfigurableApplicationContext) applicationContext).close();
	}
}
