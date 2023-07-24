package Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FindCombinations {

	public static void main(String[] args) {	

		 /* List of newspapers */
		String[] PapersName= {"TOI","Hindu","ET","BM","HT"};

		 /* Price of newspapers */
		final double[] ArrayTOI={3, 3, 3, 3, 3, 5, 6}, ArrayHindu={2.5, 2.5, 2.5, 2.5, 2.5,  2.5, 4};
		final double[] ArrayET={4, 4, 4, 4, 4, 4, 10}, ArrayBM={1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5};
		final double[] ArrayHT={2, 2, 2, 2, 2, 4, 4};

		 /* Weekly total amount of newspapers */
		double sumOfTOI=0, sumOfHindu=0, sumOfET=0, sumOfBM=0, sumOfHT=0;
		for (int i = 0; i < ArrayTOI.length; i++) {
			sumOfTOI=sumOfTOI+ArrayTOI[i]; sumOfHindu=sumOfHindu+ArrayHindu[i];
			sumOfET=sumOfET+ArrayET[i]; sumOfBM=sumOfBM+ArrayBM[i];
			sumOfHT=sumOfHT+ArrayHT[i];
		}

		/*Adding total amount in Array*/
		double[] total=new double[5];
		total[0]=sumOfTOI; total[1]=sumOfHindu;
		total[2]=sumOfET; total[3]=sumOfBM;
		total[4]=sumOfHT;

		 /* Adding newspaper name and total weekly amount into Map */
		Map<String, Double> mp=new LinkedHashMap<String, Double>();
		for (int i = 0; i < total.length; i++) {
			mp.put(PapersName[i], total[i]);
		}

		 /* Printing all newspapers' names and total weekly amount to the user */
		System.out.println("List of NewsPapers and weekly costs");
		mp.forEach((k,v)->System.out.println(k+"  "+v));
		System.out.println();

		 /* Getting user Budget from user */
		final double miniumAmount=29;
		System.out.println("Minimum Base price is RS" + miniumAmount + " to get a pair of newspapers.");
	    System.out.println("Please enter your weekly Amount and it should be more than the minimum price.");
		Scanner sc=new Scanner(System.in);
		double userbudget = sc.nextInt();

		/* Verifying the minimum amount of the user and printing the newspaper pairs */
		System.out.println();
		if(userbudget>=miniumAmount) {

			 /* Printing the newspapers' names that fit within the user's budget */
			System.out.println("Below are the newspapers in your budget");
			for (Map.Entry<String, Double> entry : mp.entrySet()) {
				if (entry.getValue() <= userbudget) {
					System.out.println(entry.getKey());
				}
			}
			System.out.println();
			 System.out.println("The pairs of newspapers that fit in your budget:");
			int count=0;
			for (int i = 0; i < PapersName.length; i++) {
				for (int j = i + 1; j < PapersName.length; j++) {
					double totalCost = total[i] + total[j];
					if (totalCost <= userbudget) {
						System.out.println("Pair: { " + PapersName[i] + ", " + PapersName[j] + " }");
						count++;
					}
				}
			}
			System.out.println("Total pairs: " + count);
		}else {
			System.out.println("Sorry, please select a minimum amount of " + miniumAmount + " and above to get pairs.");
		}
	}
}
