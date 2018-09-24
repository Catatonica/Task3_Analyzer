package analyzer.database;

import analyzer.database.storage.LocalDatabase;
import analyzer.database.storage.RemoteDatabase;
import analyzer.interactor.FinanceProvider;
import analyzer.interactor.Finances;
import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * It's supposed that finances are provided from the LocalDatabase, if there're already there.
 */
public class DatabaseProvider implements FinanceProvider {
    @Override
    @NotNull
    public Map<Integer, Finances> provideUserFinances(int id) {
        Map<Integer, Finances> finances = LocalDatabase.getInstance().provideUserFinances(id);
        if (finances != null) {
            return finances;
        } else {
            finances = RemoteDatabase.getInstance().provideUserFinances(id);
            if (finances != null) {
                return finances;
            }
        }
        return new HashMap<>();
    }

    @Override
    @NotNull
    public Map<Integer, Finances> provideAllUsersFinances() {
        Map<Integer, Finances> finances = LocalDatabase.getInstance().provideAllUsersFinances();
        if (finances != null) {
            return finances;
        } else {
            finances = RemoteDatabase.getInstance().provideAllUsersFinances();
            if (finances != null) {
                return finances;
            }
        }
        return new HashMap<>();
    }

    @Override
    @NotNull
    public Map<Integer, Finances> provideSeveralUsersFinances(@NotNull final List<Integer> ids) {
        Map<Integer, Finances> finances = LocalDatabase.getInstance().provideSeveralUsersFinances(ids);
        if (finances != null) {
            return finances;
        } else {
            finances = RemoteDatabase.getInstance().provideSeveralUsersFinances(ids);
            if (finances != null) {
                return finances;
            }
        }
        return new HashMap<>();
    }
}
