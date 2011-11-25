package util;

public class APFD {

	public static double getAPFD(int numberOfTestCases, int numberOfFaults, int[] firstsRevealingIndexes){
		int sumOfIndexes = 0;
		for (int i : firstsRevealingIndexes) {
			sumOfIndexes+= i;
		}
		
		double parc1 = 1.0;
		double nm = (double)(numberOfFaults*numberOfTestCases);
		double parc2 = sumOfIndexes/nm;
		double parc3 = 1/(double)(2*numberOfTestCases);

		return parc1  -  parc2  +  parc3;
	}
}
