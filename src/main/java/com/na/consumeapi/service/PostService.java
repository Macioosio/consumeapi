package com.na.consumeapi.service;

import com.na.consumeapi.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<Post> getPosts();
}
