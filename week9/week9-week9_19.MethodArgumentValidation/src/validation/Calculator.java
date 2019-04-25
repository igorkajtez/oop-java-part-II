package validation;

public class Calculator {

    public int multiplication(int fromInteger) {
        
        if(fromInteger < 0){
            throw new IllegalArgumentException("Parameter must be greater than or equal to 0.");
        }

        int multiplication = 1;
        for (int i = 1; i <= fromInteger; i++) {
            multiplication *= i;
        }

        return multiplication;
    }

    public int binomialCoefficient(int setSize, int subsetSize) {
        if(setSize < 0 || subsetSize < 0){
            throw new IllegalArgumentException("Parameters must be greater than or equal to 0.");
        }
        if(subsetSize > setSize){
            throw new IllegalArgumentException("Subset's size must be smaller than the set's size.");
        }

        int numerator = multiplication(setSize);
        int denominator = multiplication(subsetSize) * multiplication(setSize - subsetSize);

        return numerator / denominator;
    }
}
