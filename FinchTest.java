//Brunel University, DISC, Module CS1702, 2013-14
//Dr Stephen Swift's Rather Crude Finch Testing Program
//Hopefully this works...
//This is for week zero/fresher's week/induction week to test to see if the Finch Robot works

//Import libraries needed for the program

import java.util.Random;
import javax.swing.JOptionPane;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchTest 
{
	//This value is the time for most of the tests in milliseconds, 1000 = 1 second
	//Change this value if the tests are too long or short
	final private static int testtime = 5000;
	//This is the Finch object
	private static Finch myf = null;
	//This is the starting point of the testing program
	public static void main(String args[]) 
	{
		String s = "";
		//'myf' is the name of our Finch object
		//This will used throughout the program to control your Finch and report it's status  
		myf = new Finch();
		do
		{
			//Run the menu until quit or cancel is selected
			s = FinchMenu();
			if (s == "Light Test") RunLightTest(s);
			if (s == "Tilt Test") RunTiltTest(s);
			if (s == "Tap Test") RunTapTest(s);
			if (s == "Temperature Test") RunTemperatureTest(s);
			if (s == "Obstacle Test") RunObstacleTest(s);
			if (s == "Acceleration Test") RunAccelerationTest(s);
			if (s == "Left Wheel Test") RunLeftWheelTest(s);
			if (s == "Right Wheel Test") RunRightWheelTest(s);
			if (s == "Buzzer Test") RunBuzzerTest(s);
			if (s == "Nose Test") RunNoseTest(s);
		} while (s != "Quit"); 
		System.out.println("Exiting DoesMyFinchWork...");
		myf.quit();
	}
	//This creates the Finch menu
	private static String FinchMenu()
	{
		Object[] possibilities = {"Light Test", "Tilt Test","Tap Test","Temperature Test", "Obstacle Test","Acceleration Test","Left Wheel Test","Right Wheel Test","Buzzer Test","Nose Test","Quit"};
		String s = (String)JOptionPane.showInputDialog(null,"Dr Swift's Splendid Finch Test\n++++++++++++++++++++++++\nChoose a test from:\n\n","Week Zero Laboratory",JOptionPane.PLAIN_MESSAGE, null,possibilities,"Light Test");
		if (s == null || s.length() == 0) s = "Quit";
		return(s);
	}
	//Run the light sensor test
	//Displays the left and then the right sensor output
	private static void RunLightTest(String s)
	{
		System.out.println("\n"+"Running: "+s+"\n");
		long before = System.currentTimeMillis();
		while(System.currentTimeMillis() - before < testtime)
		{
			System.out.println(myf.getLeftLightSensor() + " " + myf.getRightLightSensor());
		}
	}
	//Run the Tilt Test
	//Displays:
	//1) Is the beak down?
	//2) Is the beak up?
	//3) Is the Finch level?
	//4) Is the Finch upside down?
	//5) Is the Finch's left wing down?
	//6) Is the Finch's right wing down?
	private static void RunTiltTest(String s)
	{
		System.out.println("\n"+"Running: "+s+"\n");
		long before = System.currentTimeMillis();
		while(System.currentTimeMillis() - before < testtime)
		{
			System.out.println(myf.isBeakDown() + " " + myf.isBeakUp() + " " + myf.isFinchLevel() + " " + myf.isFinchUpsideDown() + " " + myf.isLeftWingDown() + " " + myf.isRightWingDown());
		}
	}
	//Run the tap test
	//Displays if the Finch has been tapped
	private static void RunTapTest(String s)
	{
		System.out.println("\n"+"Running: "+s+"\n");
		long before = System.currentTimeMillis();
		while(System.currentTimeMillis() - before < testtime)
		{
			System.out.println(myf.isTapped());
		}
	}
	//Run the temperature test
	//Displays the current temperature in degrees Celsius
	private static void RunTemperatureTest(String s)
	{
		System.out.println("\n"+"Running: "+s+"\n");
		long before = System.currentTimeMillis();
		while(System.currentTimeMillis() - before < testtime)
		{
			System.out.println(myf.getTemperature());
		}
	}
	//Run the obstacle sensor test
	//Displays if there is an obstacle left and right of the Finch
	private static void RunObstacleTest(String s)
	{
		System.out.println("\n"+"Running: "+s+"\n");
		long before = System.currentTimeMillis();
		while(System.currentTimeMillis() - before < testtime)
		{
			System.out.println(myf.isObstacleLeftSide() + " " + myf.isObstacleRightSide());
		}
	}
	//Run the acceleration sensor test
	//Displays is the Finch is being shaken, and then the acceleration in the X, Y and Z planes
	private static void RunAccelerationTest(String s)
	{
		System.out.println("\n"+"Running: "+s+"\n");
		long before = System.currentTimeMillis();
		while(System.currentTimeMillis() - before < testtime)
		{
			System.out.println(myf.isShaken()+ " " + myf.getXAcceleration() + " " + myf.getYAcceleration()+ " " + myf.getZAcceleration());
		}
	}
	//Run the left wheel test
	//Move the left wheel forward and backwards
	private static void RunLeftWheelTest(String s)
	{
		System.out.println("\n"+"Running: "+s+"\n");
		myf.setWheelVelocities(255,0,testtime/2);
		myf.setWheelVelocities(-255,0,testtime/2);
	}
	//Run the right wheel test
	//Move the right wheel forward and backwards
	private static void RunRightWheelTest(String s)
	{
		System.out.println("\n"+"Running: "+s+"\n");
		myf.setWheelVelocities(0,255,testtime/2);
		myf.setWheelVelocities(0,-255,testtime/2);
	}
	//Sound the buzzer for a number of different frequencies
	private static void RunBuzzerTest(String s)
	{
		System.out.println("\n"+"Running: "+s+"\n");
		for(int i=0;i<=5000;i+=10)
		{
			myf.buzz(i,10);
			long before = System.currentTimeMillis();
			while(System.currentTimeMillis() - before < 10)
			{
				//Do nothing...
			}
		}
	}
	//Flash the Finch's nose red, green and blue
	//Then flash it randomly
	private static void RunNoseTest(String s)
	{
		System.out.println("\n"+"Running: "+s+"\n");
		for(int r=0;r<=255;r+=5)
		{
			myf.setLED(r,0,0,10);
		}
		for(int g=0;g<=255;g+=5)
		{
			myf.setLED(0,g,0,10);
		}
		for(int b=0;b<=255;b+=5)
		{
			myf.setLED(0,0,b,10);
		}
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for(int i=0;i<50;++i)
		{
			int r = Math.abs(rand.nextInt() % 255);
			int g = Math.abs(rand.nextInt() % 255);
			int b = Math.abs(rand.nextInt() % 255);
			myf.setLED(r,g,b,5);
		}
	}
}
