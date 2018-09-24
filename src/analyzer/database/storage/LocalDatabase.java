package analyzer.database.storage;

import analyzer.interactor.Finances;
import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Is used to get finances from local database (in our case, it gets fake finances)
 * in LocalDatabaseProvider.
 *
 * @author Lizaveta Havina
 */
public final class LocalDatabase {
    private static LocalDatabase database;
    private volatile static boolean instanceCreated;

    private LocalDatabase() {

    }

    public static LocalDatabase getInstance() {
        if (!instanceCreated) {
            synchronized (LocalDatabase.class) {
                if (!instanceCreated) {
                    database = new LocalDatabase();
                    instanceCreated = true;
                }
            }
        }
        return database;
    }

    @NotNull
    public Map<Integer, Finances> provideAllUsersFinances() {
        return FakeFinances.getAllUsersFinances();
    }

    @NotNull
    public Map<Integer, Finances> provideSeveralUsersFinances(@NotNull final List<Integer> ids) {
        return FakeFinances.getSeveralUsersFinances(ids);
    }

    @NotNull
    public Map<Integer, Finances> provideUserFinances(int id) {
        return FakeFinances.getUserFinances(id);
    }
}
