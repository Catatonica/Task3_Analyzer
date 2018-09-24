package analyzer.presenters.pdf;

import com.sun.istack.internal.NotNull;

/**
 * Is used for polymorphism in PDFPresenter.
 *
 * @author Lizaveta Havina
 */
public interface PDFView {
    void showDataInPdf(@NotNull final String data);
}
