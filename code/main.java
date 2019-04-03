import java.util.ArrayList;
import java.util.Arrays;

import maze.PartialSolution;

public class main {

	public static void main(String[] args) {
	
		
		String [] maze = {
				"************",
				"*        X**",
				"*  *********",
				"*          *",
				"***** *    *",
				"*     *    *",
				"* **********",				
		};
		solve(new PartialSolution(maze) );
		
	}
	public static void solve(PartialSolution sol){
		
		int exam = sol.examine();
		if(exam == sol.ACCEPT) {
			String [] maze = sol.getMaze();
			for(String m:maze) {
				System.out.println(m);
				
			}
			System.out.println();
			
		}else if(exam == sol.CONTINUE){
			for(PartialSolution p: sol.extend()) {
				solve(p);
			}
			
		}
		
		
		
	}
	
	
}
