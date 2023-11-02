package com.github.zipcodewilmington;


/**
 * @author mikerly131
 * @version 1.0.0
 * @date 11/2/23 11:30 PM
 */
public class Wordguess {
    private String[] words = {"banana", "aardvark", "turtle", "picture", "gravy" };

    public Wordguess() {
        this.words = words;

    }

    public static void main (String[] args) {
        Wordguess game = new Wordguess();
        game.runGame();
    }
    public void runGame() {
        Boolean wantToPlay = true;
        while (wantToPlay) {
            String secretWord = getRandomWord();
            System.out.print(secretWord);
            wantToPlay = false;
        }
    }

    // Get a random number anywhere from 0 to length of words array.
    public int getRandomNumber(int wordArrayLength) {
        int min = 0;
        int max = wordArrayLength;
        int randomNumber = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return randomNumber;
    }

    // Get the "random" word aka the word at Array Index [randomNumber]
    public String getRandomWord() {
        String randomWord = words[getRandomNumber(words.length)];
        return randomWord;
    }





}
