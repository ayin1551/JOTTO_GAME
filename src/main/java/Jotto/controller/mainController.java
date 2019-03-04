package Jotto.controller;

import Jotto.algo.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class mainController {
    @RequestMapping(value={"/","index.html"})
    String index(){
        return "index";
    }

    @RequestMapping(value={"home.html"})
    String home(){
        return  "home";
    }

    @RequestMapping(value={"detail.html"})
    String detail(){
        return "detail";
    }

    @RequestMapping(value={"game.html"})
    String game(){
        return "game";
    }

    @RequestMapping(value={"history.html"})
    String history(){
        return "history";
    }

    @RequestMapping(value={"newgame.html"})
    String newgame(){
        return "newgame";
    }

//    @RequestMapping(value="/",method={RequestMethod.POST})
//    public String formSubmit(String input_word){
//        System.out.println(input_word);
//        Algorithm.initialSet();
//        Algorithm.emptyAll();
//        Algorithm.initialSet();
//        if(Algorithm.checkInput(input_word)){
//            Algorithm.startgame(input_word);
//            return "game";
//        }
//        //
//        return "newgame";
//    }
//
//    @RequestMapping(value="/guess",method={RequestMethod.POST})
//    public String formSubmit2(String guess_word){
//        if(Algorithm.checkGuess(guess_word)){
//            Algorithm.userRound(Algorithm.AIgiven,Algorithm.given,guess_word);
//            return "game";
//        }
//        // guess word not a word
//        return "newgame";
//    }

}
