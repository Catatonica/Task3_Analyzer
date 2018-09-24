package analyzer.interactor;

/**
 * Data-class, is used in XAnalyzer classes, provided by DatabaseProvider's implementations.
 *
 * @author Lizaveta Havina
 */
public final class Finances {
    private int currentSum;
    private int spentTodaySum;
    private int spentLastMonthSum;
    private int spentLastThreeMonthSum;

    public int getCurrentSum() {
        return currentSum;
    }

    public void setCurrentSum(int currentSum) {
        this.currentSum = currentSum;
    }

    public int getSpentTodaySum() {
        return spentTodaySum;
    }

    public void setSpentTodaySum(int spentTodaySum) {
        this.spentTodaySum = spentTodaySum;
    }

    public int getSpentLastMonthSum() {
        return spentLastMonthSum;
    }

    public void setSpentLastMonthSum(int spentLastMonthSum) {
        this.spentLastMonthSum = spentLastMonthSum;
    }

    public int getSpentLastThreeMonthSum() {
        return spentLastThreeMonthSum;
    }

    public void setSpentLastThreeMonthSum(int spentLastThreeMonthSum) {
        this.spentLastThreeMonthSum = spentLastThreeMonthSum;
    }
}
