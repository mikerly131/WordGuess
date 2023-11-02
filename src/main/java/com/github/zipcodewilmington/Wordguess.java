package com.github.zipcodewilmington;


/**
 * @author mikerly131
 * @version 1.0.0
 * @date 11/2/23 11:30 PM
 */
public class Wordguess {
    private String[] words = {"banana", "aardvark", "turtle", "picture", "gravy" };

    // Other instance variables?...i suspect something horribly wrong is about to happen
    private int guessesLeft = 0;
    private String secretWord = "";

    private char[] secretWordArr;
    private String guessArrStr = "";  // array? why no string friend? my brain tired

    private char[] guessArr;

    // But should the arrays be here?

    public Wordguess() {
        this.words = words;
        this.secretWord = secretWord;
        this.guessArrStr = guessArrStr;
        this.guessesLeft = guessesLeft;
        this.secretWordArr = secretWordArr;
        this.guessArr = guessArr;

    }

    public static void main (String[] args) {
        Wordguess game = new Wordguess();
        game.runGame();
    }
    public void runGame() {
        Boolean wantToPlay = true;
        printGameStart();

        while (wantToPlay) {

            // Start a fresh game: wordGuessed is false now
            Boolean wordGuessed = false;

            // Get a new secret word
            this.secretWord = getRandomWord();

            // Setup an array of secret word characters to compare to guessed characters
            this.secretWordArr = getSecretWordArr(this.secretWord);

            // Setup an array of guess characters equal to length of secret word
            this.guessArr = getGuessArrInit(this.secretWordArr);

            this.guessArrStr = this.guessArr.toString();

            while (!wordGuessed) {

                // Where and How to do these things...
                // Print guesses left
                // print out guessArray
                // declare guesses left = guess or secret word or secret word array length;
                // Prompt player to enter a character {restrict input to char}
                // check if character in secret word array
                // everywhere it appears replace _ with character in guess array
                // check if all characters guessed
                // check if any guesses left
                // update guesses left


                wordGuessed = true;

            }
            // prompt to play again
            wantToPlay = false;
        }
        // quit
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

    public char[] getGuessArrInit(char[] secretWordToPrint) {
        StringBuilder replaceCharacters = new StringBuilder();
        for(int i = 0; i < secretWordToPrint.length; i++) {
            replaceCharacters.append("_");
            if (i < secretWordToPrint.length - 1) {
                replaceCharacters.append(" ");
            }
        }
        String swap = replaceCharacters.toString();
        char[] replaceCharactersArr = swap.toCharArray();
        return replaceCharactersArr;

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
