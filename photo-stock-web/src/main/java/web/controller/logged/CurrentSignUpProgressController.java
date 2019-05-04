
package web.controller.logged;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.univer.photostock.model.domain.Profile;

@WebServlet(urlPatterns = "/sign-up", loadOnStartup = 1)
public class CurrentSignUpProgressController extends HttpServlet {

    @Inject
    private ProfileSignUpServiceProxy profileSignUpService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Profile profile = profileSignUpService.getCurrentProfile();
        System.out.println("Current profile: " + profile);
        forwardToPage("home", req, resp);
    }
}
