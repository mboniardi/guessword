/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.boniardi.guesswords.elements;

import java.util.ArrayList;

/**
 *
 * @author mboniardi
 */
public class Question {

    private Word wordToAsk = null;
    private ArrayList<String> possibleAnswerts = null;
    private int correctAnswerts = 0;

    /**
     * @return the wordToAsk
     */
    public Word getWordToAsk() {
        return wordToAsk;
    }

    /**
     * @param wordToAsk the wordToAsk to set
     */
    public void setWordToAsk(Word wordToAsk) {
        this.wordToAsk = wordToAsk;
    }

    /**
     * @return the possibleAnswerts
     */
    public ArrayList<String> getPossibleAnswerts() {
        return possibleAnswerts;
    }

    /**
     * @param possibleAnswerts the possibleAnswerts to set
     */
    public void setPossibleAnswerts(ArrayList<String> possibleAnswerts) {
        this.possibleAnswerts = possibleAnswerts;
    }

    public void setCorrectAnswerts(int crtAnswer) {
        this.correctAnswerts = crtAnswer;
    }

    /**
     * @return the correctAnswer
     */
    public int getCorrectAnswer() {
        return this.correctAnswerts;
    }

    /**
     * @param correctAnswer the correctAnswer to set
     */
}
