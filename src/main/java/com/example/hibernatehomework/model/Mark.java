package com.example.hibernatehomework.model;

/*
 * @author Oksiuta Andrii
 * 18.01.2023
 * 12:08
 */

import com.example.hibernatehomework.api.Value;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(schema = "my_school")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mark {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "fk_student_id", nullable = false)
  private Student student;
  private String discipline;
  @Enumerated(EnumType.STRING)
  private Value value;
}
