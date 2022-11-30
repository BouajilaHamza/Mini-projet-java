//Joseph Mulray Final Project Word Guessing Game May 1 2015
import javax.swing.JOptionPane;		//importing jOptionPane, util package, and throws IO Exception
import java.util.*;
import java.io.*;

public class Procedure
{
	//Declaring feilds
	String [] array1;
	String [] array;
	String word1;
	String word2 ;


    public Procedure() throws IOException	//CONSTRUCTOR
    {
    	array = new String[10];		//creating a new string array
    	array1 = new String[10];
		getFile();					//calling the getFile and random methods
    	random();

	}


	public static void message()	//WELCOME MESSAGE
	{
		JOptionPane.showMessageDialog(null, "Welcome to the Word Guessing Game!\nYou will choose a category of words and try to\n guess the letters in the word. Good Luck!");
	}


	public void getFile() throws IOException	//GETS USER INPUT ON WHICH FILE HE/SHE WANTS TO PLAY
	{
		String txtfile;			//declaring feilds
		String category;

	category = JOptionPane.showInputDialog("Please Enter a number of the category you wish to guess \n 1.Fruits\n 2.Animals\n 3.Flowers ");

		if(category==null)		//testing to see if user hit cancel button
		{
		JOptionPane.showMessageDialog(null,"Cancel buttton clicked\n Program Terminated!\n Good-bye!");
		System.exit(0);
		}

		while((category.equals("1")==false) && (category.equals("2")==false) && (category.equals("3")==false)) //testing whether the user entered in a
		{																										//valid number of not has to be between
			JOptionPane.showMessageDialog(null,"Invalid Answer");												// 1, 2, and 3.
			category = JOptionPane.showInputDialog("Please Enter a number of the category you wish to guess \n 1.Fruits\n 2.Animals\n 3.Flowers ");


			if(category==null)			//testing to see if user hit cancel button
			{
			JOptionPane.showMessageDialog(null,"Cancel buttton clicked\n Program Terminated!\n Good-bye!");
			System.exit(0);
			}

		}


					//taking users input and testing which file to be used
	switch(category)
		{

		case "1": txtfile="Fruits.txt";
			break;
		case "2":txtfile = "Animals.txt";
			break;
		default:txtfile = "Flowers.txt";
			break;
		}

		File file = new File(txtfile);				//file object
		try (Scanner inputFile = new Scanner(file)) {
			for(int x=0;x<array.length;x++)
			{
				array[x]=inputFile.nextLine();	//populating array with random words from file.
			}
		}
		try (Scanner inputFile = new Scanner(file)) {
			for(int y=0;y<array1.length;y++)
			{
				array1[y]=inputFile.nextLine();	//populating array with random words from file.
			}
		}



	}


	public void random()
	{
		Random random = new Random();		//creating random word object
		int randomNum =random.nextInt(array.length); //getting a random number based on length of array
		int randomNum1 =random.nextInt(array1.length);
		word1 = array[randomNum];
		word2 = array1[randomNum1]; //getting a random word from array and storing in varaible word

	}


	public int getLength()			//gets length of word and returns and integer
	{
		// return word1.length() + word2.length();
		return 12;
	}


	public String getWord()			//get the word and returns a string
	{
		return word1 ;
	}

	public String getWords()			//get the word and returns a string
	{
		return word1 + word2 ;
	}}