package com.example.hibernatehomework.repository;

import com.example.hibernatehomework.model.Mark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Oksiuta Andrii
 * 18.01.2023
 * 16:39
 */
@Repository
public interface MarkRepository extends CrudRepository<Mark, Integer> {
}
