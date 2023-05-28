package com.example.quizapp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author mehul jain
 */
@Schema(
        description = "Quiz Model Information"
)
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(
            description = "Quiz Question"
    )
    @Column(nullable = false)
    private String question;

    @Schema(
            description = "Quiz Options"
    )
    @ElementCollection
    @CollectionTable(name = "quiz_options")
    @Column(name = "option")
    private List<String> options;

    @Schema(
            description = "Quiz Right Answer"
    )
    @Column(nullable = false)
    private int rightAnswer;

    @Schema(
            description = "Quiz Start Date"
    )
    @Column(nullable = false)
    private LocalDateTime startDate;

    @Schema(
            description = "Quiz End Date"
    )
    @Column(nullable = false)
    private LocalDateTime endDate;

    @Schema(
            description = "Quiz Status"
    )
    @Enumerated(EnumType.STRING)
    private QuizStatus status;

    // Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public QuizStatus getStatus() {
        return status;
    }

    public void setStatus(QuizStatus status) {
        this.status = status;
    }

}
