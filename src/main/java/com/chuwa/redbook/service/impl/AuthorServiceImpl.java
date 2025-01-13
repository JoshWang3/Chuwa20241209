package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDTO> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        for (Author author : authors) {
            authorDTOS.add(convertAuthorToAuthorDTO(author));
        }
        return authorDTOS;
    }

    @Override
    public AuthorDTO getAuthorById(Long authorId) {
        return null;
    }

    @Override
    public void addAuthor(AuthorDTO authorDTO) {
        Author author = convertAuthorDTOToAuthor(authorDTO);
        if(authorRepository.findById(authorDTO.getId()).isPresent()){
            return;
        }
        //skip duplicates
        authorRepository.save(author);

    }

    @Override
    public void updateAuthor(Long authorId, AuthorDTO authorDTO) {
        authorRepository.findById(authorId).ifPresent(author -> {
            author.setId(authorDTO.getId());
            author.setName(authorDTO.getName());
            authorRepository.save(author);

        });

    }

    @Override
    public void deleteAuthor(Long authorId) {
            authorRepository.deleteById(authorId);
    }
    public AuthorDTO convertAuthorToAuthorDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());

        authorDTO.setName(author.getName());
        return authorDTO;
    }
    public Author convertAuthorDTOToAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setId(authorDTO.getId());
        return author;
    }
}
