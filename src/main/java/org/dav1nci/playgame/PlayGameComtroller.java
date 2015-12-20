package org.dav1nci.playgame;

import com.google.gson.Gson;
import org.dav1nci.dbservice.HomeEntity;
import org.dav1nci.dbservice.serviceimplementation.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dav1nci on 20.12.15.
 */
@Controller
public class PlayGameComtroller
{
    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/game")
    public String home(Model model)
    {
        return "playgame/gamefield";
    }

    @RequestMapping(value = "/start")
    public ResponseEntity<String> getResponce()
    {
        System.out.println("FROM START");
        cardService.resetDeck();
        List<CardEntity> cards = new ArrayList<>();
        for (int i = 0; i < 4; ++i)
        {
            cards.add(cardService.getCard());
        }

        System.out.println(cards.get(0).getLear());
        Gson gson = new Gson();
        return new ResponseEntity<String>(gson.toJson(cards), HttpStatus.OK);
    }
}
