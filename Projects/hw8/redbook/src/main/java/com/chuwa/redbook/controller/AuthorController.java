package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/Authors")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO AuthorDTO) {
        AuthorDTO response = authorService.create(AuthorDTO);
        return new ResponseEntity<AuthorDTO>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAuthors() {
        List<AuthorDTO> response = authorService.getAuthors();
        return new ResponseEntity<List<AuthorDTO>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
    }



    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO AuthorDTO) {
        return new ResponseEntity<>(authorService.updateAuthor(id, AuthorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
