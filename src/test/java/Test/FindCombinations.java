package Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FindCombinations {

	public static void main(String[] args) {	

		/*List  of news papers*/
		String[] PapersName= {"TOI","Hindu","ET","BM","HT"};

		/*Price of news papers */
		final double[] ArrayTOI={3, 3, 3, 3, 3, 5, 6}, ArrayHindu={2.5, 2.5, 2.5, 2.5, 2.5,  2.5, 4};
		final double[] ArrayET={4, 4, 4, 4, 4, 4, 10}, ArrayBM={1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5};
		final double[] ArrayHT={2, 2, 2, 2, 2, 4, 4};

		/*Calculating Weekly total amount of News papers*/
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

		/*Adding news pape name and total weekly amount into Map*/
		Map<String, Double> mp=new LinkedHashMap<String, Double>();
		for (int i = 0; i < total.length; i++) {
			mp.put(PapersName[i], total[i]);
		}

		/*Printing all news paper name and total weekly amount to  user*/
		System.out.println("List of News Papers and weekly costs");
		mp.forEach((k,v)->System.out.println(k+"  "+v));
		System.out.println();

		/*Getting user Budget from user*/
		System.out.println("Minimum Base price is RS29 to get pair of news papers");
		System.out.println("Please enter your  weekly Amount and it should be morethen minimun Price");
		Scanner sc=new Scanner(System.in);
		double userbudget = sc.nextInt();

		/*Verifying Minimun amount of user and*/
		/*Printing the News papers pairs */
		System.out.println();
		final double miniumAmount=29;
		if(userbudget>=miniumAmount) {

			/*Printing the News papers name for user in his/her Budget*/
			System.out.println("Bellow are the news papers list in your budget");
			for (Map.Entry<String, Double> entry : mp.entrySet()) {
				if (entry.getValue() <= userbudget) {
					System.out.println(entry.getKey());
				}
			}
			System.out.println();
			System.out.println("The pair of news papers fit in your budget");
			int count=0;
			for (Map.Entry<String, Double> entry1 : mp.entrySet()) {
				for (Map.Entry<String, Double> entry2 : mp.entrySet()) {
					if (entry1.equals(entry2)) {
						continue;
					}
					double totalCost = entry1.getValue() + entry2.getValue();
					if (totalCost <= userbudget) {
						System.out.println("Pair: " +"{ "+ entry1.getKey() + ", " + entry2.getKey()+" }");
						count++;
					}
				}
			}
			System.out.println("Total pairs: " + count);
		}else {
			System.out.println("Sorry Please select a minimum amount "+miniumAmount+" and above to get pairs");
		}
	}
}
