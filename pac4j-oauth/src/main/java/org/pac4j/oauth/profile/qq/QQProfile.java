package org.pac4j.oauth.profile.qq;

import java.util.Date;
import java.util.Locale;

import org.pac4j.core.profile.AttributesDefinition;
import org.pac4j.core.profile.Color;
import org.pac4j.oauth.profile.OAuth10Profile;

/**
 * <p>This class is the user profile for Twitter with appropriate getters.</p>
 * <p>It is returned by the {@link org.pac4j.oauth.client.QQClient}.</p>
 *
 * @author xiexianbin
 * @since 1.9.6
 */
public class QQProfile extends OAuth10Profile {
    
    private static final long serialVersionUID = -6473348745856820192L;

    private transient final static AttributesDefinition ATTRIBUTES_DEFINITION = new QQAttributesDefinition();

    @Override
    public AttributesDefinition getAttributesDefinition() {
        return ATTRIBUTES_DEFINITION;
    }
    
    @Override
    public String getDisplayName() {
        return (String) getAttribute(QQAttributesDefinition.NAME);
    }
    
    @Override
    public String getUsername() {
        return (String) getAttribute(QQAttributesDefinition.SCREEN_NAME);
    }
    
    @Override
    public Locale getLocale() {
        return (Locale) getAttribute(QQAttributesDefinition.LANG);
    }
    
    @Override
    public String getPictureUrl() {
        return (String) getAttribute(QQAttributesDefinition.PROFILE_IMAGE_URL);
    }
    
    @Override
    public String getProfileUrl() {
        return (String) getAttribute(QQAttributesDefinition.URL);
    }
    
    public Boolean getContributorsEnabled() {
        return (Boolean) getAttribute(QQAttributesDefinition.CONTRIBUTORS_ENABLED);
    }
    
    public Date getCreatedAt() {
        return (Date) getAttribute(QQAttributesDefinition.CREATED_AT);
    }
    
    public Boolean getDefaultProfile() {
        return (Boolean) getAttribute(QQAttributesDefinition.DEFAULT_PROFILE);
    }
    
    public Boolean getDefaultProfileImage() {
        return (Boolean) getAttribute(QQAttributesDefinition.DEFAULT_PROFILE_IMAGE);
    }
    
    public String getDescription() {
        return (String) getAttribute(QQAttributesDefinition.DESCRIPTION);
    }
    
    public Integer getFavouritesCount() {
        return (Integer) getAttribute(QQAttributesDefinition.FAVOURITES_COUNT);
    }
    
    public Boolean getFollowRequestSent() {
        return (Boolean) getAttribute(QQAttributesDefinition.FOLLOW_REQUEST_SENT);
    }
    
    public Integer getFollowersCount() {
        return (Integer) getAttribute(QQAttributesDefinition.FOLLOWERS_COUNT);
    }
    
    public Boolean getFollowing() {
        return (Boolean) getAttribute(QQAttributesDefinition.FOLLOWING);
    }
    
    public Integer getFriendsCount() {
        return (Integer) getAttribute(QQAttributesDefinition.FRIENDS_COUNT);
    }
    
    public Boolean getGeoEnabled() {
        return (Boolean) getAttribute(QQAttributesDefinition.GEO_ENABLED);
    }
    
    public Boolean getIsTranslator() {
        return (Boolean) getAttribute(QQAttributesDefinition.IS_TRANSLATOR);
    }
    
    public Integer getListedCount() {
        return (Integer) getAttribute(QQAttributesDefinition.LISTED_COUNT);
    }
    
    public Boolean getNotifications() {
        return (Boolean) getAttribute(QQAttributesDefinition.NOTIFICATIONS);
    }
    
    public Color getProfileBackgroundColor() {
        return (Color) getAttribute(QQAttributesDefinition.PROFILE_BACKGROUND_COLOR);
    }
    
    public String getProfileBackgroundImageUrl() {
        return (String) getAttribute(QQAttributesDefinition.PROFILE_BACKGROUND_IMAGE_URL);
    }
    
    public String getProfileBackgroundImageUrlHttps() {
        return (String) getAttribute(QQAttributesDefinition.PROFILE_BACKGROUND_IMAGE_URL_HTTPS);
    }
    
    public Boolean getProfileBackgroundTile() {
        return (Boolean) getAttribute(QQAttributesDefinition.PROFILE_BACKGROUND_TILE);
    }
    
    public String getProfileImageUrlHttps() {
        return (String) getAttribute(QQAttributesDefinition.PROFILE_IMAGE_URL_HTTPS);
    }
    
    public Color getProfileLinkColor() {
        return (Color) getAttribute(QQAttributesDefinition.PROFILE_LINK_COLOR);
    }
    
    public Color getProfileSidebarBorderColor() {
        return (Color) getAttribute(QQAttributesDefinition.PROFILE_SIDEBAR_BORDER_COLOR);
    }
    
    public Color getProfileSidebarFillColor() {
        return (Color) getAttribute(QQAttributesDefinition.PROFILE_SIDEBAR_FILL_COLOR);
    }
    
    public Color getProfileTextColor() {
        return (Color) getAttribute(QQAttributesDefinition.PROFILE_TEXT_COLOR);
    }
    
    public Boolean getProfileUseBackgroundImage() {
        return (Boolean) getAttribute(QQAttributesDefinition.PROFILE_USE_BACKGROUND_IMAGE);
    }
    
    public Boolean getProtected() {
        return (Boolean) getAttribute(QQAttributesDefinition.PROTECTED);
    }
    
    public Boolean getShowAllInlineMedia() {
        return (Boolean) getAttribute(QQAttributesDefinition.SHOW_ALL_INLINE_MEDIA);
    }
    
    public Integer getStatusesCount() {
        return (Integer) getAttribute(QQAttributesDefinition.STATUSES_COUNT);
    }
    
    public String getTimeZone() {
        return (String) getAttribute(QQAttributesDefinition.TIME_ZONE);
    }
    
    public Integer getUtcOffset() {
        return (Integer) getAttribute(QQAttributesDefinition.UTC_OFFSET);
    }
    
    public Boolean getVerified() {
        return (Boolean) getAttribute(QQAttributesDefinition.VERIFIED);
    }
}
