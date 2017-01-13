package klondike.controllers;

import klondike.models.StackCard;
import klondike.models.StackDeck;
import klondike.utils.IO;
import klondike.views.GameView;

public class DiscardToDeckController {

	private StackDeck deck;
	private StackCard discard;
	private GameView gameView;
	private IO io;

	public DiscardToDeckController(StackCard discard, StackDeck deck, GameView gameView) {
		this.discard = discard;
		this.deck = deck;
		this.gameView = gameView;
		io = new IO();
	}

	public Boolean execute(Boolean verification) {
		if (discard.getStackCard().isEmpty()) {
		    
		    if(verification) {
		        return false;
		    }
		    
			io.writeln("El descarte está vacío");
		} else {
		    
		    if(verification) {
		        return false;
		    }
		    
			while (discard.getStackCard().size() != 0) {
				deck.getStackCard().push(discard.getStackCard().pop());
			}
		}
		
		gameView.imprimirBoard();
		return false;
	}
}
