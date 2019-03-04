package Jotto.services;

import Jotto.domain.Round;

import java.util.List;

public interface RoundService {
    Round addRound(Round round); //adds round *C
    Round getRoundByID(Integer roundID); //gets a round by its roundID *R
    Round getMostRecentRound(Integer gameID); //gets the most recent round for a game by its gameID *R
    List<Round> getMatchDetails(Integer gameID); //Gets all the rounds for a game by its gameID *R
    List<Round> getAllRounds(); //Gets all rounds in db *R

}