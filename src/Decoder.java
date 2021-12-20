/*
   The Decoder class is a class built entirely with static methods.
   It has no class member variables and an object of type Decoder cannot be instantiated.
   It's purpose is to decode CUA messages.
   
   The Decoder class has only one public method (decodeMessage()).
   All of the other methods in the class are private because all of the other methods are utilities that are used by decodeMessage().
   Those utility methods are not meant to be used by an external client program.
*/

public class Decoder
{
    private Decoder(){}

   /*
      This method is responsible for breaking up and analyzing the message.
      Based on its analysis, it will return the message or it will return "Incorrect Message Format. UTI Incursion.".
      
      In order to analyze the message, it needs to follow these steps:
      
      Determine the color referenced in the message.
      Isolate the number at the beginning of the message.
      Determine how many words are in the message. Words are separated by spaces.
      Assess the relationship between the color, the number at the beginning of the message, and the number of words in the message.
      Return the message or the warning.
      
      @param msg the message
      @return the message if it's legitimate or the warning if it isn't.  
      
      WRITE THIS METHOD    
   */

    public static String decodeMessage(String msg)
    {
        /*
        System.out.println(getColor(msg));
        System.out.println(separateNumber(msg));
        System.out.println(getNumWords(msg));

         */
        if (getColor(msg).equalsIgnoreCase("Green")){
            return (msg);
        }
        else if (getColor(msg).equalsIgnoreCase("Red")){
            if (getNumWords(msg) == Integer.parseInt(separateNumber(msg))){
                return (msg);
            }

            else {
                return ("Incorrect Message Format. UTI Incursion.");
            }
        }

        else if (getColor(msg).equalsIgnoreCase("Yellow")){
            if (getNumWords(msg) < Integer.parseInt(separateNumber(msg))){
                return (msg);
            }
            else {
                return ("Incorrect Message Format. UTI Incursion.");
            }
        }
        else if (getColor(msg).equalsIgnoreCase("Blue")){
            if (getNumWords(msg) > Integer.parseInt(separateNumber(msg))){
                return (msg);
            }
            else {
                return ("Incorrect Message Format. UTI Incursion.");
            }
        }
        return ("Incorrect Message Format. UTI Incursion.");




    }

    /*
       This method is responsible for finding the color referenced in the message and returning it.
       Regardless of how the color is written in the message (capital or lowercase), the color must be returned in capital letters.
       GREEN, RED, BLUE, YELLOW, or NONE if there is no color or more than one color referenced.

       @param msg the message
       @return the color referenced or NONE

       WRITE THIS METHOD.
    */

    private static String getColor(String msg)
    {
        int numColors = 0;
        String whatColor;
        //String[] colors = {"Green","green", "Red", "red", "Blue", "blue", "Yellow", "yellow"};
        String[] colors = {"Green", "red","Blue", "Yellow"};
        //need to split both here and in seperate num, I guess they're different but I feel like you can just do one split array that can work for both functions
        //removes punctuation and splits it up into individual words, just for the "red," in the last message
        String[] words = msg.replaceAll("\\p{Punct}", "").split(" ");
        whatColor = "NONE";
        for (String word : words) {
            for (String color : colors) {
                if (word.equalsIgnoreCase(color)) {
                    whatColor = color;
                    numColors++;
                }
            }
        }
        if (numColors > 1) {
            return "NONE";
        }
        return whatColor;





    }

    /*
       This method is responsible for pulling the number from the beginning of the message and returning it.

       @param msg the message
       @return the number at the beginning of the message

       WRITE THIS METHOD
    */
    private static String separateNumber(String msg)
    {
        //checks if behind is an int and if in front is a string
        //only did this format because in all of the messages, its num then string
        String[] sepNum = msg.split("(?=\\D)(?<=\\d)");
        return sepNum[0];

    }

    /*
       This message determines the number of words in the message.
       Words are separated by a single space.

       @param msg the message
       @return the number of words in the message

       WRITE THIS METHOD
    */
    private static int getNumWords(String msg)
    {
        int num = 0;
        String[] words = msg.split(" ");
        //is there no way of checking if its an int besides this? dont like that I need to num--, then num++ to zero out when its not a num
        for (String thing : words) {

            num++;


        }
        return num;

    }
}