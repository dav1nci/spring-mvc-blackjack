package org.dav1nci.playgame;

import com.google.gson.Gson;
import org.dav1nci.dbservice.HomeEntity;
import org.dav1nci.dbservice.serviceimplementation.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dav1nci on 20.12.15.
 */
@Controller
public class PlayGameController
{
    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/game")
    public String home(Model model)
    {
        return "playgame/gamefield";
    }

    @RequestMapping(value = "/start")
    public ResponseEntity<String> startGame()
    {
        System.out.println("FROM START");
        cardService.resetDeck();
        List<CardEntity> cards = new ArrayList<>();
        for (int i = 0; i < 4; ++i)
        {
            cards.add(cardService.getCard());
        }
        ServerResponce responce = new ServerResponce();
        responce.setCards(cards);
        responce.setScoreDealer(cards.get(0).getCost() + cards.get(1).getCost());
        responce.setScorePlayer(cards.get(2).getCost() + cards.get(3).getCost());
        if (responce.getScorePlayer() == 21)
            responce.setWin(1);
        Gson gson = new Gson();
        return new ResponseEntity<String>(gson.toJson(responce), HttpStatus.OK);
    }

    @RequestMapping(value = "/hit")
    public ResponseEntity<String> hit(@RequestBody ServerRequest request)
    {
        System.out.println("From HIT");
        CardEntity card = cardService.getCard();
        ServerResponce responce = new ServerResponce();
        List<CardEntity> cards = new ArrayList<>();
        cards.add(card);
        responce.setCards(cards);
        System.out.println("Player Score" + request.getScorePlayer());
        System.out.println("Card Cost" + card.getCost());
        request.setScorePlayer(request.getScorePlayer() + card.getCost());
        responce.setScorePlayer(request.getScorePlayer());
        System.out.println("After adding Score Player" + request.getScorePlayer());
        if (request.getScorePlayer() > 21)
        {
            responce.setWin(-1);
            if (request.getIsAce() == 1)
            {
                responce.setScorePlayer(request.getScorePlayer() - 10);
                if (responce.getScorePlayer() > 21)
                    responce.setWin(-1);    //loose
                else responce.setWin(0);
            }
            return new ResponseEntity<String>(new Gson().toJson(responce), HttpStatus.OK);
        }
        return new ResponseEntity<String>(new Gson().toJson(responce), HttpStatus.OK);
    }

    @RequestMapping(value = "/stand")
    public ResponseEntity<String> stand(@RequestBody ServerRequest request)
    {
        System.out.println("SCORE PLAYER" + request.getScoreDealer());
        ServerResponce responce = new ServerResponce();
        if (request.getScoreDealer() < 17)
        {
            List<CardEntity> cards = new ArrayList<>();
            responce.setScoreDealer(request.getScoreDealer());
            do {
                CardEntity card = cardService.getCard();
                cards.add(card);
                responce.setScoreDealer(responce.getScoreDealer() + card.getCost());
            } while (responce.getScoreDealer() < 17);
            responce.setCards(cards);
            return new ResponseEntity<String>(new Gson().toJson(responce), HttpStatus.OK);
        }
        responce.setScoreDealer(request.getScoreDealer());
        return new ResponseEntity<String>(new Gson().toJson(responce), HttpStatus.OK);
    }
}
