package com.na.consumeapi.service.impl;

import com.na.consumeapi.domain.Post;
import com.na.consumeapi.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final String URL = "https://jsonplaceholder.typicode.com";
    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    public List<Post> getPosts() {
        LOGGER.info("Downloading posts");
        Post[] postArray = restTemplate.getForObject(URL + "/posts", Post[].class);
        return Arrays.asList(postArray);
    }
}
