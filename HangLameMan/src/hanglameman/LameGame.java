/**
 * Game logic class for the lamest hangman game I've ever conceived
 * @author Matthew Casiro
 * Created: March 15 2016
 */
package hanglameman;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Initialize a game object to control logic for the hangman game
 */
public class LameGame {
    private Scanner scan;
    private LameBoard board;
    char[] guessed, progress;
    private String[] dict;
    private String word, input;
    private int wins, losses, guesses, right, wrong;
    /* Game States:
        0 - invalid/unintialized
        1 - title screen / show rules
        2 - in progress
        3 - win  (unimplemented)
        4 - loss (unimplemented)
    */
    private int state = 0;
    private boolean isOn = false;
    
    /**
     * Initialize a game object
     * @param lameBoard is the canvas object on which the game is displayed
     */
    public LameGame(LameBoard lameBoard) {
        wins = 0; losses = 0; guesses = 0; wrong = 0;
        isOn = false; state = 1;
        board = lameBoard;
        // Load word list in to dict and select a random word
        dict = getWords("../top1000words");
        word = dict[getNewWord(dict.length)];
        // Set char arrays to hold enough room for max guesses and word length
        guessed = new char[word.length() + 6];
        progress = new char[word.length()];
        scan = new Scanner(System.in);
    }
    /**
     * Build an array of strings from a file containing valid words
     * @param filePath locates the file containing the valid words
     * @return an array of strings containing all words
     */
    private String[] getWords(String fLoc) {
        int i = 0;
        List<String> strings = new ArrayList<>();
        try {
            File f = new File(fLoc);
            Scanner fscan = new Scanner(f);
            while(++i > 0) {
                if(fscan.hasNextLine()) {
                    strings.add(fscan.nextLine());
                }else{
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println("File error:\n"+e);
            strings.add("house");
            strings.add("boat");
            strings.add("hydrant");
            strings.add("shopping");
            strings.add("giggle");
            strings.add("missing");
            strings.add("monitor");
            strings.add("mouse");
            strings.add("phone");
            strings.add("laptop");
            strings.add("joystick");
            strings.add("glasses");
            strings.add("breakfast");
        }
        String[] array = new String[strings.size()];
        strings.toArray(array);
        return array;
    }
    /**
     * Select a random, bounded integer for use in array of words
     * @param bound outer limit of random number (exclusive)
     * @return random integer between 0 (inclusive) and param (exclusive)
     */
    private int getNewWord(int bound) {
        Random randNum = new Random();
        return randNum.nextInt(bound);
    }
    /**
     * Set game state boolean to notify main if game is over or not
     * @return boolean value true if game is on false if not
     */
    public boolean gameIsOn() {
        return isOn;
    }
    /**
     * Direct game each turn based on the game state
     */
    public void takeTurn() throws InterruptedException {
        switch(state) {
            case 0:
                break;
            case 1:
                startGameCheck();
                break;
            case 2:
                if(getGuess()){
                    goodGuess();
                } else {
                    // Update board to display another body part and check if game is lost
                    System.out.println("That guess was LAME.");
                    guesses++;
                    wrong++;
                    board.setWrong(wrong);
                    board.repaint();
                    if(wrong > 5) {
                        endGame(false);
                    }
                }
                break;
            default:
                isOn = false;
        }
    }
    /**
     * Set up rules for display and begin game
     */
    private void startGameCheck() {
        String rules[] = new String[10];
        rules[0] = "Welcome to HangLameMan!";
        rules[1] = "Here are some IMPORTANT rules:";
        rules[2] = "Rule 1: We don't talk about HangLameMan.";
        rules[3] = "Rule 2: If you guess wrong 6 times, you lose.";
        rules[4] = "Rule 3: All words are between 3 and 9 letters exclusive";
        rules[5] = "Rule 4: Words only contain lower-case letters a though z";
        rules[6] = "Rule 5: Don't feel bad about hanging LameMan. He's lame af.";
        rules[7] = "Would you like to play a game?";
        rules[8] = "('p' to play, 'q' to quit)";
        rules[9] = "Session wins: "+wins+"       Session Losses: "+losses;
        board.setRules(rules);
        board.repaint();
        // Ask user to start game or exit and react appropriately
        do {
            System.out.println(rules[rules.length - 2]);
            input = scan.nextLine().toLowerCase();
        } while (input.compareToIgnoreCase("p") != 0 && input.compareToIgnoreCase("q") != 0);
        if(input.charAt(0) == 'p') {
            System.out.println("lets play!");
            isOn = true;
            state = 2;
            board.setState(2);
            for(int i = 0; i < progress.length; i++) {
                progress[i] = '_';
            }
            board.setProgress(progress);
        } else {
            System.out.println("Have a lame day!");
            isOn = false;
        }
        board.repaint();
    }
    /**
     * Prompt user for a guess and validate input
     * @return true if guess is good or false if guess is bad
     */
    private boolean getGuess() {
        boolean done = false;
        System.out.println("Please enter a guess!");
        loop:
        while(!done) {
            // Get input and verify not null
            input = scan.nextLine();
            if (input.length() == 0) {
                System.out.println("Oops, don't be LAME! Please enter one character between 'a' and 'z':");
                continue loop;
            }
            // Validate only one character entered which is lower case alphabetic
            if (input.length() > 1 || input.charAt(0) < 'a' || input.charAt(0) > 'z') {
                System.out.println("Oops, don't be LAME! Please enter one character between 'a' and 'z':");
                continue loop;
            }
            // Validate guess is original (no repeats allowed)
            for(int i  = 0; i < guessed.length; i++) {
                if(guessed[i] == input.charAt(0)) {
                    System.out.println("Oops, don't be LAME! You've already guessed that letter...");
                    continue loop;
                }
            }
            break;
        }
        // Update char array and return if guess is good or bad
        guessed[guesses] = input.charAt(0);
        board.setGuess(guessed);
        return word.contains(input);
    }
    /**
     * Update word progress on good guess and check if game is won
     */
    private void goodGuess() throws InterruptedException {
        System.out.println("Good guess!");
        int i = -1;
        // Check index of guessed character in word, update progress char array,
        // and advance index to next char in string to continue
        i = word.indexOf(input, i + 1);
        do {
             progress[i] = input.charAt(0);
             right++;
             i = word.indexOf(input, i + 1);
        } while(i != -1);
        // Update guesses, inform board of progress
        guesses++;
        board.setProgress(progress);
        board.repaint();
        if(right == word.length()) {
                 endGame(true);
        }
    }
    /**
     * Display win or loss message, reset instance variables, and update game state
     * @param win is true if game was won, false if game was lost
     * @throws InterruptedException because Netbeans told me to.
     */
    private void endGame(boolean win) throws InterruptedException {
        String output = win ? "You won! great job!!" : "YOU KILLED HIM! LAME!!\nThe word was: "+word;
        System.out.println(output);
        // Delay to let user observe board before reverting to rules page
        Thread.sleep(3000);
        int garbage = win ? wins++ : losses++;
        // Reset instance variables
        guesses = 0;
        right = 0;
        wrong = 0;
        board.setWrong(wrong);
        // Grab a new random word from the list
        word = dict[getNewWord(dict.length)];
        guessed = new char[word.length() + 6];
        board.setGuess(guessed);
        progress = new char[word.length()];
        board.setProgress(progress);
        // Revert game state and repaint board
        state = 1;
        board.setState(1);
        board.repaint();
    }
}