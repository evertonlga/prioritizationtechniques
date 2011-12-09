package util;

public class LineElement implements Comparable{
	
	String testCaseName;
	int statmentCoverageValue;
	int methodCoverageValue;
	int blockCoverageValue;
	
	public LineElement(String name, int stat, int meth, int block) {
		this.testCaseName = name;
		this.statmentCoverageValue = stat;
		this.methodCoverageValue = meth;
		this.blockCoverageValue = block;
	}
	
	public LineElement(String name, int stat, int meth) {
		this.testCaseName = name;
		this.statmentCoverageValue = stat;
		this.methodCoverageValue = meth;
	}
	
	public String toString(){
		return testCaseName+"  "+statmentCoverageValue+"  "+methodCoverageValue + "  "+ blockCoverageValue;
	}

	@Override
	public int compareTo(Object obj) {
		LineElement le = (LineElement)obj;
		if (this.statmentCoverageValue > le.statmentCoverageValue)
			return 1;
		else if (this.statmentCoverageValue < le.statmentCoverageValue)
			return -1;
		return 0;
	}

}
