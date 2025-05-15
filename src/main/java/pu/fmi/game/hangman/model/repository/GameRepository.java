package pu.fmi.game.hangman.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pu.fmi.game.hangman.model.entity.HangmanGame;
import pu.fmi.game.hangman.model.entity.Status;

public interface GameRepository extends JpaRepository<HangmanGame, Long> {

  // SELECT * FROM HANGMAN_GAME
  // WHERE STATUS = ?
  List<HangmanGame> findByStatus(Status status);

  // TODO: Add query method to find first 10 games ordered by started on date desc
  @Query(value = "SELECT TOP 10 * FROM HANGMAN_GAME ORDER BY STARTED_ON_DATE DESC;", nativeQuery = true)
  List<HangmanGame> findTop10GamesOrderByStartedOnDateDesc();
  // Look here for examples: https://docs.spring.io/spring-data/jpa/reference/repositories/query-methods-details.html#repositories.limit-query-result
}
