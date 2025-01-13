package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/authors")
public class AuthorController {
    private AuthorService AuthorService;

    public AuthorController(AuthorService AuthorService) {
        this.AuthorService = AuthorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAuthors() {
        List<AuthorDTO> AuthorDTOList = AuthorService.getAuthors();
        return new ResponseEntity<>(AuthorDTOList, HttpStatus.OK);
    }
    @GetMapping("/{AuthorId}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long AuthorId) {
        AuthorDTO AuthorDTO = AuthorService.getAuthorById(AuthorId);
        return new ResponseEntity<>(AuthorDTO, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO AuthorDTO) {
        AuthorService.addAuthor(AuthorDTO);
        return new ResponseEntity<>(AuthorDTO, HttpStatus.OK);
    }

//    @PutMapping("/{AuthorId}")
//    public ResponseEntity<String> updateAuthor(@PathVariable Long AuthorId, @RequestBody AuthorDTO AuthorDTO) {
//        AuthorService.updateAuthor(AuthorId, AuthorDTO);
//        return new ResponseEntity<>("udpated successfully", HttpStatus.OK);
//    }
//
    @DeleteMapping("/{AuthorId}")
    public ResponseEntity<String> updateAuthor(@PathVariable Long AuthorId) {
        AuthorService.deleteAuthor(AuthorId);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

}
