package analyzer;

import analyzer.controller.Controller;
import analyzer.controller.PresenterFactory;
import analyzer.interactor.AnalyzerFactory;
import analyzer.interactor.RequestModel;
import analyzer.interactor.analyzers.EilerAnalyzerFactory;
import analyzer.presenters.html.HTMLPresenterFactory;
import analyzer.presenters.pdf.PDFPresenterFactory;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This app implements Open-Closed principle from SOLID.
 * In real, FinanceProvider, RequestModel and Analyzer are injected from somewhere outside.
 * <p>
 * Analyzer is used to analyze users' finance data. You can set id(s) of the user(s)
 * you'd like to get data from or get finance data from all users.
 *
 * @author Lizaveta Havina
 */
public class Main {
    public static void main(String args[]) {
        List<Integer> userIds = new ArrayList<>();
        userIds.add(7);
        userIds.add(2);
        userIds.add(-1);

        test(new RequestModel(new RequestModel.SeveralUsers(userIds)),
                new EilerAnalyzerFactory(),
                new HTMLPresenterFactory());
    }

    private static void test(@NotNull final RequestModel requestModel,
                             @NotNull final AnalyzerFactory analyzer,
                             @NotNull final PresenterFactory presenter) {
        Controller controller = new Controller(requestModel, analyzer, presenter);
        controller.showData();

        controller.setRequestModel(new RequestModel(new RequestModel.OneUser(2)));
        controller.setPresenter(new PDFPresenterFactory());
        controller.showData();
    }
}
