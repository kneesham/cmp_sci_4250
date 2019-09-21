/****************************************
Name: Ted Nesham
Date: 09/20/2019
Class: Comp-Sci4250
*****************************************/

public class Main {

    static String toTest = "( number * number ) = numSquared"; // The Expression to be tested.

    static int indexstr = 0;
    static final int EOF = -1; // null terminator.
    static final int INTEGER_LIT = 10;
    static final int ID = 11;
    static final int ASSIGN_OP = 20;
    static final int ADD_OP = 21;
    static final int SUB_OP = 22;
    static final int MULT_OP = 23;
    static final int DIVISION_OP = 24;
    static final int LEFT_PAREN = 25;
    static final int RIGHT_PAREN = 26;
    static int lexLen = 0;
    static int nextToken = 1;
    static int charClass;
    static char lexeme[] = new char[100];
    static char nextChar = '0';
    // character Classes
    static final int LETTER = 0;
    static final int DIGIT = 1;
    static final int UNKNOWN = 99;

    static int lookup(char c){

        switch (c) {

            case '(': {
                addChar();
                nextToken = LEFT_PAREN;
                break;
            }

            case ')':{
                addChar();
                nextToken = RIGHT_PAREN;
                break;
            }

            case '+':{
                addChar();
                nextToken = ADD_OP;
                break;
            }
            case '-': {
                addChar();
                nextToken = SUB_OP;
                break;
            }
            case '/': {
                addChar();
                nextToken = DIVISION_OP;
                break;
            }

            case '*': {
                addChar();
                nextToken = MULT_OP;
                break;
            }
            case '=': {
                addChar();
                nextToken = ASSIGN_OP;
                break;
            }

            default: {
                addChar();
                nextToken = EOF;
            }
        }

        return nextToken;
    }

    public static void addChar(){

        if (lexLen <= 98) {
            lexeme[lexLen] = nextChar;
            lexLen += 1;
        }
        else{
            System.out.println("Error: lexeme is too long.");
        }
    }

    public static void getChar(){

        nextChar = toTest.charAt(indexstr);
        indexstr++;

        if (nextChar != EOF) {

            if (Character.isAlphabetic(nextChar)) {
                charClass = LETTER;
            } else if (Character.isDigit(nextChar)) {
                charClass = DIGIT;
            } else {
                charClass = UNKNOWN;
            }
        }
        if(indexstr == toTest.length()) {
            addChar();
            charClass = EOF;
        }

    }


    public static int lex(){
        /// lex - a simple lexical analyzer for arithmetic expressions
        lexLen = 0;

         switch (charClass){

             case LETTER: {
                 addChar();
                 getChar();

                 while (charClass == LETTER || charClass == DIGIT) {
                     addChar();
                     getChar();
                 }
                 nextToken = ID;
                 break;
             }
             case DIGIT: {
                 addChar();
                 getChar();

                 while (charClass == DIGIT){
                     addChar();
                     getChar();
                 }
                 nextToken = INTEGER_LIT;
                 break;
             }

             case UNKNOWN: {
                 nextToken = lookup(nextChar);
                 getChar();
                 break;
             }
             case EOF: {
                 nextToken = EOF;
                 lexeme[0] = 'E';
                 lexeme[1] = 'O';
                 lexeme[2] = 'F';
                 lexeme[4] = '\0';
                 break;
             }
         }

         int i = 0;
         System.out.print("The Next Token is: " + nextToken + " Next Lexeme is: ");

         while (lexeme[i] != 0 ) {
             System.out.print(lexeme[i]);
            i++;
         }

         System.out.println("");
         lexeme = new char[100];

        return nextToken;
    }

    public static void main(String[] args) {

        if (toTest == null || toTest.length() == 0 ){
            System.out.println("ERROR: NO STRING PROVIDED.");
        }

        else {
            System.out.printf("The String to be checked is: %s\n", toTest);
            toTest = toTest.replaceAll(" ", ""); // replace any white space to simplify the program.
            getChar();

            while(nextToken != EOF) {
                nextToken = lex();
            }
        }
    }
}
