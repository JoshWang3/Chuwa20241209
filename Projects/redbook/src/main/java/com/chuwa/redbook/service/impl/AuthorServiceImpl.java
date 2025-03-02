package com.chuwa.redbook.service.impl;
import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream().map(AuthorServiceImpl::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        return convertToDTO(authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id)));
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        return convertToDTO(authorRepository.save(author));
    }

    @Override
    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDetails) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        author.setName(authorDetails.getName());
        return convertToDTO(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    private static AuthorDTO convertToDTO(Author author) {
        AuthorDTO authorResponse = new AuthorDTO();
        authorResponse.setId(author.getId());
        authorResponse.setName(author.getName());
        return authorResponse;
    }
}

