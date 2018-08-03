/* File: Game_of_Nim.java 
 * Description: Program that uses an Expert AI and beginner AI that recreates the Game of Nim 
 * Date: November 6, 2017  
 * Bonnie Lu, Sharon He, Andy Zhu 
 */  

import java.util.Scanner; //Importing scanner utility

import java.util.Random; //Importing random utility


public class GameOfNim 
{
  
  public static void main(String[] args) 
  {
    // declaring variables:
    Scanner scan = new Scanner(System.in); //Naming scanner
    
    Random rand = new Random (); //Declaring random utility
    
    String level, order = "1"; //Yes, no answer responses
    
    int totalStone = rand.nextInt(16) + 15; //Randomize total numbers from 15 to 30
    
    int comStone = 0, userStone = 0; //Computer amount of stone
    
    String sUserStone; //User amount of stones
    
    int i; //Counter variable
    
    boolean user = false; //When user is equal to true, the last turn was the user's. When user is equal to false, the last turn was the computer's
    
    //Instructions:
    
    System.out.println("Welcome to the Game of Nim! The user will be playing against a computer.");
    System.out.println(); //Spacing
    System.out.println("There will be a certain number of stones and the objective of the game is to NOT take the last stone." ); 
    System.out.println("You can choose to take either 1, 2, or 3 stones at a time.");
    
    do
    {
      System.out.println("Please select a difficulty level: Enter 1. Beginner or 2. Expert."); //Select a difficulty
      level = scan.nextLine(); //Scan and store in variable
      if (!"1".equals(level) && !"2".equals(level)) //Checks the vailidity of user input 
      {
        System.out.println("Please choose valid difficulty level");
        System.out.println(); // space indent
      }
    } while (!"1".equals(level) && !"2".equals(level)); //If user input is not valid, loops back and asks again 
    
    do
    {
      System.out.println("Would you like to go first or go second? Enter 1. Going first or 2. Going second." ); //Select order
      order = scan.next(); //Scan and store in variable
      if (!"1".equals(order) && !"2".equals(order))
      {
        System.out.print("Please choose valid order number");
        System.out.println();
      }
    } while (!"1".equals(order) && !"2".equals(order));
    
    System.out.println("There is a total of " + totalStone + " stones."); //Outputs the toal amount of stones 
    
    //Start the game!
    
    if (level.equals ("1")) //Beginnner AI 
    {
      if (order.equals ("2")) //Computer goes first 
      {
        comStone = rand.nextInt(3) + 1; //Randomize from 1 to 3 stones
        totalStone = totalStone - comStone; //New total of totalStone
        System.out.println ("The computer has taken " + comStone + " stones. There are now " + totalStone + " stones. It is now your turn.");  //Outputs the amount of stones that the computer has taken 
        user = false; //Set user to false
      }
      do //If user wants to go first, it skips directly to this part. The user takes the stone.
      {
        do 
        {
          System.out.println ("How many stones would you like to take? Take 1 to 3 stones of your choosing."); //Prompts user to take stones
          sUserStone = scan.next(); //User enters stone number
          
          if (!"1".equals(sUserStone) && (!"2".equals(sUserStone) && (!"3".equals(sUserStone)))) //Invalid statements, when user enters a number/letter is something other than a 1,2,3
          { 
            System.out.println ("Invalid amount of stones selected. Please select a valid amount of stones."); 
          }
        } while (!"1".equals(sUserStone) && (!"2".equals(sUserStone) && (!"3".equals(sUserStone))));
        
        userStone = Integer.parseInt(sUserStone);
        
        user = true; //User is set to true. The computer had the last turn 
        totalStone = totalStone - userStone; //New totalStone
        System.out.println ("The user has taken " + userStone + " stones. There are now " + totalStone + " stones. It is now the computer's turn"); //Outputs the move, and total stones 
        if (totalStone >= 3)
        {
          comStone = rand.nextInt(3) + 1; //Randomized comStone number
          totalStone = totalStone - comStone; //Change the value of totalStone
          System.out.println("The computer has taken " + comStone + " stones. There are now " + totalStone + " stones. It is now your turn."); //Outputd the amount of stones taken and the total stones left
          user = false; 
          if (totalStone == 0)
          {
            user = false; //User is set to false, the last turn was the computer's
          }
        }
      } while (totalStone >= 3); 
      
      if (totalStone == 2) //TotalStone is equal to 2
      {
        if (user == false) //User's turn 
        {
          do
          { 
            System.out.println("How many stones would you like to take? Take 1 or 2 stones of your choosing.");
            sUserStone = scan.next();
            if (!"1".equals(sUserStone) && (!"2".equals(sUserStone)))
            {
              System.out.println("Invalid amount of stones selected. Please select a valid amount of stones.");
            }
          } while (!"1".equals(sUserStone) && !"2".equals(sUserStone)); //When there are 2 stones in total, user is only able to select 1 or 2
          
          userStone = Integer.parseInt(sUserStone); //Takes the string value and converts it to an integer
          if (userStone == 2)
          {
            user = true;
          }
          else 
          {
            totalStone = totalStone - userStone; //The totalStones left
            System.out.println("You have taken " + userStone + " stones. There are " + totalStone + " stones left. It is now the computer's turn.");
            user = false;
          }
        }
        else //Computer's turn 
        {
          comStone = rand.nextInt(2)+1;
          totalStone = totalStone - comStone; 
          System.out.println("The computer has taken " + comStone + " stones. There are " + totalStone + " left.");
          if (totalStone == 1) //Determines who wins based off of the number of stones left after this 
          {
            user = true; //If there is one stone left, then the user automatically loses
          }
          else 
          {
            user = false; //Computer loses
          }
        }
        
      }
      else if (totalStone == 1) //TotalStone is 1, automatically able to tell who loses 
      {
        if (user == false)
        {
          user = true;
        }
        else
        {
          user = false;
        }
      }  
    }
    
    else if (level.equals ("2")) // Expert AI:
    {
      if (order.equals ("2")) //Computer goes first 
      {
        comStone = rand.nextInt(3) + 1; //Randomize from 1 to 3 stones
        totalStone = totalStone - comStone; // new total of totalStone
        System.out.println ("The computer has taken " + comStone + " stones. There are now " + totalStone + " stones. It is now your turn.");  //Output 
        user = false; // set user to false
      }
      do
      {
        do 
        {
          System.out.println ("How many stones would you like to take? Take 1 to 3 stones of your choosing."); //Prompts user to take stones
          sUserStone = scan.next(); //User enters stone number
          
          if (!"1".equals(sUserStone) && (!"2".equals(sUserStone) && (!"3".equals(sUserStone))))
          { 
            System.out.println ("Invalid amount of stones selected. Please select a valid amount of stones."); //Invalid statements
          }
        } while (!"1".equals(sUserStone) && (!"2".equals(sUserStone) && (!"3".equals(sUserStone))));
        userStone = Integer.parseInt(sUserStone);
        
        user = true; // user is set to true
        totalStone = totalStone - userStone; // new totalStone
        System.out.println ("The user has taken " + userStone + " stones. There are now " + totalStone + " stones. It is now the computer's turn"); //Output 
        
        if (totalStone > 4)
        {
          
          //Computer's turn:
          for (i = 1; i <= 3; i++)
          {
            if ((totalStone - i) % 4 == 1) //Having to take from 1,5,9,13... means that you will lose
            {
              comStone = i; // set comStone to value that works for the formula
            }
          }
          if (comStone == 0)
          {
            comStone = 1; // make sure computer takes at least one stone
          }
          
          totalStone = totalStone - comStone; // change the value of totalStone
          System.out.println("The computer has taken " + comStone + " stones. There are now " + totalStone + " stones. It is now your turn."); // output
          user = false; // user is set to false
        }
      } while (totalStone > 4);
      
      if (user == true) //Computer's turn 
      {
        for (i = 1; i <=3; i++)
        {
          if (totalStone-i == 1)
          {
            user = false;
            comStone = i; // set comStone equal to i
            totalStone = totalStone - comStone; // new totalStone
            System.out.println("The computer has taken " + comStone + " stones. There are now " + totalStone + " stones. It is now your turn."); // output
          }
          //User's last turn 
          user = true; 
        }
      }
      else //User's turn. If user is false
      {
        do 
        {
          System.out.println ("How many stones would you like to take? Take 1 to 3 stones of your choosing."); //Prompts user to take stones
          sUserStone = scan.next(); //User enters stone number
          
          if (!"1".equals(sUserStone) && (!"2".equals(sUserStone) && (!"3".equals(sUserStone))))
          { 
            System.out.println ("Invalid amount of stones selected. Please select a valid amount of stones."); //Invalid statements
          }
        } while (!"1".equals(sUserStone) && (!"2".equals(sUserStone) && (!"3".equals(sUserStone))));
        
        user = true;
        userStone = Integer.parseInt(sUserStone);
        totalStone = totalStone - userStone;
        System.out.println("The user has taken " + userStone + " stones. There are now " + totalStone + " stones. It is now the computer's turn.");
        
        if (totalStone == 1)
        {
          user = false;
        }
        else
        {
          for (i = 1; i <=3; i++) //Computer's turn 
          {
            if (totalStone-i == 1)
            {
              user = true;
              comStone = i; // set comStone equal to i
              totalStone = totalStone - comStone; // new totalStone
              System.out.println("The computer has taken " + comStone + " stones. There are now " + totalStone + " stones. It is now your turn."); // output
            }   
          }
        }
      }
      
    }
    
    System.out.println(); //Space indent
    
    // Win or loss statements:
    if (user == true) // Loss
    {
      System.out.println("Sorry, you have lost to the computer. Please try playing again later."); //Outputs losing message 
    }    
    else
    {
      System.out.println("Congratulations! You have beaten the computer."); //Outputs winning message 
    }
  }
}