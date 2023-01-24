package com.example.hibernatehomework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author Oksiuta Andrii
 * 20.01.2023
 * 10:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

  private Integer id;
  private String name;
  private String email;

}
