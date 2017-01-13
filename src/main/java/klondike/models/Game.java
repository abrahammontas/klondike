package klondike.models;

import java.util.ArrayList;
import java.util.Hashtable;

public class Game {
    private StackDeck deck;
    private ArrayList<StackLadder> ladders;
    private Hashtable<Suit, StackCard> suitStacks;
    private StackCard discard;
    
    public Game() {
        deck = new StackDeck();
        deck.shuffle();
        ladders = new ArrayList<StackLadder>();
        suitStacks = new Hashtable<Suit, StackCard>();
        discard = new StackCard();
        init();
    }
    
    public void init() {
        for (int i = 0; i < Suit.values().length; i++) {
            StackCard suit = new StackCard();
            suitStacks.put(Suit.values()[i], suit);
        }
        for (int i = 1; i <= 7; i++) {
            StackLadder stackLadder = new StackLadder();
            stackLadder.addCards(i, deck);
            ladders.add(stackLadder);
        }
    }

    public StackDeck getDeck() {
        return deck;
    }

    public void setDeck(StackDeck deck) {
        this.deck = deck;
    }

    public ArrayList<StackLadder> getLadders() {
        return ladders;
    }

    public void setLadders(ArrayList<StackLadder> ladders) {
        this.ladders = ladders;
    }

    public Hashtable<Suit, StackCard> getSuitStacks() {
        return suitStacks;
    }

    public void setSuitStacks(Hashtable<Suit, StackCard> suitStacks) {
        this.suitStacks = suitStacks;
    }

    public StackCard getDiscard() {
        return discard;
    }

    public void setDiscard(StackCard discard) {
        this.discard = discard;
    }
}