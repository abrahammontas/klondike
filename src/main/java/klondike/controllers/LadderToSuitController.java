package klondike.controllers;

import java.util.ArrayList;
import java.util.Hashtable;

import klondike.models.Card;
import klondike.models.StackCard;
import klondike.models.StackLadder;
import klondike.models.Suit;
import klondike.utils.IO;
import klondike.views.GameView;

public class LadderToSuitController {
	
	private ArrayList<StackLadder> ladders;
	private Hashtable<Suit, StackCard> suitStacks;
	private GameView gameView;
	private IO io;
	
	public LadderToSuitController(ArrayList<StackLadder> ladders, Hashtable<Suit, StackCard> suitStacks, GameView gameView){
		this.ladders = ladders;
		this.suitStacks = suitStacks;
		this.gameView = gameView;
		io = new IO();
	}

	public Boolean execute(Boolean verification, int fromLadder){
	    
	    if(!verification){
	        fromLadder = io.readInt("De que Escalera? [1-7]:");
	    }
	   
		StackLadder ladder = ladders.get(fromLadder - 1);
		Card card = ladder.getStackCard().lastElement();
		StackCard stackSuit = suitStacks.get(card.getSuit());
		
		if(stackSuit.getStackCard().isEmpty()){
		    
			if(card.getNumber().getCardValue()==1){
			    
			    if(verification) {
                    return true;
                }
			    
				stackSuit.getStackCard().push(ladder.getStackCard().pop());
				
			}else{
			    int lastValue = stackSuit.getStackCard().lastElement().getNumber().getCardValue();
                if(lastValue == card.getNumber().getCardValue()+1) {
                    if(verification) {
                        return true;
                    }
                    
                    stackSuit.getStackCard().push(ladder.getStackCard().pop());
                } else {
    			    if(verification) {
                        return false;
                    }
    			    
    				io.writeln("La carta no corresponde");
                }
				
			}
		}else{
		    
			int previousCardValue = stackSuit.getStackCard().lastElement().getNumber().getCardValue();
			
			if(previousCardValue == card.getNumber().getCardValue()-1) {
			    
			    if(verification) {
                    return true;
                }
			    
				stackSuit.getStackCard().push(ladder.getStackCard().pop());
				
			} else {
			    
			    if(verification) {
                    return false;
                }
			    
				io.writeln("La carta no corresponde");
			}
		}
		
		gameView.imprimirBoard();
		return false;
		
	}
}
