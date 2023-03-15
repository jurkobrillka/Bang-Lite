package sk.stuba.fei.uim.oop.card.browns;

import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.card.PlayingCard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class CatBalou extends BrownCard{

    public CatBalou(String title) {
        super(title);
    }

    @Override
    public int useCard(Player player, List<Player> players) {
        return 0;
    }

    @Override
    public ArrayList<PlayingCard> useCard(Stack<PlayingCard> deck, Player byPlayer, List<Player> players) {
        System.out.println("Zadaj komu chces nieco ukradnut: ");
        Player poorPlayer = choicePlayerToBeAttacked(byPlayer,players);

        int indexCard = 0;
        if (ZKlavesnice.readString(("Zadaj ci chces ukradnut z ruky alebo zo stola (1/0): ")).equals("1")) {
            //z ruky

            if (poorPlayer.getHandCards().isEmpty()) {
                System.out.println("Nema ziadne karty na ruke");
            } else {
            while (true) {
                System.out.println("Zadaj poradove cislo ktoru kartu z ruky chces ukradnut: ");
                for (int j = 0; j < poorPlayer.getHandCards().size(); j++) {
                    System.out.print("(" + (j + 1) + ".), ");
                }
                indexCard = ZKlavesnice.readInt("Zadaj cislo");
                if (indexCard < 1 || indexCard > poorPlayer.getHandCards().size()) {
                    System.out.println("Zle si zadal, prosiim zopakuj svoju volbu");
                } else {
                    break;
                }
            }
            System.out.println("Ides vyhodit hracovi " + poorPlayer.getName() + " kartu " + poorPlayer.getHandCards().get(indexCard-1).getTitle() + ".");
            poorPlayer.getHandCards().remove(indexCard - 1);
        }

        }
        else {
            //zo stola
            if (poorPlayer.getTableCards().isEmpty()) {
                System.out.println("Nema ziadne karty na stole");
            } else {
            while (true) {
                System.out.println("Zadaj poradove cislo ktoru kartu zo stola chces ukradnut: ");
                for (int j = 0; j < poorPlayer.getTableCards().size(); j++) {
                    System.out.print("(" + (j + 1) + ".) " + poorPlayer.getTableCards().get(j).getTitle() + ", ");
                }
                indexCard = ZKlavesnice.readInt("Zadaj cislo");
                if (indexCard < 1 || indexCard > poorPlayer.getTableCards().size()) {
                    System.out.println("Zle si zadal, prosiim zopakuj svoju volbu");
                } else {
                    break;
                }
            }
            System.out.println("Ides vyhodit hracovi " + poorPlayer.getName() + " kartu " + poorPlayer.getTableCards().get(indexCard-1).getTitle() + ".");
            poorPlayer.getTableCards().remove(indexCard - 1);
        }

        }

        return null;
    }
}
