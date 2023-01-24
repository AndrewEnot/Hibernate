package com.example.hibernatehomework.services;

import com.example.hibernatehomework.api.Value;
import com.example.hibernatehomework.dto.StudentDto;
import com.example.hibernatehomework.model.Mark;
import com.example.hibernatehomework.model.Student;
import com.example.hibernatehomework.repository.MarkRepository;
import com.example.hibernatehomework.repository.StudentJpaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
 * @author Oksiuta Andrii
 * 20.01.2023
 * 10:28
 */

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentJpaRepository studentJpaRepository;
  private final ObjectMapper objectMapper;
  private final MarkRepository markRepository;

  public StudentDto createStudent(StudentDto studentDto) {
    Student student = objectMapper.convertValue(studentDto, Student.class);
    studentJpaRepository.saveCustom(student);
    studentDto.setId(student.getId());
    return studentDto;
  }

  public StudentDto addMark(int studentId, String discipline, Value value) {
    var markAdd = new Mark();
    markAdd.setDiscipline(discipline);
    markAdd.setValue(value);
    Student student = studentJpaRepository.findById(studentId);
    markAdd.setStudent(student);
    markRepository.save(markAdd);
    return objectMapper.convertValue(student, StudentDto.class);
  }

  public void deleteById(int id){
    studentJpaRepository.deleteById(id);
  }

  public void removeAll() {
    studentJpaRepository.removeAll();
  }

  public List<StudentDto> getAll() {
    List<StudentDto> resultList = new ArrayList<>();
    var queryList = studentJpaRepository.getAll();
    for (Student student : queryList) {
      resultList.add(objectMapper.convertValue(student, StudentDto.class));
    }
    return resultList;
  }

  public StudentDto findById(int id) {
    var query = studentJpaRepository.findById(id);
    return objectMapper.convertValue(query, StudentDto.class);
  }

  public List<StudentDto> findByName(String name) {
    List<StudentDto> resultList = new ArrayList<>();
    var queryList = studentJpaRepository.findByName(name);
    for (Student student : queryList) {
      resultList.add(objectMapper.convertValue(student, StudentDto.class));
    }
    return resultList;
  }

  /**This method update some field of Entity you chose
   * id - id of Entity
   * column - name of Entity field
   * value - new value of "column"
   * */
  public StudentDto updateFieldByID(int id, String column, String value) {
    var studentDto = new StudentDto();
    if(column == null || value == null) {
      return studentDto;
    }
    var student = studentJpaRepository.updateFieldByID(id, column, value);
    return objectMapper.convertValue(student, StudentDto.class);
  }
}
