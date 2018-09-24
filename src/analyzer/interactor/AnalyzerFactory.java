package analyzer.interactor;

import com.sun.istack.internal.NotNull;

public interface AnalyzerFactory {
    @NotNull
    Analyzer createAnalyzer();
}
