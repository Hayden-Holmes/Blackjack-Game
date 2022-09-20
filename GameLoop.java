import java.util.Scanner;

public class GameLoop {
    static String Black= "\u001b[30m";
    static String Red= "\u001b[31m";
    static String Green= "\u001b[32m";
    static String Yellow= "\u001b[33m";
    static String Blue= "\u001b[34m";
    static String Magenta= "\u001b[35m";
    static String Cyan= "\u001b[36m";
    static String White= "\u001b[37m";
    static String Reset= "\u001b[0m";

    static Scanner in = new Scanner(System.in);
    public static void dealCards(){
        pHand.addCard(deck.getTopCard());
        dHand.addCard(deck.getTopCard());
        pHand.addCard(deck.getTopCard());
        dHand.addCard(deck.getTopCard());

        System.out.println("Your hand "+ pHand);
        System.out.println("Dealers hand: Face Down Card, "+dHand.secondCardString());
    }

    public static void determineWinner(){
        System.out.print(Red);
        if(dHand.getTotal()>pHand.getTotal()){
            System.out.println("Dealer wins");
        } else if (dHand.getTotal()< pHand.getTotal()) {
            System.out.println("Player wins");
        }else {
            System.out.println("Push");
        }
        System.out.print(Reset);

    }

    public static void dealerTurn(){
        System.out.print(Green+"Dealer flipped a "+dHand.flipCard());
        System.out.println(" and now has "+dHand.getTotal()+Reset);
        while(dHand.getTotal()<17){
            Cards c = deck.getTopCard();
            System.out.print(Green+"Dealer pulled a "+c);
            dHand.addCard(c);
            System.out.println(" and now has "+dHand.getTotal()+Reset);
        }
        if(dHand.getTotal()>21) {
            System.out.println("Bust");
        }

    }

    public static void playerTurn() {
        boolean run=true;
        do {

            System.out.println(Cyan+"You have " + pHand.getTotal());
            if(pHand.getTotal()>21){
                System.out.println("Bust");
                break;
            }
            System.out.println("Dealer is showing: " + dHand.secondCardValue());
            System.out.print(White+"Would you like to hit? [Y]es or [N]o"+Reset);
            String input= in.nextLine();
            if(input.equals("y")){
                Cards c = deck.getTopCard();
                pHand.addCard(c);
                System.out.println(Green+"You were dealt : "+c+Reset);
            }else{
                run = false;
            }


        }while(run);
    }

    static Deck deck = new Deck();
    static PHand pHand=new PHand();
    static DHand dHand=new DHand();






    public static void main(String[] args) {
        boolean run=true;
        deck.fill();
        deck.shuffle();
        do{
            while(true) {
                if(deck.checkCardsLeft()<10)
                    deck.shuffle();
                System.out.println(Green+"Dealing"+Reset);
                dealCards();
                playerTurn();
                if (pHand.getTotal() > 21) {
                    System.out.println(Red+"Dealer wins"+Reset);
                    pHand.emptyHand();
                    dHand.emptyHand();
                    break;
                }
                dealerTurn();
                if (dHand.getTotal() >21){
                    System.out.println(Red+"Player wins"+Reset);
                    pHand.emptyHand();
                    dHand.emptyHand();
                    break;
                }
                determineWinner();
                pHand.emptyHand();
                dHand.emptyHand();

            }
        }while(run);
    }
}
