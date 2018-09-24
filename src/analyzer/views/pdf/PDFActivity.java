package analyzer.views.pdf;

import analyzer.presenters.pdf.PDFView;
import com.sun.istack.internal.NotNull;

/**
 * Interacts with the UI, is used to show data in appropriate way.
 *
 * @author Lizaveta Havina
 */
public final class PDFActivity implements PDFView {
    @Override
    public void showDataInPdf(@NotNull final String data) {
        System.out.println(data);
    }
}
