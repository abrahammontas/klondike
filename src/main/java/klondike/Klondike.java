package klondike;

import klondike.controllers.DeckToDiscardController;
import klondike.controllers.DiscardToDeckController;
import klondike.controllers.DiscardToLadderController;
import klondike.controllers.DiscardToSuitController;
import klondike.controllers.FlipCardController;
import klondike.controllers.HelpController;
import klondike.controllers.LadderToLadderController;
import klondike.controllers.LadderToSuitController;
import klondike.controllers.SuitToLadderController;
import klondike.models.Game;
import klondike.utils.IO;
import klondike.views.GameView;

public class Klondike {

    private Game game;
    boolean ok;
    private GameView gameView;
    private IO io;

    public static void main(String[] args) {
        new Klondike();
    }
    
    public Klondike() {
        game = new Game();
        gameView = new GameView(game.getDeck(), game.getLadders(), game.getSuitStacks(), game.getDiscard());
        io = new IO();
        
        gameView.imprimirBoard();
        
        do {
            ok = false;
            int opcion = io.readInt("Opcion= [1-10]:");
            Boolean verification = false;
            if (opcion == 1) {
                new DeckToDiscardController(game.getDiscard(), game.getDeck(), gameView).execute(verification);
            } else if (opcion == 2) {
                new DiscardToDeckController(game.getDiscard(), game.getDeck(), gameView).execute(verification);
            } else if (opcion == 3) {
                new DiscardToSuitController(game.getDiscard(), game.getSuitStacks(), gameView).execute(verification);
            } else if (opcion == 4) {
                new DiscardToLadderController(game.getDiscard(), game.getLadders(), gameView).execute(verification);
            } else if (opcion == 5) {
                new LadderToSuitController(game.getLadders(), game.getSuitStacks(), gameView).execute(verification, 0);
            } else if (opcion == 6) {
                new LadderToLadderController(game.getLadders(), gameView).execute(verification, 0, 0, 0);
            } else if (opcion == 7) {
                new SuitToLadderController(game.getLadders(), game.getSuitStacks(), gameView).execute(verification, 0, 0);
            } else if (opcion == 8) {
                new FlipCardController(game.getLadders(), gameView).execute(verification, 0);
            } else if (opcion == 9) {
                new HelpController(game, gameView).execute();
            } else if (opcion == 10) {
                io.writeln("Gracias por jugar! Hasta luego!");
                System.exit(0);
            }
        } while (!ok);
    }
}