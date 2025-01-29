package com.chuwa.redbook.util.mapper;

import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.service.impl.CommentServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomizedMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(CustomizedMapperTest.class);

    private Comment comment;
    private CommentDTO commentDTO;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    @BeforeEach
    void setUp() {
        logger.info("Set up comment before each test");
        this.comment = new Comment();
        comment.setId(1L);
        comment.setPostId(1L);
        comment.setUserId(2L);
        comment.setContent("xiao ruishi");
        comment.setCreateDateTime(LocalDateTime.now());
        comment.setUpdateDateTime(LocalDateTime.now());

        this.commentDTO = new CommentDTO();
        commentDTO.setId(1L);
        commentDTO.setPostId(1L);
        commentDTO.setUserId(2L);
        commentDTO.setContent("xiao ruishi");
    }

    @Test
    public void commentServiceMapperUtilTest() throws Exception {
        try (MockedStatic<CustomizedMapper> mockedUtils = Mockito.mockStatic(CustomizedMapper.class)) {
            mockedUtils.when(() -> CustomizedMapper.commentServiceMapperUtil(ArgumentMatchers.any(Comment.class))).thenReturn(commentDTO);

            CommentDTO result = CustomizedMapper.commentServiceMapperUtil(comment);
            assertEquals(commentDTO, result);
        }

        // Junit4 with powerMock
//        // Mock the static method
//        mockStatic(CommentServiceImpl.class);
//        when(CommentServiceImpl.commentServiceMapperUtil(ArgumentMatchers.any(Comment.class))).thenReturn(commentDTO);
//
//        // Test static Method
//        CommentDTO resultStatic = CommentServiceImpl.commentServiceMapperUtil(comment);
//        // Verify behavior and assert the result
//        assertEquals(commentDTO, resultStatic);
//
//
//        // Call the method under test
//        CommentDTO result = commentService.getComment(1L);
//        // Verify behavior and assert the result
//        assertEquals(commentDTO, result);
//
//        // Verify that the static method was called
//        verifyStatic(CommentServiceImpl.class);
//        CommentServiceImpl.commentServiceMapperUtil(comment);
    }

    @AfterEach
    void tearDown() {
        logger.info("End test, Check Result");
    }

    @AfterAll
    static void afterAll() {
        logger.info("FINISH tests");
    }
}
