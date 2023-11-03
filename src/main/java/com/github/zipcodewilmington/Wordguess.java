package com.github.zipcodewilmington;


import java.util.Scanner;

/**
 * @author mikerly131  (are we supposed to put our names here?)
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
        System.out.print(printGameStart());

        while (wantToPlay) {

            // Start a fresh game: wordGuessed is false now
            Boolean wordGuessed = false;

            // Get a new secret word
            this.secretWord = getRandomWord();

            // Setup an array of secret word characters to compare to guessed characters
            this.secretWordArr = getSecretWordArr(secretWord);

            // Set guesses left = length of secret word.  A rule in our game
            this.guessesLeft = setGuessesLeft(secretWord);

            // Setup an array of guess characters equal to length of secret word
            this.guessArr = getGuessArrInit(secretWordArr);

            // Setup a string fo reasy printing out of the array
            this.guessArrStr = getGuessArrStr(guessArr);

            while (!wordGuessed) {

                // Where and How to do these things...
                //System.out.print(this.secretWord);
                //System.out.print(this.secretWordArr);
                // Print guesses left
                System.out.println(getGuessesLeftMessage());

                // print out guessArray
                System.out.println(this.guessArrStr);

                // Prompt player to enter a character {restrict input to char}
                char userGuess = getUserGuess();
                this.guessArr = getGuessArrUpdate(secretWordArr, userGuess);

                // update guesses left = guess or secret word or secret word array length;
                // check if all characters guessed
                // check if any guesses left
                // update guesses left


                wordGuessed = true;

            }
            // prompt to play again
            wantToPlay = false;
        }
        // quit
        System.out.print(printGameOver());
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

    // Set the guesses left
    public int setGuessesLeft (String secretWord) {
        int guessLeft = secretWord.length();
        return guessLeft;
    }

    // Get the guesses left
    public int getGuessesLeft () {
        return guessesLeft;
    }

    // Get the next remaining guesses to print string
    public String getGuessesLeftMessage() {
        return ("You have " + getGuessesLeft() + " guesses left.");
    }

    public char getUserGuess() {
        Scanner sc = new Scanner(System.in);
        String userGuess = sc.nextLine();
        char charGuess = userGuess.charAt(0);
        return charGuess;
    }




    // Get the initial _ replaced letters and space added guess array
    // Refactor:  there has got to be a better way to do this, i will learn when i have time
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

    // Check if the users guessed character is in the secret word



    // update the guessArr
    public char[] getGuessArrUpdate(char[] secretWordToPrint, char userGuess) {

        StringBuilder replaceCharacters = new StringBuilder();

        // loop through secret word characters, see if letter in word.
        for (int i = 0; i < secretWordToPrint.length; i++) {
            //
            if (userGuess == secretWordToPrint[i]) {
                replaceCharacters.append(userGuess);
                if (i < secretWordToPrint.length - 1) {
                    replaceCharacters.append(" ");
                }
            } else {
                replaceCharacters.append("_");
                if (i < secretWordToPrint.length - 1) {
                    replaceCharacters.append(" ");
                }

            }

        }
        String swap = replaceCharacters.toString();
        char[] replaceCharactersArr = swap.toCharArray();
        return replaceCharactersArr;
    }


    //
    public String getGuessArrStr(char[] charArray) {
        String guessString = String.valueOf(charArray);
        return guessString;
    }

    // Say something when the game starts
    public String printGameStart() {
        return "Welcome to Thunderdome!! \nTime to guess the word or be stuck in bad spandex forever. \nGuess one letter at a time! \n";
    }

    // Say something when the game is over
    public String printGameOver() {
        return "You have ended the game. Good bye.";
    }





}
