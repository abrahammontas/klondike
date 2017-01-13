package klondike.controllers;

import java.util.ArrayList;

import klondike.models.Card;
import klondike.models.StackLadder;
import klondike.utils.IO;
import klondike.views.GameView;

public class FlipCardController {
	
	private ArrayList<StackLadder> ladders;
	private GameView gameView;
	private IO io;
	
	public FlipCardController(ArrayList<StackLadder> ladders, GameView gameView){
		this.ladders = ladders;
		this.gameView = gameView;
		io = new IO();
	}
	
	public Boolean execute(Boolean verification, int ladderPosition){
	    if(!verification){
	        ladderPosition = io.readInt("En que Escalera? [1-7]:");
	    }
	    
		Card card = ladders.get(ladderPosition - 1).getStackCard().lastElement();
		
		if(card.isHidden()){
		    if(verification) {
                return true;
            }
		    
			card.setHidden(false);
		}else{
		    if(verification) {
                return false;
            }
		    
			io.writeln("Carta ya está volteada");
		}
		
		gameView.imprimirBoard();
		return false;
	}

}
