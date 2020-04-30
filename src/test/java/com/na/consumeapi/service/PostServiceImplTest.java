package com.na.consumeapi.service;

import com.na.consumeapi.domain.Post;
import com.na.consumeapi.service.impl.PostServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    PostServiceImpl postServiceImpl = new PostServiceImpl();

    @Test
    void testGetPosts() {
        Post[] mockedPostArray = prepareDataToMock();
        when(restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", Post[].class))
                .thenReturn(mockedPostArray);

        List<Post> returnedPostList = postServiceImpl.getPosts();

        Assert.assertEquals(Arrays.asList(mockedPostArray), returnedPostList);
    }

    private Post[] prepareDataToMock() {
        Post post = new Post("1", "1", "title", "body");
        return new Post[]{post};
    }
}