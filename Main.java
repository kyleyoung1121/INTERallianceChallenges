/*
* 4/27/2020   Kyle Young
*
* Hello! Welcome to my mega program! 
* In  this file, you can find my solutions to both 
* the leap year program, as well as the morse code
* program. I added a bit of creative freedom for
* your enjoyment. Enjoy!
*
* As I am only able to submit one file, here are
* the links to my repl.it for the individual
* projects, attempted in as few lines as possible.
* https://repl.it/@KyleYoung1/MorseCode
* https://repl.it/@KyleYoung1/LeapYears
*
* Finally, if you would like to view this code in 
* repl.it (instead of this gross file format), go to
* https://repl.it/@KyleYoung1/INTERalliance-Competition-Mega 
*/
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    //intro text
    System.out.println("\nHi!\nWelcome to my coding project.\n\nIf you would like to print leap years, type 1.\nIf you would like to convert text to morse code, type 2.\n");
    //get ready for user input
    Scanner scan = new Scanner(System.in);
    //ask intention
    int inputInt = scan.nextInt();
    String inputString = "";

    //Code for leap years
    if(inputInt == 1)
    {
      System.out.println("\nEnter '1' if you would like 20 leap years printed.\nEnter '2' if you would like to enter a custom number of leap years. (up to 100)\n");
      //here, I'm asking if the user wants to do 20 leap years or a custom amount. I can just adjust what I'm feeding the method accordingly.
      inputInt = scan.nextInt();
      if(inputInt == 1)
      {
        countLeapYears(20);
      }
      else if(inputInt == 2)
      {
        System.out.println("\nGreat! How many leap years do you want?\n");
        int numOfYears = scan.nextInt();
        if(numOfYears > 0 && numOfYears <= 100)
        {
          countLeapYears(numOfYears);
        }
        else
        {
          //If the input was not within a reasonable range, end program.
          System.out.println("Sorry, that was a non-valid input. Exiting code....");
        }
      }
    }

    //code for the morse code. Wait. Do you guys even read this stuff?
    else if(inputInt == 2)
    {
      //Setting up a cool variable
      String output = "";
      //Defining alphabet and morse code.
      String[] morse = 
        {".- ", "-... ", "-.-. ", "-.. ", ". ", "..-. ", "--. ", ".... ", ".. ", 
        ".--- ", "-.- ", ".-.. ", "-- ", "-. ", "--- ", ".--. ", "--.- ", ".-. ",
        "... ", "- ", "..- ", "...- ", ".-- ", "-..- ", "-.-- ", "--.. "};
      String[] english = 
        { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
        "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", 
        "y", "z"};
      
      //Ask the user for direction of conversion
      System.out.println("\nAwesome!\nType '1' for english -> morse\nType '2' for morse -> english\n");
      inputInt = scan.nextInt();
      
      if(inputInt == 2)
      {
        System.out.println("\nTyping in morse is very touch and go.\nUse one space in between letters and three between words.\nPeriods ( . ) are used as dits and\nthe dash mark ( - ) is used for dahs.\nFor a good example, try\n'.... . .-.. .-.. ---   .-- --- .-. .-.. -..'");
      }

      System.out.println("\nCool.\nWhat is your message?\n");
      //This first next line is to eat up the \n from the next int command. Was stuck here for a while.
      inputString = scan.nextLine();
      inputString = scan.nextLine();
      inputString = inputString.toLowerCase();
      
      //english -> morse
      if(inputInt == 1)
      {
        for(int a=0; a<=25; a++)
        {
          //replacing each letter with morse text.
          inputString = inputString.replace(english[a], morse[a]);
        }
      }
      
      //morse -> english
      else if(inputInt == 2)
      {
        //had to separate morse into words and then into letters.
        inputString.trim();
        String[] words = inputString.split("   ");
        for(String word: words)
        {
          for(String letter: word.split(" "))
          {
            for(int i = 0; i < morse.length; i++)
            {
              //if the letter has a match, add to output string.
              //I had to use trim here to deal with line breaks.
              if(letter.trim().equals(morse[i].trim()))
              {
                output += english[i];
              }
            }
          }
          output += " ";
        }
        inputString = output;
      }
      //Either direction of conversion uses the next line for output.
      System.out.println("\n\nOutput: " + inputString + "\n\n");
    }
    //close the input, as all good coders should. c:
    scan.close();
  }

  //methods

  //This method prints out leap years for any given number of them.
  public static void countLeapYears(int num)
  {
    System.out.println("\nPrinting...\n");
    int year = 2024;
    int skippedYears = 0;
    //iterate until target year is met (account for invalid leap years too)
    while(year < 2024 + ((num + skippedYears) * 4))
    {
      //leap years are not valid if divisible by 100...
      if(year % 100 == 0)
      {
        //unless also divisible by 400.
        if(year % 400 == 0)
        {
          System.out.println(year);
        }
        else
        {
          //ensures the correct number of years are printed.
          skippedYears++;
        }
      }
      else
      {
        System.out.println(year);
      }
      year += 4;
    }
  }
}