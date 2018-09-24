package ch.fhnw.webfr.flashcard.listener;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import ch.fhnw.webfr.flashcard.util.QuestionnaireInitializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BasicListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        QuestionnaireRepository questionnaireRepository;
        String mode = sce.getServletContext().getInitParameter("mode");

        if (mode != null && mode.equals("test")) {
            questionnaireRepository = new QuestionnaireInitializer().initRepoWithTestData();
        } else {
            questionnaireRepository = new QuestionnaireRepository();
        }

        sce.getServletContext().setAttribute("repository", questionnaireRepository);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) { }
}
