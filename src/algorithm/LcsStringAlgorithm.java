package algorithm;

import static java.lang.Math.max;

public class LcsStringAlgorithm extends StringSimilarityAlgorithm {

	private int[][] result;
	
	public LcsStringAlgorithm(String str1, String str2) {
		super(str1,str2);
	}
	
	@Override
	protected double calculateSimilarity() {
		
		calculateMatrix();
		
		int lengthLcs = result[str1.length()][str2.length()];
		
		double meanStrLength = (str1.length() + str2.length())/2.0;
		
		double resultado = lengthLcs/meanStrLength;
        
        return Double.isNaN(resultado)? 0: resultado;
	}

	
	private void calculateMatrix() {
        
		if (result == null) {
            //Cria a tabela.
            result = new int[str1.length()+1][str2.length()+1];

            //Seta os valores na tabela.
            for (int i = 1; i < result.length; i++) {
                for (int j = 1; j < result[i].length; j++) {
                    if (str1.charAt(i-1) == str2.charAt(j-1)) {
                        result[i][j] = result[i - 1][j - 1] + 1;
                    } else {
                        result[i][j] = max(result[i][j - 1], result[i - 1][j]);
                    }
                }
            }
        }		
	}
}
