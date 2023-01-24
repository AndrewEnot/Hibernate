package com.example.hibernatehomework.repository;

import com.example.hibernatehomework.model.Student;
import java.util.List;

/*
 * @author Oksiuta Andrii
 * 20.01.2023
 * 14:58
 */

public interface StudentCustomRepository {

  void saveCustom(Student student);

  void deleteById(int id);

  void removeAll();

  Student updateFieldByID(int id, String column, String value);

  List<Student> getAll();

  Student findById(int id);

  List<Student> findByName(String name);
}
