class GrowthCalculator {

    static double naiveFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return naiveFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    static double averageGrowthRate(double[] pastRates, int index) {
        if (index == pastRates.length - 1) {
            return pastRates[index];
        }
        return pastRates[index] + averageGrowthRate(pastRates, index + 1);
    }

    static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        double half = power(base, exponent / 2);
        double result = half * half;
        if (exponent % 2 != 0) {
            result *= base;
        }
        return result;
    }

    static double fastFutureValue(double presentValue, double growthRate, int years) {
        return presentValue * power(1 + growthRate, years);
    }
}
