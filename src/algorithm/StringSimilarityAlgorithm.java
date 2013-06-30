package algorithm;

public abstract class StringSimilarityAlgorithm extends BaseSimilarityAlgorithm {

	protected String str1, str2;
	
	public StringSimilarityAlgorithm(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}
	
	public String getStr1() {
		return str1;
	}

	public String getStr2() {
		return str2;
	}
}
