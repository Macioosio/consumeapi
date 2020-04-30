package com.na.consumeapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.na.consumeapi.domain.Post;
import com.na.consumeapi.service.FileWriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Validated
public class FileWriteServiceImpl implements FileWriteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileWriteServiceImpl.class);

    @Autowired
    ObjectMapper objectMapper;

    public void savePostListToFile(@NotNull List<Post> posts) {
        posts.forEach(post -> savePostToFile(post));
    }

    public void savePostToFile(@NotNull Post post) {
        try {
            createParentDirectoryIfNeeded();
            writePostToFile(post);
        } catch (IOException e) {
            LOGGER.error("Exception occured while writing post to file", e);
        }
    }

    private void createParentDirectoryIfNeeded() {
        File parent = new File("target/posts");
        if (parent.mkdirs()) {
            LOGGER.info("Created directory " + parent.getAbsolutePath());
        }
    }

    private void writePostToFile(Post post) throws IOException {
        File toWrite = new File("target/posts/" + post.getId() + ".json");
        objectMapper.writeValue(toWrite, post);
        LOGGER.info("Post " + post.getId() + " written to file " + toWrite.getAbsolutePath());
    }
}
