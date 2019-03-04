package Jotto.services;

import Jotto.domain.Game;
import Jotto.domain.Round;
import Jotto.repositories.GameRepository;
import Jotto.repositories.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoundServiceImpl implements RoundService {

    @Autowired
    private RoundRepository roundRepository;

    @Override
    public Round addRound(Round round){
        return roundRepository.save(round);
    }

    @Override
    public Round getRoundByID(Integer roundID) {
        return roundRepository.findById(roundID).orElse(null);

    }

    @Override
    public Round getMostRecentRound(Integer gameID) {
        return roundRepository.getMostRecentRound(gameID);
    }

    @Override
    public List<Round> getMatchDetails(Integer gameID) {
        return roundRepository.getMatchDetails(gameID);
    }

    @Override
    public List<Round> getAllRounds() {
        List<Round> rounds = (List<Round>) roundRepository.findAll();
        return rounds;
    }


}