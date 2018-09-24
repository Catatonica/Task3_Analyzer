package analyzer.presenters.html;

import analyzer.controller.Presenter;
import analyzer.interactor.Report;
import analyzer.views.html.HTMLActivity;
import com.sun.istack.internal.NotNull;

/**
 * Is used in Controller to show data in HTML format.
 *
 * @author Lizaveta Havina
 */
public final class HTMLPresenter implements Presenter {
    @Override
    public void showReport(@NotNull final Report report) {
        HTMLView view = new HTMLActivity();
        String dataInHtml = modifyDataForHTMLView(report);
        view.showDataInHTML(dataInHtml);
    }

    @NotNull
    private String modifyDataForHTMLView(@NotNull final Report report) {
        final String someModifications = "\n This is data for HTML view:\n";
        return someModifications + report.getData();
    }
}
