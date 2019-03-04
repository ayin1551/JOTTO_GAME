package Jotto.controller;

import Jotto.domain.Game;
import Jotto.domain.GameState;
import Jotto.domain.Round;
import Jotto.services.GameService;
import Jotto.services.RoundService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping(value="/detail.html")
public class ajaxDetailsController {
    private GameService gameService;
    private RoundService roundService;
    @Autowired
    public void setRoundService(RoundService roundService) {
        this.roundService = roundService;
    }
    @Autowired
    public void setGameService(GameService gService) {
        this.gameService = gService;
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    @ResponseBody
    public String getDetails(HttpServletRequest request) {
        //var arr = [game_id,user_word,cpu_word,game_state,date_created];
        System.out.println("Print this");
        String gameID = request.getParameter("gameID");
        //Gson gson = new GsonBuilder().create();
        //String jsonObject = gson.toJson(rounds);
        //System.out.println(jsonObject);
        //return jsonObject.toString();
        System.out.println(gameID);
        return getMatchDetails(Integer.parseInt(gameID)).toString();
    }

    public JSONObject getMatchDetails(Integer gameID) {
        System.out.println("PASSED ARG:" + gameID);
        Game game = gameService.getGameById(gameID);
        System.out.println(game.getGame_id());
        String user_word = game.getUser_word();
        String cpu_word = game.getCpu_word();
        List<Round> rounds = (List<Round>) roundService.getMatchDetails(gameID);
        List<List<Character>> userLetters = new ArrayList();
        List<List<Character>> cpuLetters = new ArrayList();
        List<Integer> userCorrectCounter = new ArrayList<Integer>();
        List<Integer> cpuCorrectCounter = new ArrayList<Integer>();
        for(Round a:rounds){

            List<Character> userCorrectLetters = new ArrayList<Character>();
            List<Character> cpuCorrectLetters = new ArrayList<Character>();
            int userCounter = 0;
            int cpuCounter = 0;
            String cpu_guess = a.getCpu_guess();
            String user_guess = a.getUser_guess();

            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++) {
                    if (cpu_guess.charAt(i) == user_word.charAt(j)) {
                        cpuCounter++;
                        cpuCorrectLetters.add(cpu_guess.charAt(i));
                        break;
                    }
                }
            }

            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++) {
                    if (user_guess.charAt(i) == cpu_word.charAt(j)) {
                        userCounter++;
                        userCorrectLetters.add(user_guess.charAt(i));
                        break;
                    }
                }
            }

            userLetters.add(userCorrectLetters);
            cpuLetters.add(cpuCorrectLetters);
            cpuCorrectCounter.add(cpuCounter);
            userCorrectCounter.add(userCounter);
        }
        JSONObject result = new JSONObject();
        result.put("length",rounds.size());
        result.put("dateCreated",game.getDate_created());
        result.put("gameState",game.getGame_state());
        result.put("matchID",gameID);
        result.put("matchDetails",rounds);
        result.put("userLetter",userLetters);
        result.put("cpuLetters",cpuLetters);
        result.put("cpuCorrectCounter",cpuCorrectCounter);
        result.put("userCorrectCounter",userCorrectCounter);
        result.put("user_word",user_word);
        result.put("cpu_word",cpu_word);
        System.out.println(game.getGame_id());
        System.out.println("PASSED ARG: " + gameID);
        return result;
    }
}
