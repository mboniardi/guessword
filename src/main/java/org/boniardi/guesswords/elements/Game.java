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
public class Game {
    private GameDefinition gameDefiniton=null;
    private int nextQuestion=0;
    private int numberOfCorrectAnswer=0;

    /**
     * @return the gameDefiniton
     */
    public GameDefinition getGameDefiniton() {
        return gameDefiniton;
    }

    /**
     * @param gameDefiniton the gameDefiniton to set
     */
    public void setGameDefiniton(GameDefinition gameDefiniton) {
        this.gameDefiniton = gameDefiniton;
    }

    /**
     * @return the nextQuestion
     */
    public int getNextQuestion() {
        return nextQuestion;
    }

    public String getNextQuestionOriginal(){
        return this.getGameDefiniton().getFullListOfQuestions().get(nextQuestion).getWordToAsk().getOriginal();
    }
    
    public String getPercCorrect(){
        double perc = getNumberOfCorrectAnswer() *100 / (getNextQuestion()+1);
        return String.format("%,.2f", perc);
    }
    
    public ArrayList<String> getNextQuestionPossibleAnswers(){
        return this.getGameDefiniton().getFullListOfQuestions().get(nextQuestion).getPossibleAnswerts();
    }
    
    public String getNextQuestionAnswersById(int id){
        return this.getGameDefiniton().getFullListOfQuestions().get(nextQuestion).getPossibleAnswerts().get(id);
    }
    
    public String getNextQuestionAnswersById(String id){
        return getNextQuestionAnswersById(Integer.parseInt(id));
    }
    
    public boolean isNextQuestionCorrectAnswer(String id){
        boolean result=false;
        if (this.getGameDefiniton().getFullListOfQuestions().get(nextQuestion).getCorrectAnswer()==Integer.parseInt(id)) result=true;
        return result;
    }
    
    public boolean isNextQuestionCorrectTextAnswer(String answer){
        boolean result=false;
        if (this.getGameDefiniton().getFullListOfQuestions().get(nextQuestion).getWordToAsk().isCorrectAnswer(answer)) result=true;
        return result;
    }
    
    public int getNextQuestionCorrectAnswerNumber(){
        return this.getGameDefiniton().getFullListOfQuestions().get(nextQuestion).getCorrectAnswer();
    }
    
    public String getNextQuestionCorrectAnswerString(){
        return this.getGameDefiniton().getFullListOfQuestions().get(nextQuestion).getWordToAsk().getAllTranslations();
    }
    
    public String getNextQuestionCorrectAnswerStringMasked(){
        return this.getGameDefiniton().getFullListOfQuestions().get(nextQuestion).getWordToAsk().getAllMaskedTranslations();
    }
    
    public boolean isTestCompeted (){
        boolean result=false;
        if (this.nextQuestion>= (this.gameDefiniton.getTotalQuestions()-1)) result=true;
        return result;
    }
    
    public void increaseNextQuestion(){
        this.nextQuestion=this.nextQuestion+1;
        if (this.nextQuestion==this.gameDefiniton.getTotalQuestions()) this.nextQuestion=this.nextQuestion-1;
    }
    
    public void increaseCorrectAnswer(){
        this.numberOfCorrectAnswer=this.numberOfCorrectAnswer+1;
    }
    /**
     * @param nextQuestion the nextQuestion to set
     */
    public void setNextQuestion(int nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    /**
     * @return the numberOfCorrectAnswer
     */
    public int getNumberOfCorrectAnswer() {
        return numberOfCorrectAnswer;
    }

    /**
     * @param numberOfCorrectAnswer the numberOfCorrectAnswer to set
     */
    public void setNumberOfCorrectAnswer(int numberOfCorrectAnswer) {
        this.numberOfCorrectAnswer = numberOfCorrectAnswer;
    }

    public int getNumberOfQuestions(){
       return this.gameDefiniton.getTotalQuestions(); 
    }
}
