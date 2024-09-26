package com.bootapps.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapps.entitities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    public Author findByAuthorno(Integer authorno);
}
