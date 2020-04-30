package com.na.consumeapi.service;

import com.na.consumeapi.service.impl.FileWriteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class FileWriteServiceImplTest {

    @Autowired
    FileWriteServiceImpl fileWriteServiceImpl;

    @Test
    void savePostListToFileNullValueThrowsException() {
        assertThrows(ConstraintViolationException.class, () -> fileWriteServiceImpl.savePostToFile(null));
    }

    @Test
    void savePostToFileNullValueThrowsException() {
        assertThrows(ConstraintViolationException.class, () -> fileWriteServiceImpl.savePostToFile(null));
    }
}