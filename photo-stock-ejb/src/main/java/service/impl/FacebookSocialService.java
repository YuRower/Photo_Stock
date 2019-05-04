package service.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.registry.infomodel.User;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.scope.ExtendedPermissions;
import com.restfb.scope.ScopeBuilder;
import com.univer.qualifier.Facebook;

import ua.univer.photostock.exception.RetrieveSocialDataFailedException;
import ua.univer.photostock.service.SocialService;

@Facebook
@ApplicationScoped
public class FacebookSocialService implements SocialService {

    @Inject
    @Property("myphotos.social.facebook.client-id")
    private String clientId;

    @Inject
    @Property("myphotos.social.facebook.client-secret")
    private String secret;

    private String redirectUrl;

    @Inject
    public void setHost(@Property("myphotos.host") String host) {
        this.redirectUrl = host + "/from/facebook";
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Profile fetchProfile(String code)
            throws RetrieveSocialDataFailedException {
        try {
            return createProfile(fetch(code));
        } catch (RuntimeException e) {
            throw new RetrieveSocialDataFailedException(
                    "Can't fetch user from facebook: " + e.getMessage(), e);
        }
    }

    private User fetch(String code) {
        FacebookClient client = new DefaultFacebookClient(Version.LATEST);
        FacebookClient.AccessToken accessToken = client
                .obtainUserAccessToken(clientId, secret, redirectUrl, code);
        client = new DefaultFacebookClient(accessToken.getAccessToken(),
                Version.LATEST);
        return client.fetchObject("me", User.class,
                Parameter.with("fields", "id,email,first_name,last_name"));
    }

    private Profile createProfile(User user) {
        Profile profile = new Profile();
        profile.setEmail(user.getEmail());
        profile.setFirstName(user.getFirstName());
        profile.setLastName(user.getLastName());
        profile.setAvatarUrl(String.format(
                "https://graph.facebook.com/v2.7/%s/picture?type=large",
                user.getId()));
        return profile;
    }

    @Override
    public String getAuthorizeUrl() {
        ScopeBuilder scopeBuilder = new ScopeBuilder();
        scopeBuilder.addPermission(ExtendedPermissions.EMAIL);
        FacebookClient client = new DefaultFacebookClient(Version.LATEST);
        return client.getLoginDialogUrl(clientId, redirectUrl, scopeBuilder);
    }
}