import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    int i=0;
    Cards[] cards;
    List<Cards> cardsList;

    public Deck(){
        cards = new Cards[52];


    }
    public void fill(){
        int i = 0;
        for (Cards.Suits s : Cards.Suits.values()) {
            for (Cards.Ranks r : Cards.Ranks.values()) {
                cards[i]= new Cards(r,s);
                i++;  // increment i here
            }
        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }

    public Cards getTopCard(){
        Cards card=cards[i];
        i++;
        return card;

    }

    public void shuffle(){
        System.out.println("Shuffling deck");
        cardsList=Arrays.asList(cards);
        Collections.shuffle(cardsList);
        cardsList.toArray(cards);
        i=0;
    }

    public int checkCardsLeft(){
        return 52-i;
    }
}
