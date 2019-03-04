package Jotto.repositories;

import Jotto.domain.Round;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoundRepository extends CrudRepository<Round, Integer> {

    @Query(value = "select * from round a where a.game_id = :game_id and a.round_number= (select MAX(a.round_number) from round a where a.game_id = :game_id) ", nativeQuery = true)
    Round getMostRecentRound(@Param("game_id") Integer gameID);

    @Query(value = "select * from round a where a.game_id = :game_id", nativeQuery = true)
    List<Round> getMatchDetails(@Param("game_id") Integer gameID);
}