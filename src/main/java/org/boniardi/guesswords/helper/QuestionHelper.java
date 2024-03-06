/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.boniardi.guesswords.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import org.boniardi.guesswords.elements.Question;

/**
 *
 * @author mboniardi
 */
public class QuestionHelper {

    static void setPossibleAnswer(Question question, int level) {
        ArrayList<String> answers = getRandomAnswers(question.getWordToAsk().getFirstTranslation(), GameHelper.getHowManyAnswerByLevel(level));
        Collections.shuffle(answers);
        question.setPossibleAnswerts(answers);
        // set correct answer
        int myIndex = 0;
        for (String answer : answers) {
            if (answer.equals(question.getWordToAsk().getFirstTranslation())) {
                question.setCorrectAnswerts(myIndex);
            }
            myIndex += 1;
        }
    }

    static ArrayList<String> getRandomAnswers(String correct, int totalItems) {
        Random rand = new Random();
        ArrayList<String> list = WordHelper.getDuplicateTranslationList();
        ArrayList<String> newList = new ArrayList<>();
        newList.add(correct);
        for (int i = 0; i < list.size(); i++) {
            if (correct.equals(list.get(i))) {
                list.remove(i);
            }
        }
        if (totalItems > 1) {
            for (int i = 0; i < totalItems - 1; i++) {
                int randomIndex = rand.nextInt(list.size());
                newList.add(list.get(randomIndex));
                list.remove(randomIndex);
            }
        }
        return newList;
    }

}
