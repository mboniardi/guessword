/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.boniardi.guesswords.elements;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mboniardi
 */
public class Word {

    private String original = null;
    private ArrayList<String> translations = null;

    public Word(String orig, String trans1, String trans2, String trans3, String trans4, String trans5, String trans6) {
        this.original = orig;
        this.translations = new ArrayList<>();
        if (trans1 != null) {
            this.translations.add(trans1);
        }
        if (trans2 != null) {
            this.translations.add(trans2);
        }
        if (trans3 != null) {
            this.translations.add(trans3);
        }
        if (trans4 != null) {
            this.translations.add(trans4);
        }
        if (trans5 != null) {
            this.translations.add(trans5);
        }
        if (trans6 != null) {
            this.translations.add(trans6);
        }
    }

    public Word(String orig, String trans1, String trans2, String trans3, String trans4, String trans5) {
        this(orig, trans1, trans2, trans3, trans4, trans5, null);
    }

    public Word(String orig, String trans1, String trans2, String trans3, String trans4) {
        this(orig, trans1, trans2, trans3, trans4, null, null);
    }    
    
    public Word(String orig, String trans1, String trans2, String trans3) {
        this(orig, trans1, trans2, trans3, null, null, null);
    }

    public Word(String orig, String trans1, String trans2) {
        this(orig, trans1, trans2, null, null, null, null);
    }

    public Word(String orig, String trans1) {
        this(orig, trans1, null, null, null, null, null);
    }

    public Word(Word toCopyFrom) {
        this.original = toCopyFrom.original;
        this.translations = new ArrayList<>();
        for (Iterator<String> iterator = toCopyFrom.getTranslations().iterator(); iterator.hasNext();) {
            String next = iterator.next();
            this.translations.add(next);
        }
    }

    /**
     * @return the original
     */
    public String getOriginal() {
        return original;
    }

    /**
     * @param original the original to set
     */
    public void setOriginal(String original) {
        this.original = original;
    }

    /**
     * @return the translation
     */
    public ArrayList<String> getTranslations() {
        return translations;
    }

    public String getAllTranslations() {
        String result = "";
        for (Iterator<String> iterator = translations.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            if (result.length() > 0) {
                result += ", ";
            }
            result += next;
        }
        return result;
    }

    public String getAllMaskedTranslations() {
        String result = "";
        for (Iterator<String> iterator = translations.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            if (result.length() > 0) {
                result += ", ";
            }
            result += maskString(next);
        }
        return result;
    }
    public String getFirstTranslation() {
        return this.translations.get(0);
    }

    public boolean isCorrectAnswer(String answer) {
        boolean result = false;
        for (Iterator<String> iterator = translations.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            if (next.equalsIgnoreCase(answer)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @param translation the translation to set
     */
    //public void setTranslation(String translation) {
    //    this.translation = translation;
    //}
    private String maskString(String original) {
        String result = original;
        result = result.replaceAll(".", "*");
        return result;
    }
}
