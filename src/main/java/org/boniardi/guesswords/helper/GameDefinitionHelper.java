/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.boniardi.guesswords.helper;

import java.util.ArrayList;
import java.util.Random;
import org.boniardi.guesswords.elements.GameDefinition;
import org.boniardi.guesswords.elements.Question;
import org.boniardi.guesswords.elements.Word;
import static org.boniardi.guesswords.helper.QuestionHelper.setPossibleAnswer;

/**
 *
 * @author mboniardi
 */
public class GameDefinitionHelper {

    public static void getRandomQuestions(GameDefinition gameDefinition) {
        Random rand = new Random();
        ArrayList<Word> list = WordHelper.getDuplicateWordList();
        // create a temporary list for storing
        // selected element
        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i < gameDefinition.getTotalQuestions()  ; i++) {
            int randomIndex = rand.nextInt(list.size());
            Question question = new Question();
            question.setWordToAsk(list.get(randomIndex));
            QuestionHelper.setPossibleAnswer(question, gameDefinition.getLevelOfComplexity());        
            questions.add(question);
            list.remove(randomIndex);
        }
        gameDefinition.setFullListOfQuestions(questions);
    }

}
