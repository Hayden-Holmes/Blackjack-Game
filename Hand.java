import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Hand {
    int total=0;
    int num11s=0;

        List<Cards> handList;
        public Hand(){
            handList= new ArrayList<>();
        }
        public void addCard(Cards card){
            handList.add(card);
            if(card.getValue()==11){
                num11s++;
            }
            int tempTotal= total+card.getValue();
            total+= card.getValue();

            while(total>21 && num11s>0){
                total-=10;
                num11s--;
            }

        }

        public void emptyHand(){
            handList.clear();
            total=0;
            num11s=0;
        }


    public String toString() {
        String str = "";
        for(Cards c: handList){
            str+=c+" ";
        }
        return "Hand: "+str;
    }

    public int getTotal(){
        return total;
    }
}
class PHand extends Hand{
    public PHand(){
        super();
    }

}

class DHand extends Hand{
    public DHand(){
        super();
    }

    public String secondCardString(){
        return handList.get(1).toString();
    }
    public int secondCardValue(){
        return handList.get(1).getValue();
    }
    public String flipCard(){
        return handList.get(0).toString();
    }
}


