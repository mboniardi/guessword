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
public class AllElements {

    private static ArrayList<Word> innerList = new ArrayList<>();

    /**
     * @return the innerList
     */
    static public ArrayList<Word> getInnerList() {
        return innerList;
    }
    

    public static boolean isInitailized() {
        boolean result = true;
        if (innerList.isEmpty()) {
            result = false;
        }
        return result;
    }
    
    public static void addElement(String original, String translation1, String translation2, String transaltion3, String transaltion4, String transaltion5, String transaltion6 ){
        innerList.add(new Word(original, translation1, translation2, transaltion3, transaltion4, transaltion5, transaltion6));
    }
    
    public static void addElement(String original, String translation1, String translation2, String transaltion3, String transaltion4, String transaltion5 ){
        innerList.add(new Word(original, translation1, translation2, transaltion3, transaltion4, transaltion5));
    }
    public static void addElement(String original, String translation1, String translation2, String transaltion3, String transaltion4){
        innerList.add(new Word(original, translation1, translation2, transaltion3, transaltion4));
    }
    public static void addElement(String original, String translation1, String translation2, String transaltion3 ){
        innerList.add(new Word(original, translation1, translation2, transaltion3));
    }
    public static void addElement(String original, String translation1, String translation2 ){
        innerList.add(new Word(original, translation1, translation2));
    }
    public static void addElement(String original, String translation1 ){
        innerList.add(new Word(original, translation1));
    }
}
