package Luca.Utzeri.capstone.Project.payloads.cards;

import java.util.ArrayList;

public record AllCardsDTO(long id,
                          String name,
                          ArrayList<String> card_images
                          ) {
}
