package maze;

import java.util.ArrayList;

public class PartialSolution {
	
	private String [] maze;
	private ArrayList<String>  exits = new ArrayList<String>();
	private String location;
	private int x;
	private int y;
	private int moves = 0;
	private boolean valid = true;
	
	public static final int ACCEPT = 1;
	public static final int ABANDON = 2;
	public static final int CONTINUE = 3;
	
	
	
	public PartialSolution(String [] maze) {
		this.maze = maze;
		
		for(int i = 0; i < maze.length; i++ ) {
			for(int j = 0; j < maze[i].length(); j++ ) {
				if(maze[i].charAt(j) == 'X' || maze[i].charAt(j) == 'x') {
					location = i+ " " + j;
					x = j;
					y = i;
				}
				if(j == 0 || j == maze[i].length() - 1 || i == 0 || i == maze.length - 1) {
					if( maze[i].charAt(j) == ' ') {
						exits.add(i +" "+ j);
						
					}
					
				}
			}
		}
	}
	public PartialSolution(String [] maze, int y, int x, ArrayList<String> exits, boolean valid) {
		this.maze = maze;
		this.exits = exits;
		this.x = x;
		this.y = y;
		this.valid = valid;
		location = y + " " + x;
	}
	public int examine() {
		
		for(String e: exits) {
			if(location.equals(e)) {
				maze[ y  ] = maze[ y  ].substring(0 , x) + "o" + maze[ y  ].substring(x+1);
				return ACCEPT;
			}
			
		}
		
		if(!valid) {
			
			return ABANDON;
		}
		
		return CONTINUE;
		
	}
	
	public PartialSolution [] extend(){
		PartialSolution [] result = new PartialSolution [4];
	
		
		if( maze[ y ].charAt( x ) != 'X' && maze[ y ].charAt( x ) != 'x') {
			
			maze[ y ] = maze[ y ].substring(0 , x) + "o" + maze[ y ].substring(x+1);
			
		}
		
		
		
		if( maze[ y + 1 ].charAt( x ) == ' ' ) {
			
			result[0] = new PartialSolution(maze, y+1,x, exits, true );
		}else {
			result[0] = new PartialSolution(maze, y, x, exits, false );
		}
		
		if( maze[ y - 1 ].charAt( x ) == ' ' ) {
			result[1] = new PartialSolution(maze, y-1,x, exits, true );
			
		}else {
			result[1] = new PartialSolution(maze, y,x, exits, false );
		}
		if( maze[ y  ].charAt( x + 1 ) == ' ' ) {
			
			result[2] = new PartialSolution(maze, y,x + 1, exits, true );
		}else {
			result[2] = new PartialSolution(maze, y,x, exits, false );
		}
		if( maze[ y  ].charAt( x - 1 ) == ' ' ) {
			
			result[3] = new PartialSolution(maze, y,x - 1, exits, true );
		}else {
			result[3] = new PartialSolution(maze, y,x, exits, false );
		}
		
		return result;
	}
	public String[] getMaze() {
		return maze;
	}
	
	
	
	
	
}
