public class Cards {
    Ranks rank;
    Suits suit;


    public enum Suits {
        Hearts,
        Diamonds,
        Spades,
        Clubs

    }





    public enum Ranks {
        Two("two", 2),
        Three("three", 3),
        Four("four", 4),
        Five("five", 5),
        Six("six", 6),
        Seven("seven", 7),
        Eight("eight", 8),
        Nine("nine", 9),
        Ten("ten", 10),
        Jack("jack", 10),
        Queen("queen", 10),
        King("king", 10),
        Ace("ace", 11, 1);
        private final String rank;
        private final int value;

        Ranks(String rank, int value) {
            this.rank = rank;
            this.value = value;
        }

        Ranks(String rank, int value, int altValue) {
            this.rank = rank;
            this.value = value;
        }
    }






    public Cards(Ranks rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank.toString();
    }

    public int getValue(){
        return rank.value;
    }

    public String getSuit() {
        return suit.toString();
    }



    @Override
    public String toString() {
        return getRank()+" of "+getSuit();
    }


    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.fill();
        deck.shuffle();
        System.out.println(deck);
        PHand hand = new PHand();
        Cards ace = new Cards(Ranks.Ace, Suits.Hearts);
        Cards ace2 = new Cards(Ranks.Ace, Suits.Hearts);
        Cards ten = new Cards(Ranks.Ten, Suits.Hearts);
        hand.addCard(ten); hand.addCard(ace2); hand.addCard(ace);
        System.out.println(hand);
        System.out.println(hand.getTotal());
        hand.emptyHand();
        System.out.println(hand);
        System.out.println(hand.getTotal());

        }

    }










