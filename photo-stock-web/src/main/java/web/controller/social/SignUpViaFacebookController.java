
package web.controller.social;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.univer.qualifier.Facebook;

import ua.univer.photostock.service.SocialService;

@WebServlet(urlPatterns = "/sign-up/facebook", loadOnStartup = 1)
public class SignUpViaFacebookController extends HttpServlet {

    @Inject
    @Facebook
    private SocialService socialService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        redirectToUrl(socialService.getAuthorizeUrl(), req, resp);
    }
}
