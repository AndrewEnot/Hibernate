package com.example.hibernatehomework;

import com.example.hibernatehomework.api.Value;
import com.example.hibernatehomework.dto.StudentDto;
import com.example.hibernatehomework.services.StudentService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class HibernateHomeWorkApplication {

  private final StudentService studentService;

  @Autowired
  public HibernateHomeWorkApplication(
      StudentService studentService) {
    this.studentService = studentService;
  }

  public static void main(String[] args) {
    SpringApplication.run(HibernateHomeWorkApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void init() {

    studentService.removeAll();

    var studentOneDto = new StudentDto(null, "Andrew", "andrew@gmail.com");
    studentOneDto = studentService.createStudent(studentOneDto);

    studentService.addMark(studentOneDto.getId(), "History", Value.GOOD);
    studentService.addMark(studentOneDto.getId(), "English", Value.SOSO);
    studentService.addMark(studentOneDto.getId(), "Math", Value.PERFECT);

    var studentTwoDto = new StudentDto(null, "Michele", "michele@gmail.com");
    studentTwoDto = studentService.createStudent(studentTwoDto);

    studentService.addMark(studentTwoDto.getId(), "History", Value.PERFECT);
    studentService.addMark(studentTwoDto.getId(), "English", Value.GOOD);
    studentService.addMark(studentTwoDto.getId(), "Math", Value.PERFECT);

    var studentThreeDto = new StudentDto(null, "John", "john@gmail.com");
    studentThreeDto = studentService.createStudent(studentThreeDto);

    studentService.addMark(studentThreeDto.getId(), "History", Value.BAD);
    studentService.addMark(studentThreeDto.getId(), "English", Value.NOTBAD);
    studentService.addMark(studentThreeDto.getId(), "Math", Value.GOOD);

    log.info(studentService.getAll().toString());

    log.info(studentService.findById(studentThreeDto.getId()).toString());

    log.info("{}: {}" , "Deleting student with ID", studentTwoDto.getId());
    studentService.deleteById(studentTwoDto.getId());

    studentService.updateFieldByID(studentThreeDto.getId(), "email", "777@hotmail");

    List<StudentDto> andrew = studentService.findByName("Andrew");
    log.info(andrew.toString());
  }
}
