public class FinancialForecast {

    public static void main(String[] args) {
        double[] pastGrowthRates = {0.05, 0.07, 0.04, 0.06, 0.08};
        double totalGrowth = GrowthCalculator.averageGrowthRate(pastGrowthRates, 0);
        double avgGrowth = totalGrowth / pastGrowthRates.length;

        double currentRevenue = 250000;
        int yearsAhead = 5;

        double naiveResult = GrowthCalculator.naiveFutureValue(currentRevenue, avgGrowth, yearsAhead);
        double fastResult = GrowthCalculator.fastFutureValue(currentRevenue, avgGrowth, yearsAhead);

        System.out.println("Average historical growth rate: " + (avgGrowth * 100) + "%");
        System.out.println("Projected revenue in " + yearsAhead + " years (naive recursion): " + naiveResult);
        System.out.println("Projected revenue in " + yearsAhead + " years (fast recursion): " + fastResult);
    }
}
