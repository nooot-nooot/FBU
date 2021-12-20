/*
   As a decoder for the Central Untelligence Agency (CUA), it’s your job to receive and translate messages from other branches.
   Of course, your job would be easy if it wasn’t for the fact that your arch rival, United Terrorists Incorporated (UTI), keep trying to slip messages by you so that they may undermine your operations.
   Your job is to figure out which messages are fake and which are real.

   Each message will begin with a number that will directly relate to the number of words in message.
   Somewhere in the message, just once, the name of a color will appear.
   This color will tell you how the number relates to the words.

   If the color is green, the message is good regardless of the number.
   If the color is red, the number at the beginning of the message must match the number of words exactly.
   If the color is yellow, the number at the beginning of the message must be greater than the number of words.
   If the color is blue, the number at the beginning of the message must be less than the number of words.
   If more than one color appears (even if one is green) in the message, the message should be considered fake.

   You will analyze the message by first extracting the number, and then counting the number of words in the message.
   Each word is separated by spaces.

*/
class Main
{
    public static void main(String[] args)
    {
        System.out.println(Decoder.decodeMessage("22Agent Green is in position."));
        System.out.println(Decoder.decodeMessage("3The blue dog is on the catwalk."));
        System.out.println(Decoder.decodeMessage("10Jackson, wearing a yellow tuxedo, is late to the party."));
        System.out.println(Decoder.decodeMessage("17Agent 99 will be waiting in a red sedan on the drive leading to the blue lagoon."));
        System.out.println(Decoder.decodeMessage("9The yellow jacket doesn't fit."));
        System.out.println(Decoder.decodeMessage("4Red alert! Red alert!"));
        System.out.println(Decoder.decodeMessage("6Roses are red, violets are deadly."));
    }
}
