package com.example.librarysystem.Controller;

import com.example.librarysystem.Model.Librarian;
import com.example.librarysystem.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/librarian")
public class LibrarianController {
    private final LibrarianService librarianService;

    @GetMapping("/get")
    public ResponseEntity getAllLibrarian() {
        return ResponseEntity.status(HttpStatus.OK).body(librarianService.getAllLibrarian());
    }

    @PostMapping("/add")
    public ResponseEntity addLibrarian(@RequestBody @Valid Librarian librarian) {
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(HttpStatus.OK).body("added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@PathVariable Integer id, @RequestBody @Valid Librarian librarian) {
        librarianService.updateLibrarian(id, librarian);
        return ResponseEntity.status(HttpStatus.OK).body("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id) {
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity getOneLibrarian(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(librarianService.getLibrarianById(id));
    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity checkLogin (@PathVariable String username, @PathVariable String password) {
        librarianService.checkLogin(username, password);
        return ResponseEntity.status(HttpStatus.OK).body("login success");
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getLibrarianByEmail(@PathVariable String email) {
        return ResponseEntity.status(HttpStatus.OK).body(librarianService.getLibrarianByEmail(email));
    }


}
