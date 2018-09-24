package analyzer.database.storage;

import analyzer.interactor.Finances;
import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Is used to get finances from remote database (in our case, it gets fake finances)
 * in RemoteDatabaseProvider.
 *
 * @author Lizaveta Havina
 */
public final class RemoteDatabase {
    private static RemoteDatabase database;
    private volatile static boolean instanceCreated;

    private RemoteDatabase() {

    }

    public static RemoteDatabase getInstance() {
        if (!instanceCreated) {
            synchronized (RemoteDatabase.class) {
                if (!instanceCreated) {
                    database = new RemoteDatabase();
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
