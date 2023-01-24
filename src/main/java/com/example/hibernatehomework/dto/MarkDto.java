package com.example.hibernatehomework.dto;

import com.example.hibernatehomework.api.Value;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author Oksiuta Andrii
 * 20.01.2023
 * 10:25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {

  private Integer id;
  private StudentDto student;
  private String discipline;
  private Value value;
}
