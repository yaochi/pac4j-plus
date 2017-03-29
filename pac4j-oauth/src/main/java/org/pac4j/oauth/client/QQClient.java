package org.pac4j.oauth.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.api.BaseApi;
import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.OAuth1Token;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.util.CommonHelper;
import org.pac4j.oauth.profile.JsonHelper;
import org.pac4j.oauth.profile.qq.QQProfile;

/**
 * <p>This class is the OAuth client to authenticate users in QQ.</p>
 * <p>You can define if a screen should always been displayed for authorization confirmation by using the
 * {@link #setAlwaysConfirmAuthorization(boolean)} method (<code>false</code> by default).</p>
 * <p>It returns a {@link org.pac4j.oauth.profile.qq.QQProfile}.</p>
 * <p>More information at https://dev.twitter.com/docs/api/1/get/account/verify_credentials</p>
 * 
 * @author xiexianbin
 * @since 1.9.6
 */
public class QQClient extends BaseOAuth20StateClient<QQProfile> {
    
    public static final String RESPONSE_TYPE_CODE = "code";

    public enum Google2Scope {
        EMAIL,
        PROFILE,
        EMAIL_AND_PROFILE
    }

    protected final static String PROFILE_SCOPE = "profile";

    protected final static String EMAIL_SCOPE = "email";

    protected Google2Scope scope = Google2Scope.EMAIL_AND_PROFILE;

    protected String scopeValue;

    public QQClient() {
        setResponseType(RESPONSE_TYPE_CODE);
    }
    
    public QQClient(final String key, final String secret) {
        this();
        setKey(key);
        setSecret(secret);
    }
    
    @Override
    protected void internalInit(final WebContext context) {
        CommonHelper.assertNotNull("scope", this.scope);
        if (this.scope == Google2Scope.EMAIL) {
            this.scopeValue = this.EMAIL_SCOPE;
        } else if (this.scope == Google2Scope.PROFILE) {
            this.scopeValue = this.PROFILE_SCOPE;
        } else {
            this.scopeValue = this.PROFILE_SCOPE + " " + this.EMAIL_SCOPE;
        }
        super.internalInit(context);
    }

    @Override
    protected BaseApi<OAuth20Service> getApi() {
        return GoogleApi20.instance();
    }

    @Override
    protected String getOAuthScope() {
        return this.scopeValue;
    }

    @Override
    protected String getProfileUrl(final OAuth2AccessToken accessToken) {
        return "https://www.googleapis.com/plus/v1/people/me";
    }

    @Override
    protected QQProfile extractUserProfile(final String body) throws HttpAction {
        final QQProfile profile = new QQProfile();
        final JsonNode json = JsonHelper.getFirstNode(body);
        if (json != null) {
            profile.setId(JsonHelper.getElement(json, "id"));
            for (final String attribute : profile.getAttributesDefinition().getPrimaryAttributes()) {
                profile.addAttribute(attribute, JsonHelper.getElement(json, attribute));
            }
        }
        return profile;
    }
    
    @Override
    protected boolean hasBeenCancelled(final WebContext context) {
        final String error = context.getRequestParameter(OAuthCredentialsException.ERROR);
        // user has denied permissions
        if ("access_denied".equals(error)) {
            return true;
        }
        return false;
    }


    public Google2Scope getScope() {
        return this.scope;
    }

    public void setScope(final Google2Scope scope) {
        this.scope = scope;
    }
}
