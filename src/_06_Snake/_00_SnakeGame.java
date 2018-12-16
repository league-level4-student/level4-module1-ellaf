package _06_Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

// Go through the methods and complete the steps in this class
// and the Snake class

public class _00_SnakeGame implements ActionListener, KeyListener {
	public static final Color BORDER_COLOR = Color.WHITE;
	public static final Color BACKGROUND_COLOR = Color.BLACK;
	public static final Color FOOD_COLOR = Color.RED;
	public static final int WIDTH = 15;
	public static final int HEIGHT = 12;
	public static final int WINDOW_SCALE = 50;
	public static final int WINDOW_WIDTH = WINDOW_SCALE * WIDTH;
	public static final int WINDOW_HEIGHT = WINDOW_SCALE * HEIGHT;

	private JFrame window;
	private JPanel panel;

	private Snake snake;

	private Timer timer;

	private Location foodLocation;
	
	Random gen = new Random();
	
	Scanner scan;
	
	ArrayList<String> highScores;

	public _00_SnakeGame() {
		snake = new Snake(new Location(WIDTH / 2, HEIGHT / 2));

		window = new JFrame("Snake");
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;

				g2.setColor(BACKGROUND_COLOR);
				g2.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

				g2.setColor(FOOD_COLOR);
				g2.drawOval(foodLocation.x * WINDOW_SCALE, foodLocation.y * WINDOW_SCALE, Snake.BODY_SIZE,
						Snake.BODY_SIZE);
				snake.draw(g);
			}
		};

		panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		window.add(panel);

		timer = new Timer(0, this);

		window.pack();
		window.addKeyListener(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		setFoodLocation();

		startGame();
	}

	public void startGame() {
		//1. Save the instructions for the game in the following string variable.
		String instructions = "i am the instructions";
		//??? what instructions??
		String[] options = new String[] { "Expert", "Moderate", "Beginner" };
		int input = JOptionPane.showOptionDialog(null, instructions, "Snake", 0, -1, null, options, 0);

		String choice = options[input];
		
		//2. Use a switch statement to determine which difficulty was chosen.
		switch(choice) {
		case "Expert":
			//what here
			timer.setDelay(100);
			break;
		case "Moderate":
			//what here
			timer.setDelay(200);
			break;
		case "Beginner":
			//what here
			timer.setDelay(300);
			break;
		}
		//   Use timer.setDelay(delay) with different numbers to change the speed
		//   of the game. The smaller the number, the faster it goes.

		//3. start the timer
		timer.start();
	}

	public static void main(String[] args) {
		new _00_SnakeGame();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		//1. Use a switch statement on e.getKeyCode()
		//   to determine which key was pressed.
		switch(e.getKeyCode()) {
		case 40:
			snake.setDirection(Direction.DOWN);
			break;
		case 37:
			snake.setDirection(Direction.LEFT);
			break;
		case 38:
			snake.setDirection(Direction.UP);
			break;
		case 39:
			snake.setDirection(Direction.RIGHT);
			break;
		case 32:
			snake.feed();
			break;
		
		
		}
		// if an arrow key is pressed, set the snake's 
		// direction accordingly
		
		// if the space key is pressed, call the snake's feed method
		
	}

	private void setFoodLocation() {
		//1. Create a new Location object that is set to a random location
		Location kevin = new Location(gen.nextInt(WIDTH), gen.nextInt(HEIGHT));
		//2. set the foodLocation variable equal to the Location object you just created.
		foodLocation = kevin;
		//   use the snake's isLocationOnSnake method to make sure you don't put the food on the snake
		snake.isLocationOnSnake(foodLocation);
		
	}

	private void gameOver() {
		highScores = new ArrayList<String>();
		//1. stop the timer
		timer.stop();
		//2. tell the user their snake is dead
		JOptionPane.showMessageDialog(null, "Your snake is dead.");
		int score = snake.score();
		String name = JOptionPane.showInputDialog(null, "Your score is: " + score + "\nWhat is your name?");
		String filename= "src/_06_Snake/scores.txt";
		 FileWriter fw;
		try
		{
		    
		    fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write(score + " - " + name + "\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		
		 
		
		    try {
		    		File file = new File(filename);
		        Scanner sc = new Scanner(file);
		        
		        while (sc.hasNextLine()) {
		            String i = sc.nextLine();
		            highScores.add(i);
		            System.out.println(i);
		        }
		        sc.close();
		    } 
		    catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
		    
		    System.out.println(highScores);
		   for(int j = 0; j < highScores.size(); j++) {
		    for (int i = 0; i < highScores.size() - 1; i++) {
				 String thisLine = highScores.get(i);
				 String nextLine = highScores.get(i+1);
				 int scoreVal1 = getInt(thisLine);
				 int scoreVal2 = getInt(nextLine);
				 if(scoreVal2 > scoreVal1) {
				highScores.set(i, nextLine);
				highScores.set(i+1, thisLine);
				 }
			}
		
		   }
		   System.out.println(highScores);
		   
		   try
			{
			    
			    FileWriter fa = new FileWriter(filename); //the true will append the new data
			    fa.write("");//appends the string to the file
			    fa.close();
			}
			catch(IOException ioe)
			{
			    System.err.println("IOException: " + ioe.getMessage());
			}
		   
		   for (int i = 0; i < highScores.size(); i++) {
			   try
				{
				    
				    FileWriter fb = new FileWriter(filename, true); //the true will append the new data
				    fb.write(highScores.get(i) + "\n");//appends the string to the file
				    fb.close();
				}
				catch(IOException ioe)
				{
				    System.err.println("IOException: " + ioe.getMessage());
				}
		}
		
		//3. ask them if they want to play again.
		String[] options = new String[] { "Yes", "No"};
		int ans = JOptionPane.showOptionDialog(null, "Do you want to play again?", null, 0, -1, null, options, 0);
		//4. if they want to play again
		if(ans == 0) {
			snake.reset(new Location(WIDTH/2,HEIGHT/2));
			timer.start();
		}else if(ans == 1) {
			System.exit(0);
		}
		//   reset the snake and the food and start the timer
		//   else, exit the game
		
		
	}
	
	int getInt(String scores) {
		String num = "";
		for (int i = 0; i < scores.length(); i++) {
		if(scores.substring(i, i+1).equals(" ")) {
		break;
		}else {
		num += scores.substring(i, i+1);
		}
		}
		int numInt = Integer.parseInt(num);
		return numInt;
	}
	


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//1. update the snake
		snake.update();
		int xLoc = snake.getHeadLocation().x;
		int yLoc = snake.getHeadLocation().y;
		Location resetUp = new Location(xLoc, 0);
		Location resetDown = new Location(xLoc, HEIGHT);
		Location resetLeft = new Location(0, yLoc);
		Location resetRight = new Location(WIDTH, yLoc);
		//2. if the snake is colliding with its own body 
		//   or if the snake is out of bounds, call gameOver
		if(snake.isHeadCollidingWithBody() == true) {
		gameOver();
		}

		//3. if the location of the head is equal to the location of the food,
		// 	 feed the snake and set the food location
		if(snake.getHeadLocation().equals(foodLocation)) {
			snake.feed();
			foodLocation = new Location(gen.nextInt(WIDTH), gen.nextInt(HEIGHT));
		}
			
			if(snake.getHeadLocation().y == HEIGHT+1) {
            snake.setHeadLocation(resetUp);
			}
			if(snake.getHeadLocation().y == -1){
			snake.setHeadLocation(resetDown);
			}
			if(snake.getHeadLocation().x == WIDTH+1) {
			snake.setHeadLocation(resetLeft);
			}if(snake.getHeadLocation().x == -1) {
			snake.setHeadLocation(resetRight);
			}
		
		//4. call panel.repaint();
		panel.repaint();
	}
	}

