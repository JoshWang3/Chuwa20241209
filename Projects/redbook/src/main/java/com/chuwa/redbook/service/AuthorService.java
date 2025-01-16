package com.chuwa.redbook.service;

import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> getAllAuthors();
    AuthorDTO getAuthorById(Long id);
    AuthorDTO createAuthor(AuthorDTO author);
    AuthorDTO updateAuthor(Long id, AuthorDTO authorDetails);
    void deleteAuthor(Long id);
}

