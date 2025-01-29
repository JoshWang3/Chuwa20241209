package com.chuwa.redbook.util.mapper;

import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.payload.CommentDTO;
import org.modelmapper.ModelMapper;

public class CustomizedMapper {
    public static CommentDTO commentServiceMapperUtil(Comment comment) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(comment, CommentDTO.class);
    }
}
