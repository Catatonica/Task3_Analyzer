package analyzer.controller;

import com.sun.istack.internal.NotNull;

/**
 * @author Lizaveta Havina
 */
public interface PresenterFactory {
    @NotNull
    Presenter createPresenter();
}
