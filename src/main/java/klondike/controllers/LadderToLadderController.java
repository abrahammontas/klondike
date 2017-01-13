package klondike.controllers;

import java.util.ArrayList;

import klondike.models.Color;
import klondike.models.StackCard;
import klondike.models.StackLadder;
import klondike.utils.IO;
import klondike.views.GameView;

public class LadderToLadderController {
	
	private ArrayList<StackLadder> ladders;
	private GameView gameView;
	private IO io;
	
	public LadderToLadderController(ArrayList<StackLadder> ladders, GameView gameView){
		this.ladders = ladders;
		this.gameView = gameView;
		io = new IO();
	}
	
	public Boolean execute(Boolean verification, int fromLadder, int howManyCards, int toLadder){
	    
	    if(!verification){
    		fromLadder = io.readInt("De que Escalera? [1-7]:");
    		howManyCards = io.readInt("Cuantas Cartas?:");
    		toLadder = io.readInt("A que Escalera? [1-7]:");
	    }
	    
		StackLadder from = ladders.get(fromLadder - 1);
		StackLadder to = ladders.get(toLadder - 1);
        Color fromColor = from.getStackCard().lastElement().getSuit().getColor();
        Color toColor = to.getStackCard().lastElement().getSuit().getColor();
		int valueFromLadder = from.getStackCard().lastElement().getNumber().getCardValue();
		int valueToLadder = to.getStackCard().lastElement().getNumber().getCardValue();

		if ((valueFromLadder == valueToLadder-1) && 
		        (!from.getStackCard().elementAt(howManyCards-1).isHidden()) && 
		        (fromColor != toColor)) {
		    
            if(verification) {
                return true;
            }
		    
			StackCard stackCard = new StackCard();
			
			for (int i = 0; i < howManyCards; i++) {
				stackCard.getStackCard().push(ladders.get(fromLadder - 1).getStackCard().pop());
			}
			
			while (stackCard.getStackCard().size() != 0) {
				ladders.get(toLadder - 1).getStackCard().push(stackCard.getStackCard().pop());
			}
			
			gameView.imprimirBoard();
			
		} else {
		    
		    if(verification) {
                return false;
            }
		    
			io.writeln("No se puede mover la carta.");
			
		}
		
		return false;
	}
}
