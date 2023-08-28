package com.example.librarysystem.Repository;

import com.example.librarysystem.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
    Librarian findLibrarianById(Integer id);

    Librarian findLibrarianByEmail(String email);

    @Query("select l from Librarian l where l.username=?1 and l.password=?2")
    Librarian checkLibrarianLogin(String username, String password);
}
