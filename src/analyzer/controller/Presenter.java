package analyzer.controller;

import analyzer.interactor.Report;
import com.sun.istack.internal.NotNull;

/**
 * Is used for polymorphism in Controller.
 *
 * @author Lizaveta Havina
 */
public interface Presenter {
    void showReport(@NotNull final Report report);

}
