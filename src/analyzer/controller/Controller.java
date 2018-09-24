package analyzer.controller;

import analyzer.interactor.Analyzer;
import analyzer.interactor.AnalyzerFactory;
import analyzer.interactor.Report;
import analyzer.interactor.RequestModel;
import com.sun.istack.internal.NotNull;

/**
 * Contains main logic, is invoked from main() method.
 *
 * @author Lizaveta Havina
 */
public final class Controller {

    private RequestModel requestModel;
    private Analyzer analyzer;
    private Presenter presenter;

    public Controller(@NotNull final RequestModel requestModel,
                      @NotNull final AnalyzerFactory analyzerFactory,
                      @NotNull PresenterFactory presenterFactory) {
        this.requestModel = requestModel;
        this.analyzer = analyzerFactory.createAnalyzer();
        this.presenter = presenterFactory.createPresenter();
    }

    public Controller() {

    }

    public void setRequestModel(@NotNull final RequestModel requestModel) {
        this.requestModel = requestModel;
    }

    public void setPresenter(@NotNull final PresenterFactory presenterFactory) {
        this.presenter = presenterFactory.createPresenter();
    }

    public void setAnalyzer(@NotNull final AnalyzerFactory analyzerFactory) {
        this.analyzer = analyzerFactory.createAnalyzer();
    }

    public void showData() {
        if (analyzer != null && requestModel != null && presenter != null) {
            Report report = analyzer.analyze(requestModel);
            presenter.showReport(report);
        }
    }
}
