package analyzer.views.html;

import analyzer.presenters.html.HTMLView;
import com.sun.istack.internal.NotNull;

/**
 * Interacts with the UI, is used to show data in appropriate way.
 *
 * @author Lizaveta Havina
 */
public final class HTMLActivity implements HTMLView {
    @Override
    public void showDataInHTML(@NotNull final String data) {
        System.out.println(data);
    }
}
