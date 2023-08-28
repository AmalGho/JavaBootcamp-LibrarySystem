package com.example.librarysystem.Service;

import com.example.librarysystem.Api.ApiException;
import com.example.librarysystem.Model.Librarian;
import com.example.librarysystem.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;

    public List<Librarian> getAllLibrarian() {
        return librarianRepository.findAll();
    }

    public void addLibrarian(Librarian librarian) {
        librarianRepository.save(librarian);
    }

    public void updateLibrarian(Integer id, Librarian librarian) {
        Librarian oldLibrarian = librarianRepository.findLibrarianById(id);
        if (oldLibrarian == null) throw new ApiException("this librarian not exist");
        oldLibrarian.setName(librarian.getName());
        librarianRepository.save(oldLibrarian);
    }

    public void deleteLibrarian(Integer id) {
        Librarian oldLibrarian = librarianRepository.findLibrarianById(id);
        if (oldLibrarian == null) throw new ApiException("this librarian not exist");
        librarianRepository.delete(oldLibrarian);
    }

    public Librarian getLibrarianById(Integer id) {
        Librarian librarian = librarianRepository.findLibrarianById(id);
        if (librarian == null) throw new ApiException("this librarian not exist");
        return librarian;
    }

    public void checkLogin(String username, String password) {
        Librarian librarian = librarianRepository.checkLibrarianLogin(username, password);
        if (librarian == null) throw new ApiException("wrong username or password");
    }

    public Librarian getLibrarianByEmail (String email) {
        Librarian librarian = librarianRepository.findLibrarianByEmail(email);
        if (librarian == null) throw new ApiException("email not exist");
        return librarian;
    }
}

 