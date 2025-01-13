package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.AuthorDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> getAuthors();

    AuthorDTO getAuthorById(Long authorId);

    void addAuthor(AuthorDTO authorDTO);

    void updateAuthor(Long authorId, AuthorDTO authorDTO);

    void deleteAuthor(Long authorId);
}
