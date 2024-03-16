package Luca.Utzeri.capstone.Project.payloads.cards;

import java.lang.reflect.Array;
import java.util.ArrayList;

public record SingleCardDTO(long id,
                            String name,
                            String type,
                            String frameType,
                            String desc,
                            String pend_desc,
                            String monster_desc,
                            long atk,
                            long def,
                            int level,
                            String race,
                            String attribute,
                            String archetype,
                            int scale,
                            String ygoprodeck_url,
                            ArrayList<Array> card_sets,
                            ArrayList<String> card_images,
                            Array card_prices) {
}
