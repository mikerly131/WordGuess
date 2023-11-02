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
        printGameStart();

        while (wantToPlay) {
            Boolean wordGuessed = false;

            while (!wordGuessed) {
                String secretWord = getRandomWord();
                char[] secretWordArray = getSecretWordArr(secretWord);


                wordGuessed = true;

            }

            wantToPlay = false;
        }
        printGameOver();
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

    //Get a character array of the randomWord
    public char[] getSecretWordArr(String theRandomWord) {
        char[] charRandomWord = theRandomWord.toCharArray();
        return charRandomWord;
    }

    public String getSecretWordObfuscated(char[] secretWordToPrint) {
        StringBuilder replaceCharacters = new StringBuilder();
        for(int i = 0; i < secretWordToPrint.length; i++) {
            replaceCharacters.append("_ ");
        }
        return replaceCharacters.toString();

    }

    // Say something when the game starts
    public String printGameStart() {
        return "Welcome to Thunderdome!! \nTime to guess the word or be stuck in bad spandex forever. \n";
    }

    // Say something when the game is over
    public String printGameOver() {
        return "You have ended the game. Good bye.";
    }





}
