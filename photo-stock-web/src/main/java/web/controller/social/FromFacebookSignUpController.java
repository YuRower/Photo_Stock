
package web.controller.social;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import com.univer.qualifier.Facebook;

import ua.univer.photostock.service.SocialService;

@WebServlet(urlPatterns = "/from/facebook", loadOnStartup = 1)
public class FromFacebookSignUpController extends AbstractSignUpController {

    @Inject
    @Override
    protected void setSocialService(@Facebook SocialService socialService) {
        this.socialService = socialService;
    }
}
