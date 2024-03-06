
package org.boniardi.guesswords.helper;

import java.util.ArrayList;
import org.boniardi.guesswords.elements.Game;
import org.boniardi.guesswords.elements.GameDefinition;
import org.boniardi.guesswords.elements.Question;

/**
 *
 * @author mboniardi
 */
public class GameHelper {

    public static Game createNewGame(String totQuestion, String level){
        return(createNewGame(Integer.parseInt(totQuestion), Integer.parseInt(level)));
    } 
    
    public static Game createNewGame(int totQuestion, int level) {
        GameDefinition gameDefinition = new GameDefinition();
        gameDefinition.setTotalQuestions(totQuestion);
        gameDefinition.setLevelOfComplexity(level);
        return createNewGame(gameDefinition);
    }

    public static Game createNewGame(GameDefinition gameDefinition) {
        Game game = new Game();
        game.setGameDefiniton(gameDefinition);
        GameDefinitionHelper.getRandomQuestions(gameDefinition);
        return game;
    }

    public static int getHowManyAnswerByLevel(int level) {
        switch (level) {
            case 0:
                return 4;
            case 1:
                return 8;
            case 2:
                return 1;
        }
        return 0;
    }

}
