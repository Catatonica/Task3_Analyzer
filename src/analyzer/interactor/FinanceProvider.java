package analyzer.interactor;

import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Is used for polymorphism in XAnalyzer classes.
 *
 * @author Lizaveta Havina
 */
public interface FinanceProvider {
    @NotNull
    Map<Integer, Finances> provideUserFinances(int id);

    @NotNull
    Map<Integer, Finances> provideAllUsersFinances();

    @NotNull
    Map<Integer, Finances> provideSeveralUsersFinances(@NotNull final List<Integer> ids);
}
