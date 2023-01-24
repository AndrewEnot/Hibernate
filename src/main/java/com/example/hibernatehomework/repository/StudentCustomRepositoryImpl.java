package com.example.hibernatehomework.repository;

import com.example.hibernatehomework.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/*
 * @author Oksiuta Andrii
 * 21.01.2023
 * 14:25
 */
@Slf4j
@Repository
public class StudentCustomRepositoryImpl implements StudentCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  @Transactional
  public void saveCustom(Student student) {
    log.info("call saveCustom");
    entityManager.persist(student);
  }

  @Override
  @Transactional
  public void deleteById(int id) {
    log.info("call deleteById");
    entityManager.createQuery("delete from Mark m where m.student.id = " + id).executeUpdate();
    entityManager.createQuery("delete from Student s where s.id = " + id).executeUpdate();
  }

  @Override
  @Transactional
  public void removeAll() {
    log.info("call removeAll");
    entityManager.createQuery("delete from Mark m").executeUpdate();
    entityManager.createQuery("delete from Student s").executeUpdate();
  }


  @Override
  @Transactional
  public List<Student> getAll() {
    log.info("call getAll");
    Query query = entityManager
        .createQuery("select s from Student s");
    return query.getResultList();
  }

  @Override
  @Transactional
  public Student findById(int id) {
    log.info("call findById");
    Query query = entityManager
        .createQuery("select s from Student s where s.id = " + id);
    if (query == null) {
      throw new EntityNotFoundException("There is no Student with such ID!");
    }
    return (Student) query.getResultList().get(0);
  }

  @Override
  @Transactional
  public List<Student> findByName(String name) {
    List<Student> resultList = new ArrayList<>();
    if (name != null) {
      log.info("call findByName");
      Query query = entityManager
          .createQuery("select s from Student s where s.name = '" + name + "'");
      resultList = query.getResultList();
    }
    return resultList;
  }

  @Override
  @Transactional
  public Student updateFieldByID(int id, String column, String value) {
    log.info("call updateFieldByID");
    Query query = entityManager
        .createNativeQuery("update my_school.student set " + column + "=:value where id=:studentId");
    query.setParameter("value", value);
    query.setParameter("studentId", id);
    query.executeUpdate();
    return findById(id);
  }
}
