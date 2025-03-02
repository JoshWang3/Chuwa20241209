package com.chuwa.redbook.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private Long id;
    private String name;

}
