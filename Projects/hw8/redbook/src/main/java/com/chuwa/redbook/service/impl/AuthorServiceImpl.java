package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.service.AuthorService;

import java.util.ArrayList;
import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public AuthorDTO create(AuthorDTO Author) {
        Author author = new Author();
        author.setUsername(Author.getUsername());
        author.setEmail(Author.getEmail());
        author.setFirstName(Author.getFirstName());
        author.setLastName(Author.getLastName());

        author = authorRepository.save(author);

        Author.setId(author.getId());
        return Author;
    }

    @Override
    public List<AuthorDTO> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        for (Author author : authors) {
            authorDTOS.add(new AuthorDTO(author.getId(), author.getUsername(), author.getEmail(), author.getFirstName(), author.getLastName()));
        }
        return authorDTOS;
    }

    @Override
    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));

        author.setEmail(author.getEmail());
        author.setFirstName(author.getFirstName());
        author.setLastName(author.getLastName());

        author = authorRepository.save(author);

        return new AuthorDTO(author.getId(), author.getUsername(), author.getEmail(), author.getFirstName(), author.getLastName());
    }

    @Override
    public AuthorDTO getAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));

        return new AuthorDTO(author.getId(), author.getUsername(), author.getEmail(), author.getFirstName(), author.getLastName());
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
