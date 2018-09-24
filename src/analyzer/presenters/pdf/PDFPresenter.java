package analyzer.presenters.pdf;

import analyzer.controller.Presenter;
import analyzer.interactor.Report;
import analyzer.views.pdf.PDFActivity;
import com.sun.istack.internal.NotNull;

/**
 * Is used in Controller to show data in PDF format.
 *
 * @author Lizaveta Havina
 */
public final class PDFPresenter implements Presenter {

    @Override
    public void showReport(@NotNull final Report report) {
        PDFView view = new PDFActivity();
        String dataInPdf = modifyDataForPDFView(report);
        view.showDataInPdf(dataInPdf);
    }

    @NotNull
    private String modifyDataForPDFView(@NotNull final Report report) {
        final String someModifications = "\n This is data for PDF view:\n";
        return someModifications + report.getData();
    }
}
