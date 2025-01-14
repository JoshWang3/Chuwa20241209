package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.AuthorDTO;

import java.util.List;

public interface AuthorService {

    AuthorDTO create(AuthorDTO authorDTO);
    List<AuthorDTO> getAuthors();

    AuthorDTO getAuthor(Long id);

    AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO);

    void deleteAuthor(Long id);
}
