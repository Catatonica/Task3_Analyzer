package analyzer.presenters.pdf;

import analyzer.controller.Presenter;
import analyzer.controller.PresenterFactory;
import com.sun.istack.internal.NotNull;

public final class PDFPresenterFactory implements PresenterFactory {
    @Override
    @NotNull
    public Presenter createPresenter() {
        return new PDFPresenter();
    }
}
