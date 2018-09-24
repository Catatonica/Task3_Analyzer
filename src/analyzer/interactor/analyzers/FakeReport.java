package analyzer.interactor.analyzers;

import analyzer.interactor.Finances;
import analyzer.interactor.Report;
import com.sun.istack.internal.NotNull;

import java.util.Map;

/**
 * Imitates true report, is used in XAnalyzer classes.
 *
 * @author Lizaveta Havina
 */
final class FakeReport {
    @NotNull
    public static Report getFakeReport(@NotNull final Map<Integer, Finances> financesMap) {
        Report report = new Report();
        StringBuilder reportBuilder = new StringBuilder();
        for (int id : financesMap.keySet()) {
            reportBuilder.append(createReportData(id, financesMap.get(id)));
        }
        report.setData(reportBuilder.toString());
        return report;
    }

    private static String createReportData(int id, @NotNull final Finances finances) {
        final StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append('\n').append(" User ").append(id).append(" finances: ").append('\n');
        reportBuilder.append(" CurrentSum = ").append(finances.getCurrentSum()).append('\n');
        reportBuilder.append(" SpentTodaySum = ").append(finances.getSpentTodaySum()).append('\n');
        reportBuilder.append(" SpentLastMonthSum = ").append(finances.getSpentLastMonthSum()).append('\n');
        reportBuilder.append(" SpentLastThreeMonthSum = ").append(finances.getSpentLastThreeMonthSum()).append('\n');
        return reportBuilder.toString();
    }
}
