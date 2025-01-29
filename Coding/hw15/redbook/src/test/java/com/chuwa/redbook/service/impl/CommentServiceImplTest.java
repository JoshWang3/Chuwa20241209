package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.payload.PageDTO;
import com.chuwa.redbook.payload.PostDTO;
import org.springframework.data.domain.Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);

    /**
     * 创建一个Mock对象
     * 也可以通过CommentRepository commentRepoMock = Mockito.mock(CommentRepository.class)
     * 区别是， @Mock这种方式会被@InjectMocks识别，并注入给该变量
     */
    @Mock
    private CommentRepository commentRepoMock;

    @Mock
    private PostRepository postRepoMock;

    /**
     * 未定义的方法（behavior），则调用真实的方法。
     * 已定义的方法when().thenReturn(), 则调用mock的虚假behavior。
     */
    @Mock(name="modelMapper")
    private ModelMapper mockedModelMapper;

    /**
     * 为该class依赖的变量，注入对应的Mock对象。
     * 比如CommentServiceImpl依赖CommentRepository和modelMapper,则将上面@Mock和@Spy修饰的注入进来
     */
    @InjectMocks
    private CommentServiceImpl commentServiceImpl;

    @InjectMocks
    private PostServiceImpl postServiceImpl;

    private Comment comment;
    private CommentDTO commentDTO;
    private Post post;
    private Post post1;
    private PostDTO postDTO;
    private Page<Comment> page;
    private Page<Comment> pageEmpty;
    private PageDTO<CommentDTO> pageDTO;

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

        this.post = new Post();
        post.setId(1L);
        post.setUserId(1L);
        post.setContent("SBSBSBSBSB");
        post.setCreateDateTime(LocalDateTime.now());
        post.setUpdateDateTime(LocalDateTime.now());

        this.post1 = new Post();
        post1.setId(2L);
        post1.setUserId(1L);
        post1.setContent("SBSBSBSBSB");
        post1.setCreateDateTime(LocalDateTime.now());
        post1.setUpdateDateTime(LocalDateTime.now());

        this.postDTO = new PostDTO();
        postDTO.setContent("SBSBSBSBSB");
        postDTO.setId(1L);
        postDTO.setUserId(1L);

        this.page = new PageImpl<>(List.of(comment));

        this.pageDTO = new PageDTO<>();
        pageDTO.setLast(true);
        pageDTO.setTotalPages(1);
        pageDTO.setTotalElements(1);
        pageDTO.setHasNext(false);
        pageDTO.setNumber(0);
        pageDTO.setData(List.of(commentDTO));

        this.pageEmpty = new PageImpl<>(List.of());
    }

    @Test
    public void addComment() {
        // stun
        when(commentRepoMock.save(ArgumentMatchers.any(Comment.class))).thenReturn(comment);

        // test
        CommentDTO commentDTOResult = commentServiceImpl.addComment(commentDTO);

        // check
        assertEquals(commentDTO.getId(), commentDTOResult.getId());
        assertEquals(commentDTO.getPostId(), commentDTOResult.getPostId());
        assertEquals(commentDTO.getUserId(), commentDTOResult.getUserId());
        assertEquals(commentDTO.getContent(), commentDTOResult.getContent());
    }

    @Test
    public void getCommentTest() {
        // stun
        when(commentRepoMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));
        CommentDTO commentDTOResult = commentServiceImpl.getComment(1L);

        assertEquals(commentDTO.getId(), commentDTOResult.getId());
        assertEquals(commentDTO.getPostId(), commentDTOResult.getPostId());
        assertEquals(commentDTO.getUserId(), commentDTOResult.getUserId());
        assertEquals(commentDTO.getContent(), commentDTOResult.getContent());
    }

    @Test
    public void getCommentNotFoundTest() {
        when(commentRepoMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));

        // execute and assertions
        assertThrows(ResourceNotFoundException.class, () -> commentServiceImpl.getComment(1L));
    }

    @Test
    public void getCommentByIdsTest() {
        when(postRepoMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));
        when(commentRepoMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        CommentDTO result = commentServiceImpl.getCommentByIds(1L, 1L);

        assertEquals(comment.getId(), result.getId());
        assertEquals(comment.getPostId(), result.getPostId());
        assertEquals(comment.getUserId(), result.getUserId());
        assertEquals(comment.getContent(), result.getContent());
    }

    @Test
    public void getCommentByIdsPostNotFoundTest() {
        when(postRepoMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        assertThrows(ResourceNotFoundException.class, () -> commentServiceImpl.getCommentByIds(1L, 1L));
    }

    @Test
    public void getCommentByIdsCommentNotFoundTest() {
        when(postRepoMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));
        when(commentRepoMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));

        assertThrows(ResourceNotFoundException.class, () -> commentServiceImpl.getCommentByIds(1L, 1L));
    }

    @Test
    public void getPostIdMismatchTest() {
        when(postRepoMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post1));
        when(commentRepoMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        assertThrows(BlogAPIException.class, () -> commentServiceImpl.getCommentByIds(1L, 1L));
    }

    @Test
    public void getCommentListTest() {
        when(commentRepoMock.findByPostId(ArgumentMatchers.anyLong(), ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(page);

        PageDTO<CommentDTO> result = commentServiceImpl.getCommentList(1L, 0, 1);

        assertEquals(pageDTO.getTotalElements(), result.getTotalElements());
        assertEquals(pageDTO.getTotalPages(), result.getTotalPages());
        assertEquals(pageDTO.getNumber(), result.getNumber());
        assertEquals(pageDTO.isLast(), result.isLast());
        assertEquals(pageDTO.isHasNext(), result.isHasNext());
        assertEquals(pageDTO.getData().size(), result.getData().size());
        for (int i = 0; i < pageDTO.getData().size(); i++) {
            assertEquals(pageDTO.getData().get(i).getId(), result.getData().get(i).getId());
            assertEquals(pageDTO.getData().get(i).getPostId(), result.getData().get(i).getPostId());
            assertEquals(pageDTO.getData().get(i).getUserId(), result.getData().get(i).getUserId());
            assertEquals(pageDTO.getData().get(i).getContent(), result.getData().get(i).getContent());
        }
    }

    @Test
    public void getCommentListResourceNotFoundTest() {
        when(commentRepoMock.findByPostId(ArgumentMatchers.anyLong(), ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(pageEmpty);

        assertThrows(ResourceNotFoundException.class, () -> commentServiceImpl.getCommentList(1L, 0, 1));
    }

    @Test
    public void deleteCommentTest() {
        Mockito.doNothing().when(commentRepoMock).deleteById(ArgumentMatchers.anyLong());

        commentServiceImpl.deleteComment(1L);

        // verify
        // 验证 commentRepoMock.delete() 被执行过一次
        Mockito.verify(commentRepoMock, Mockito.times(1)).deleteById(ArgumentMatchers.anyLong());
    }

    @Test
    public void updateCommentTest() {
        when(commentRepoMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        CommentDTO result = commentServiceImpl.updateComment(1L, commentDTO);

        assertEquals(comment.getId(), result.getId());
        assertEquals(comment.getPostId(), result.getPostId());
        assertEquals(comment.getUserId(), result.getUserId());
        assertEquals(comment.getContent(), result.getContent());
    }

    @Test
    public void updateCommentResourceNotFoundTest() {
        when(commentRepoMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));

        assertThrows(ResourceNotFoundException.class, () -> commentServiceImpl.updateComment(1L, commentDTO));
    }
}
