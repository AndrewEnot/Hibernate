package com.example.hibernatehomework.repository;

import com.example.hibernatehomework.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Oksiuta Andrii
 * 23.01.2023
 * 12:36
 */
@Repository
public interface StudentJpaRepository extends JpaRepository<Student,Integer>, StudentCustomRepository {

}
