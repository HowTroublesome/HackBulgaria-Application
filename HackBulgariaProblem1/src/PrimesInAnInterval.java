import java.util.ArrayList;
import java.util.Scanner;

public class PrimesInAnInterval{
	
	public static ArrayList<Integer> primesInAnInterval(int from, int to){
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean primeNumberChecker = true;
		
		if(from >= to){
			System.err.println("Error! Bad Range...!");
			return null;
		}
		
		if(from < 0 || to < 0){
			System.err.print("Error! Negative Numbers In The Range...!");
			return null;
		}
		
		for(int i = from; i <= to; i++){
			
			primeNumberChecker = true;
			if(i % 2 == 0){
				primeNumberChecker = false;
			}
			if(i == 2){
				primeNumberChecker = true;
			}
			for(int j = 3; j*j <= i; j = j + 2){
				if(i % j == 0){
					primeNumberChecker = false;
				}
			}
			
			if(primeNumberChecker == true){
				primes.add(i);
			}
		}
		
		return primes;
		
	}
	
	public static void printPrimesInAnInterval(ArrayList<Integer> primes){
		System.out.print("[");
		for(int i = 0; i < primes.size()-1; i++){
			System.out.print(primes.get(i) + ", ");
		}
		System.out.print(primes.get(primes.size()-1));
		System.out.print("]");
	}
	
	public static void main(String[] arguments){
		
		Scanner myScan = new Scanner(System.in);
		int from;
		int to;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		System.out.print("Enter The Beginning Of The Interval: ");
		from = myScan.nextInt();
		System.out.print("Enter The End Of The Interval: ");
		to = myScan.nextInt();
		
		primes = primesInAnInterval(from, to);
		printPrimesInAnInterval(primes);
		
	}
	
}