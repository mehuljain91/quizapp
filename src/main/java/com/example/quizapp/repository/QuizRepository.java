package com.example.quizapp.repository;

import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.QuizStatus;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author mehul jain
 */
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByStatus(QuizStatus status);

    Optional<Quiz> findByStatusAndStartDateBeforeAndEndDateAfter(QuizStatus status, LocalDateTime startDate, LocalDateTime endDate);
}
