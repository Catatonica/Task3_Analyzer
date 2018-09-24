package analyzer.interactor.analyzers;

import analyzer.database.DatabaseProvider;
import analyzer.interactor.*;
import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Is used to analyze data given by provider(LocalDatabase by default) according to RequestModel
 * (data for one user / group of users) and give a report( in our case, fake) to Controller.
 * Finances are stored in Map(key = user id, value = finance data).
 *
 * @author Lizaveta Havina
 */
public final class EilerAnalyzer implements Analyzer {
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
                return getEilerAnalyze(userFinancesMap);

            case RequestModel.Requested.SEVERAL_USERS:
                List<Integer> ids = ((RequestModel.SeveralUsers) requested).getUserIds();
                userFinancesMap = provider.provideSeveralUsersFinances(ids);
                return getEilerAnalyze(userFinancesMap);

            case RequestModel.Requested.ALL_USERS:
                userFinancesMap = provider.provideAllUsersFinances();
                return getEilerAnalyze(userFinancesMap);
            default:
                return getEilerAnalyze(new HashMap<>());
        }
    }

    @NotNull
    private Report getEilerAnalyze(@NotNull final Map<Integer, Finances> userFinancesMap) {
        return FakeReport.getFakeReport(userFinancesMap);
    }
}
