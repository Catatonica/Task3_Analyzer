package analyzer.interactor;

import com.sun.istack.internal.NotNull;

/**
 * Data-class, is used in Controller, provided by XAnalyzer classes.
 *
 * @author Lizaveta Havina
 */
public final class Report {
    private String data;

    @NotNull
    public String getData() {
        return data;
    }

    public void setData(@NotNull final String data) {
        this.data = data;
    }
}
