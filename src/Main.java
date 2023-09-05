import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		  Scanner inp = new Scanner(System.in);
		  System.out.print("Satir Sayisini Giriniz: "); 
		  int row = inp.nextInt();
		  System.out.print("Sutun Sayisini Giriniz: "); 
		  int col = inp.nextInt();
		 
		 
		
		MineSweeper one = new MineSweeper(row,col);
		one.run();
		 
	        
	    }
   

}

