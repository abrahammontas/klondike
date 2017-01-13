package klondike.controllers;

import klondike.utils.IO;
import klondike.models.Game;
import klondike.views.GameView;

public class HelpController {

    private GameView gameView;
    private Game game;
    private IO io;
    private Boolean verification = true;

    public HelpController(Game game, GameView gameView){
        this.game = game;
        this.gameView = gameView;
        io = new IO();
    }

    public void execute(){
        io.writeln("Puedes realizar las siguientes movidas");
        
        if(new DeckToDiscardController(game.getDiscard(), game.getDeck(), gameView).execute(verification)) {
            io.writeln("- Mover desde la baraja a descarte.");    
        }
        if(new DiscardToDeckController(game.getDiscard(), game.getDeck(), gameView).execute(verification)) {
            io.writeln("- Mover desde descarte a baraja.");    
        }
        if(new DiscardToSuitController(game.getDiscard(), game.getSuitStacks(), gameView).execute(verification)) {
            io.writeln("- Mover desde descarte a palo.");    
        }
        if(new DiscardToLadderController(game.getDiscard(), game.getLadders(), gameView).execute(verification)) {
            io.writeln("- Mover desde descarte a escalera.");    
        }
        
        for(int i = 1; i < 8; i++){
            if(new LadderToSuitController(game.getLadders(), game.getSuitStacks(), gameView).execute(verification, i)) {
                io.writeln("- Mover desde escalera["+i+"] a palo.");    
            }
        }
        
        for(int i = 1; i < 8; i++){
            for(int j = 1; j < 8; j++){
                int autoInc = 1;
                while(new LadderToLadderController(game.getLadders(), gameView).execute(verification, i, autoInc, j)) {
                    autoInc++; 
                    if(autoInc >= i){
                        break;
                    }
                } 
                
                if(autoInc > 1){
                    autoInc--;
                    io.writeln("- Mover "+autoInc+" cartas desde escalera["+i+"] a escalera["+j+"].");    
                }
            }
        }
        
        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 8; j++){
                if(new SuitToLadderController(game.getLadders(), game.getSuitStacks(), gameView).execute(verification, i, j)) {
                    io.writeln("- Mover desde palo ["+i+"] a escalera["+j+"] a palo.");    
                }
            }
        }
        
        gameView.imprimirBoard();
    }
    
}
