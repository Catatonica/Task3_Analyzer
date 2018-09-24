package analyzer.interactor;

import com.sun.istack.internal.NotNull;

/**
 * Is used for polymorphism in Controller.
 *
 * @author Lizaveta Havina
 */
public interface Analyzer {
    @NotNull
    Report analyze(@NotNull final RequestModel requestModel);
}
