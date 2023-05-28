package com.example.quizapp.service;

import com.example.quizapp.repository.QuizRepository;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.QuizStatus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author mehul jain
 */
@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(Quiz quiz) {
        quiz.setStatus(QuizStatus.INACTIVE);
        return quizRepository.save(quiz);
    }

    public Integer getQuizResult(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Quiz not found."));

        if (quiz.getStatus() != QuizStatus.FINISHED) {
            throw new IllegalStateException("Quiz is not finished yet.");
        }

        return quiz.getRightAnswer();
    }

    public Quiz getActiveQuiz() {
        LocalDateTime now = LocalDateTime.now();
        return quizRepository.findByStatusAndStartDateBeforeAndEndDateAfter(QuizStatus.ACTIVE, now, now)
                .orElseThrow(() -> new NoSuchElementException("No active quiz found."));
    }

    public List<Quiz> getActiveQuizzes() {
        LocalDateTime now = LocalDateTime.now();
        return quizRepository.findByStatus(QuizStatus.ACTIVE)
                .stream()
                .filter(quiz -> quiz.getStartDate().isBefore(now) && quiz.getEndDate().isAfter(now))
                .collect(Collectors.toList());
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findByStatus(QuizStatus.ACTIVE)
                .stream()
                .filter(quiz -> quiz.getStatus() == QuizStatus.ACTIVE)
                .collect(Collectors.toList());
    }

    @Scheduled(fixedDelay = 60000) // Check status every minute
    public void updateQuizStatus() {
        LocalDateTime now = LocalDateTime.now();
        List<Quiz> quizzes = quizRepository.findAll();

        for (Quiz quiz : quizzes) {
            if (quiz.getEndDate().isBefore(now)) {
                quiz.setStatus(QuizStatus.FINISHED);
            } else if (quiz.getStartDate().isBefore(now)) {
                quiz.setStatus(QuizStatus.ACTIVE);
            } else {
                quiz.setStatus(QuizStatus.INACTIVE);
            }
            quizRepository.save(quiz);
        }
    }
}
