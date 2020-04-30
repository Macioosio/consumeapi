package com.na.consumeapi.service;

import com.na.consumeapi.domain.Post;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface FileWriteService {

    void savePostToFile(@NotNull Post post);
    void savePostListToFile(@NotNull List<Post> posts);
}
