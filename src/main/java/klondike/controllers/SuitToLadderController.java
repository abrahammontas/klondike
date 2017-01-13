package klondike.controllers;

import klondike.models.Color;
import java.util.ArrayList;
import java.util.Hashtable;

import klondike.models.Card;
import klondike.models.StackCard;
import klondike.models.StackLadder;
import klondike.models.Suit;
import klondike.utils.IO;
import klondike.views.GameView;

public class SuitToLadderController {

	private ArrayList<StackLadder> ladders;
	private Hashtable<Suit,StackCard> suitStacks;
	private GameView gameView;
	private IO io;

	public SuitToLadderController(ArrayList<StackLadder> ladders,Hashtable<Suit,StackCard> suitStacks, GameView gameView){
		
		this.ladders=ladders;
		this.gameView = gameView;
		this.suitStacks = suitStacks;
		io = new IO();
	}

	public Boolean execute(Boolean verification, int fromSuit, int toLadder){
	    if(!verification){
    		fromSuit = io.readInt("De que Palo? [1-4]:");
    		toLadder = io.readInt("A que Escalera? [1-7]:");
	    }
	    
		Suit suitStack = Suit.values()[fromSuit - 1];
		StackCard suit = suitStacks.get(suitStack);
		Color suitColor = suitStack.getColor();
		
		if(suit.getStackCard().isEmpty()){
		    if(verification) {
                return false;
            }
		    
			io.writeln("El Palo esta vacio");
		}else{			
            Card card = suit.getStackCard().pop();
            Color cardColor = card.getSuit().getColor();
            if(cardColor != suitColor){
    		    if(verification) {
                    return true;
                }
    		    
    			ladders.get(toLadder - 1).getStackCard().push(card);
            } else {
                if(verification) {
                    return false;
                }
                
                io.writeln("Las cartas deben ser de diferentes colores.");
            }
		}
		
		gameView.imprimirBoard();
		return false;
	}
}