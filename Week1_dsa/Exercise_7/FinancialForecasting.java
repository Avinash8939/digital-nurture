public class FinancialForecasting {

    
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }

        return calculateFutureValueRecursive(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

   
    public static void main(String[] args) {
        double presentValue = 1000.0; 
        double growthRate = 0.05;     
        int periods = 10;             

        double futureValueRecursive = calculateFutureValueRecursive(presentValue, growthRate, periods);
        double futureValueIterative = calculateFutureValueIterative(presentValue, growthRate, periods);

        System.out.printf("Future Value (Recursive): %.2f%n", futureValueRecursive);
        System.out.printf("Future Value (Iterative): %.2f%n", futureValueIterative);
    }
}
