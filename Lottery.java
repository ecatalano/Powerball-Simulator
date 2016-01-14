import java.util.Arrays;

public class Lottery{
	//won by matching all five white balls in any order and the red Powerball
	//five numbers between 1-69 and one number between 1-26
	public static int redNumber(){
		int minimum = 1;
		int maximumRed = 26;
		int randomRed = minimum + (int)(Math.random()*maximumRed);
		return randomRed;
	}
	public static int[] generateNumbers(){
		int[] allNumbers = new int[6];
		int minimum = 1;
		int maximumWhite = 69;
		allNumbers[0] = redNumber();
		for(int i = 1; i < 6; i++){
			int randomWhite = minimum + (int)(Math.random()*maximumWhite);
			allNumbers[i] = randomWhite;
		}
		return allNumbers;
	}
	public static int redNumberCompare(int[] arr1, int[] arr2){
		int retVal = 0;
		if(arr1[0] == arr2[0]){
			retVal = 1;
		}
		return retVal;
	}
	public static int whiteNumberCompare(int[] arr1, int[] arr2){
		int retVal = 0;
		for(int i = 1; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(arr1[i] == arr2[j]){
					retVal++;
				}
			}
		}
		return retVal;
	}
	public static void main(String[] args){
		int[] numberDraw = generateNumbers();
		int count = 0;
		for(int i = 0; i < 20000000; i++){
			int[] myTicket = generateNumbers();
			if(redNumberCompare(numberDraw, myTicket) == 1 && whiteNumberCompare(numberDraw,myTicket) == 5){
				count++;
				System.out.println("JACKPOT!!");
			}
		}
		System.out.println("Number of jackpot winners: " + count);
	}


}