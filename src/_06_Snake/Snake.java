package _06_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);

		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		//1. add a new SnakeSegment object to the snake
		snake.add(new SnakeSegment(new Location(10,10), BODY_SIZE));
		//snake.get(0).getLocation()
	}

	public Location getHeadLocation() {
		//2. return the location of the snake's head
		return head.getLocation();
	}

	public void update() {
		//1. use a switch statement to check on the currentDirection
		//   of the snake and calculate its next x and y position.
		Location nextLoc = null;
		switch(currentDirection) {
		case RIGHT:
			nextLoc = new Location((head.getLocation().x) + 1, head.getLocation().y);
			break;
		case LEFT:
			nextLoc = new Location((head.getLocation().x) - 1, head.getLocation().y);
			break;
			
		case UP:
			nextLoc = new Location(head.getLocation().x, (head.getLocation().y) - 1);
			break;
		case DOWN:
			nextLoc = new Location(head.getLocation().x, (head.getLocation().y) + 1);
			break;
		}

		//2. Iterate through the SnakeSegments in reverse order
		for(int i = snake.size()-1; i > 0; i--) {
			snake.get(i).setLocation(snake.get(i-1).getLocation());
		}
		//2a. Update each snake segment to the location of the segment 
		//    in front of it.
		head.setLocation(nextLoc);
		
		//3. set the location of the head to the new location calculated in step 1
		canMove = true;

		//4. set canMove to true
		
	}

	public void setDirection(Direction d) {
		if(currentDirection.equals(Direction.RIGHT) && d.equals(Direction.LEFT)) {
			
		}else if(currentDirection.equals(Direction.LEFT) && d.equals(Direction.RIGHT)) {
			
		}else if(currentDirection.equals(Direction.UP) && d.equals(Direction.DOWN)) {
			
		}else if(currentDirection.equals(Direction.DOWN) && d.equals(Direction.UP)) {
			
		}else {
		//1. set the current direction equal to the passed in Direction only if canMove is true.
		if(canMove == true) {
		currentDirection = d;
		}
		//   set canMove equal to false.
		canMove = false;
		//   make sure the snake cannot completely reverse directions.
		
		}
	}

	public void reset(Location loc) {
		//1. clear the snake
		snake.clear();
		//2. set the location of the head
		head.setLocation(loc);
		//3. add the head to the snake
		snake.add(head);
	}

	public boolean isOutOfBounds(int xBound, int yBound) {
		//1. complete the method so it returns true if the head of the snake is outside of the window
		//   and false otherwise
		if(head.getLocation().x > xBound) {
			return true;
		}else if(head.getLocation().y > yBound) {
			return true;
		}else {
		return false;
		}
	}
	
	public boolean isHeadCollidingWithBody() {
		//1. complete the method so it returns true if the head is located
		//   in the same location as any other body segment
		boolean sharedLocation = false;
		for(int i = 1; i < snake.size()-1; i++)
		if(head.getLocation() == snake.get(i).getLocation()) {
		sharedLocation = true;
		}
		return sharedLocation;
	}

	public boolean isLocationOnSnake(Location loc) {
		//1. complete the method so it returns true if the passed in
		//   location is located on the snake
		boolean exists = false;
		for(int i = 0; i < snake.size(); i++) {
		if(snake.get(i).getLocation() == loc) {
			exists = true;
		}
		}
		return exists;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
