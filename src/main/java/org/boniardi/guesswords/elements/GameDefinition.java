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
public class GameDefinition {
    private int totalQuestions=0;
    private int levelOfComplexity=0; //0 easy, 1 medium, 3 hard
    private ArrayList<Question> fullListOfQuestions = null;  

    /**
     * @return the totalQuestions
     */
    public int getTotalQuestions() {
        return totalQuestions;
    }

    /**
     * @param totalQuestions the totalQuestions to set
     */
    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    /**
     * @return the levelOfComplexity
     */
    public int getLevelOfComplexity() {
        return levelOfComplexity;
    }

    /**
     * @param levelOfComplexity the levelOfComplexity to set
     */
    public void setLevelOfComplexity(int levelOfComplexity) {
        this.levelOfComplexity = levelOfComplexity;
    }

    /**
     * @return the fullListOdQuestions
     */
    public ArrayList<Question> getFullListOfQuestions() {
        return fullListOfQuestions;
    }

    /**
     * @param fullListOdQuestions the fullListOdQuestions to set
     */
    public void setFullListOfQuestions(ArrayList<Question> fullListOdQuestions) {
        this.fullListOfQuestions = fullListOdQuestions;
    }
}
