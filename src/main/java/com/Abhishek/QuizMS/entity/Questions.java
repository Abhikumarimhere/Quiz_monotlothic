package com.Abhishek.QuizMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String category;
    private String DifficultyLevel;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String Questions;
    private String Answers;

}
