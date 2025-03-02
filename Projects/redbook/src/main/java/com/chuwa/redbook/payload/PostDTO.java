package com.chuwa.redbook.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;

    private String title;

    private String content;

    private String description;

    private Long authorId;
}
