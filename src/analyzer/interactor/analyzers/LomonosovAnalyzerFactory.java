package analyzer.interactor.analyzers;

import analyzer.interactor.Analyzer;
import analyzer.interactor.AnalyzerFactory;
import com.sun.istack.internal.NotNull;

public final class LomonosovAnalyzerFactory implements AnalyzerFactory {
    @Override
    @NotNull
    public Analyzer createAnalyzer() {
        return new LomonosovAnalyzer();
    }
}
