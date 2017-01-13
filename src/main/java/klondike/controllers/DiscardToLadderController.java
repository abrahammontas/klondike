package klondike.controllers;

import java.util.ArrayList;

import klondike.models.Card;
import klondike.models.Color;
import klondike.models.StackCard;
import klondike.models.StackLadder;
import klondike.utils.IO;
import klondike.views.GameView;

public class DiscardToLadderController {
	
	private StackCard discard;
	private ArrayList<StackLadder> ladders;
	private GameView gameView;
	private IO io;
	
	public DiscardToLadderController(StackCard discard,ArrayList<StackLadder> ladders, GameView gameView){
		this.discard=discard;
		this.ladders=ladders;
		this.gameView = gameView;
		io = new IO();
	}

	public Boolean execute(Boolean verification){
		if (discard.getStackCard().isEmpty()) {
		    
		    if(verification) {
                return false;
            }
		    
			io.writeln("El descarte esta vacio");
			
		} else {
			
		    int fromLadder = io.readInt("A que Escalera? [1-7]:");
			Card discardCard = discard.getStackCard().lastElement();
			Color discarColor = discardCard.getSuit().getColor();
			int discardValue = discardCard.getNumber().getCardValue();
			StackLadder escalera = ladders.get(fromLadder - 1);
			
			if (escalera.getStackCard().isEmpty()) {
			    
				if (discardValue == 13) {
				    
				    if(verification) {
		                return true;
		            }
				    
					escalera.getStackCard().push(discard.getStackCard().pop());
					
				} else {
				    
				    if(verification) {
		                return false;
		            }
				    
					io.writeln("La carta no corresponde");
					
				}
			} else {
			    
				Card ladderCard = escalera.getStackCard().lastElement();
				Color ladderColor = ladderCard.getSuit().getColor();
				int ladderCardValue = ladderCard.getNumber().getCardValue();
				
				if ((discardValue == ladderCardValue - 1) && (ladderColor != discarColor)) {
				    
				    if(verification) {
		                return true;
		            }
				    
					escalera.getStackCard().push(discard.getStackCard().pop());
					
				} else {
				    
				    if(verification) {
		                return false;
		            }
				    
					io.writeln("La carta no corresponde");
					
				}
			}
		}
		
		gameView.imprimirBoard();
		
		return false;
	}
}