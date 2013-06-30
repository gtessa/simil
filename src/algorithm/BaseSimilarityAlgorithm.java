package algorithm;

public abstract class BaseSimilarityAlgorithm implements SimilarityAlgorithm {

	private long beginTimestamp, endTimestamp;

	@Override
	public double similarity() {
		
		beginTimestamp = System.currentTimeMillis();
		
		double result = calculateSimilarity();

		endTimestamp = System.currentTimeMillis();
		
		return result;
	}
	
	public long getTime() {
		return (endTimestamp-beginTimestamp);
	}

	protected abstract double calculateSimilarity();
}
