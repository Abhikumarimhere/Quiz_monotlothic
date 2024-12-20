package com.Abhishek.QuizMS.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private String title;

    @ManyToMany
    private List<Questions> QuestionList;

}
