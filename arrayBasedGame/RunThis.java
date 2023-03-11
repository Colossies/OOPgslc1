package arrayBasedGame;
import java.util.Random;
import java.util.Scanner;




public class RunThis {
	
//	 private static void pressEnterToContinue()
//	 { 
//		 	Scanner sc = new Scanner(System.in);
//	        System.out.println("Press Enter key to continue...");
//	        try
//	        {
//	            System.in.read();
//	            sc.nextLine();
//	        }  
//	        catch(Exception e)
//	        {}  
//	 }
	
	static boolean printInterface(int difficulty, int questionArray[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Difficulty: " + difficulty);
		System.out.println("Please memorize the following number in order");
		for(int i = 0; i < difficulty + 4; i++) {
			System.out.print(questionArray[i]);
		}
		System.out.println();
//		pressEnterToContinue();
//		Does not work for eclipse console
		
//		System.out.print("\033[H\033[2J");
//		System.out.flush();
		
		System.out.println("Press enter to continue...");
		sc.nextLine();
		for(int i = 0; i < 50; i++) {
			System.out.println("");
		}
		
		
		System.out.println("Please input the number shown before:");
		System.out.println("Note: put spaces in between the numbers");
		
		int correct = 0;
		int incorrect = 0;
		
		int ansArray[] = new int[difficulty + 4];
		for(int i = 0; i < difficulty + 4; i++) {
			ansArray[i] = sc.nextInt();
			if(ansArray[i] == questionArray[i]) correct++;
			else incorrect++;
		}
		
		System.out.println("Task: ");
		for(int i = 0; i < difficulty + 4; i++) {
			System.out.print(questionArray[i]);
		}
		System.out.println("");
		System.out.println("Your answer: ");
		for(int i = 0; i < difficulty + 4; i++) {
			System.out.print(ansArray[i]);
		}
		System.out.println();
		System.out.println("==========================");
		System.out.println("Correct anwer: " + correct);
		System.out.println("Incorrect answer: " + incorrect);
		
		if(incorrect == 0) return true;
		return false;
		
		
	}
	
	static int[] generateList(int questionArray[], int difficulty){
		int n = difficulty + 4;
		Random rand = new Random();
//		System.out.println("1");
		for(int i = 0; i < n; i++) {
//			System.out.println("2");
			questionArray[i] = rand.nextInt(10);
		}
		
		return questionArray;
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int difficulty = 1;
		while(true) {
			int questionArray[] = new int[difficulty + 4];
			generateList(questionArray, difficulty);
//			System.out.println(questionArray);
		
			boolean cont = printInterface(difficulty, questionArray);
			System.out.println("Your score: " + difficulty);
			if(cont == false) break;
			System.out.println("====================");
			difficulty++;
		}
		
		
		
	}
}
