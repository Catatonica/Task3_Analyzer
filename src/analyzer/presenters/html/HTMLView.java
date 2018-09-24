package analyzer.presenters.html;

import com.sun.istack.internal.NotNull;

/**
 * Is used for polymorphism in HTMLPresenter.
 *
 * @author Lizaveta Havina
 */
public interface HTMLView {
    void showDataInHTML(@NotNull final String data);
}
