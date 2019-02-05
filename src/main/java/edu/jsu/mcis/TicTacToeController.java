package edu.jsu.mcis;

public class TicTacToeController {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    private TicTacToeMove move;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView();
        
    }

    public void start() {
    
        /* MAIN LOOP (repeats until game is over) */
      
        while(model.isGameover() == false)
        {

        /* Display the board using the View's "showBoard()", then use
           "getNextMove()" to get the next move from the player.  Enter
           the move (using the Model's "makeMark()", or display an error
           using the View's "showInputError()" if the move is invalid. */

         view.showBoard(model.toString());
         if(model.isXTurn())
           System.out.println("Player 1 (X) Move:");
         else
           System.out.println("Player 2 (O) Move:");
         
         System.out.print("Enter the row and column numbers, separated by a space: ");
         move = view.getNextMove();
	   System.out.println("");
         
         if(!model.makeMark(move.getRow(), move.getCol()))
           view.showInputError();
    
         
        }
        
        /* After the game is over, show the final board and the winner */

         view.showBoard(model.toString());

         view.showResult(model.getResult().toString());
        
    }

}
