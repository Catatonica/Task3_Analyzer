package analyzer.database.storage;

import analyzer.interactor.Finances;
import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Imitates Finances class, is used in XDatabase classes.
 *
 * @author Lizaveta Havina
 */
final class FakeFinances {

    private static final int USERS_NUMBER = 10;
    private static Map<Integer, Finances> userFinancesMap = getMapOfFakeFinances();

    @NotNull
    static Map<Integer, Finances> getUserFinances(int id) {
        Map<Integer, Finances> userFinances = new HashMap<>();
        Finances value = userFinancesMap.get(id);
        if (value == null) {
            System.out.println("There's no user with index " + id + "!");
        } else {
            userFinances.put(id, value);
        }
        return userFinances;
    }

    @NotNull
    static Map<Integer, Finances> getSeveralUsersFinances(@NotNull final List<Integer> ids) {
        Map<Integer, Finances> severalUsersFinances = new HashMap<>();
        for (int id : ids) {
            Finances value = userFinancesMap.get(id);
            if (value == null) {
                System.out.println("There's no user with index " + id + "!");
            } else {
                severalUsersFinances.put(id, value);
            }
        }
        return severalUsersFinances;
    }

    @NotNull
    static Map<Integer, Finances> getAllUsersFinances() {
        if (userFinancesMap != null) {
            return userFinancesMap;
        }
        return new HashMap<>();
    }

    @NotNull
    private static Finances getFakeFinances() {
        Random random = new Random();
        Finances finances = new Finances();
        finances.setCurrentSum(random.nextInt(100) + 400);
        finances.setSpentLastMonthSum(random.nextInt(100) + 1000);
        finances.setSpentLastThreeMonthSum(random.nextInt(100) + 5000);
        finances.setSpentTodaySum(random.nextInt(40) + 50);
        return finances;
    }

    @NotNull
    private static Map<Integer, Finances> getMapOfFakeFinances() {
        Map<Integer, Finances> financesMap = new HashMap<>();
        for (int i = 0; i < USERS_NUMBER; i++) {
            financesMap.put(i, getFakeFinances());
        }
        return financesMap;
    }
}
