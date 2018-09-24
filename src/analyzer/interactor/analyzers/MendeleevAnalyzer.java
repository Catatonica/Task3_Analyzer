package analyzer.interactor.analyzers;

import analyzer.database.DatabaseProvider;
import analyzer.interactor.*;
import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Map;

/**
 * @author Lizaveta Havina
 * @see EilerAnalyzer
 */
public final class MendeleevAnalyzer implements Analyzer {
    @NotNull
    @Override
    public Report analyze(@NotNull final RequestModel requestModel) {
        FinanceProvider provider = new DatabaseProvider();
        RequestModel.Requested requested = requestModel.getRequested();
        Map<Integer, Finances> userFinancesMap;
        switch (requested.getType()) {
            case RequestModel.Requested.ONE_USER:
                int id = ((RequestModel.OneUser) requested).getUserId();
                userFinancesMap = provider.provideUserFinances(id);
                return getMendeleevAnalyze(userFinancesMap);

            case RequestModel.Requested.SEVERAL_USERS:
                List<Integer> ids = ((RequestModel.SeveralUsers) requested).getUserIds();
                userFinancesMap = provider.provideSeveralUsersFinances(ids);
                return getMendeleevAnalyze(userFinancesMap);

            case RequestModel.Requested.ALL_USERS:
                userFinancesMap = provider.provideAllUsersFinances();
                return getMendeleevAnalyze(userFinancesMap);
        }
        return null;
    }

    @NotNull
    private Report getMendeleevAnalyze(@NotNull final Map<Integer, Finances> userFinancesMap) {
        return FakeReport.getFakeReport(userFinancesMap);
    }
}
