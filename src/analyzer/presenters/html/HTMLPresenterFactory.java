package analyzer.presenters.html;

import analyzer.controller.Presenter;
import analyzer.controller.PresenterFactory;
import com.sun.istack.internal.NotNull;

public final class HTMLPresenterFactory implements PresenterFactory {
    @Override
    @NotNull
    public Presenter createPresenter() {
        return new HTMLPresenter();
    }
}
