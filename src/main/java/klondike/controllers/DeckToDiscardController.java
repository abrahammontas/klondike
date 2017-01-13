package klondike.controllers;

import klondike.models.Card;
import klondike.models.StackCard;
import klondike.models.StackDeck;
import klondike.utils.IO;
import klondike.views.GameView;

public class DeckToDiscardController {

	private StackDeck deck;
	private StackCard discard;
	private GameView gameView;
	private IO io;

	public DeckToDiscardController(StackCard discard, StackDeck deck, GameView gameView) {
		this.discard = discard;
		this.deck = deck;
		this.gameView = gameView;
		io = new IO();
	}

	public Boolean execute(Boolean verification) {
		if (deck.getStackCard().isEmpty()) {
		    if(verification) {
		        return true;
		    }
			io.writeln("La baraja está vacía");
		} else {
		    if(deck.getStackCard().size() == 3){
                if(verification) {
                    return true;
                }
    			Card card = deck.getStackCard().pop();
    			card.setHidden(false);
    			discard.getStackCard().push(card);
		    } else {
		        if(verification) {
                    return false;
                }
		        io.writeln("Maximo 3 cartas en descarte.");
		    }
		}
		gameView.imprimirBoard();
		return false;
	}
}
