package Luca.Utzeri.capstone.Project.controllers;

import Luca.Utzeri.capstone.Project.payloads.cards.AllCardsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardinfo.php")
public class CardsController {

    @GetMapping
    public AllCardsDTO cardList (@RequestBody AllCardsDTO cards){
        return cards;
    }
}
