package sk.stuba.fei.uim.oop.card.browns;

import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.card.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class Indiani extends BrownCard{
    public Indiani(String title) {
        super(title);
    }

    @Override
    public ArrayList<PlayingCard> useCard(Player byPlayer, List<Player> players) {
        for (Player player: players) {
            if (player!=byPlayer){
                boolean isBang = false;
                for (int i = 0; i <player.getHandCards().size() ; i++) {
                    if (player.getHandCards().get(i).getTitle().equals("Bang")){
                        System.out.println("Hrac "+ player.getName()+ " ma kartu bang, indiani su na neho kratki...");
                        isBang = true;
                        player.getHandCards().remove(player.getHandCards().get(i));
                        break;
                    }
                }
                if (!isBang){
                    int livesBfr = player.getLives();
                    player.setLives(livesBfr-1);
                    System.out.println("Hrac straca zivot, nema bang");
                }
            }

        }
        return null;
    }
}