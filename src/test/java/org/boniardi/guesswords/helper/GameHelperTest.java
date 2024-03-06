/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.boniardi.guesswords.helper;

import org.boniardi.guesswords.elements.Game;
import org.boniardi.guesswords.elements.GameDefinition;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mboniardi
 */
public class GameHelperTest {
    
    public GameHelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createNewGame method, of class GameHelper.
     */
    @Test
    public void testCreateNewGame_numberOfQuestions() {
        System.out.println("createNewGame");
        int totQuestion = 5;
        int level = 1;
        Game result = GameHelper.createNewGame(totQuestion, level);
        assertEquals(totQuestion, result.getGameDefiniton().getFullListOfQuestions().size());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of createNewGame method, of class GameHelper.
     */
    @Test
    public void testCreateNewGame_numberOfAnswers() {
        System.out.println("createNewGame");
        int totQuestion = 5;
        int level = 1;
        Game result = GameHelper.createNewGame(totQuestion, level);
        assertEquals(GameHelper.getHowManyAnswerByLevel(level), result.getGameDefiniton().getFullListOfQuestions().get(0).getPossibleAnswerts().size());
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of getHowManyAnswerByLevel method, of class GameHelper.
     */
    @Test
    public void testGetHowManyAnswerByLevel() {
        System.out.println("getHowManyAnswerByLevel");
        int level = 1;
        int expResult = 8;
        int result = GameHelper.getHowManyAnswerByLevel(level);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
