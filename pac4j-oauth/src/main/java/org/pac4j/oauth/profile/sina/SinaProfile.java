package org.pac4j.oauth.profile.sina;

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
public class SinaProfile extends OAuth10Profile {
    
    private static final long serialVersionUID = -6473348745856820192L;

    private transient final static AttributesDefinition ATTRIBUTES_DEFINITION = new SinaAttributesDefinition();

    @Override
    public AttributesDefinition getAttributesDefinition() {
        return ATTRIBUTES_DEFINITION;
    }
    
    @Override
    public String getDisplayName() {
        return (String) getAttribute(SinaAttributesDefinition.NAME);
    }
    
    @Override
    public String getUsername() {
        return (String) getAttribute(SinaAttributesDefinition.SCREEN_NAME);
    }
    
    @Override
    public Locale getLocale() {
        return (Locale) getAttribute(SinaAttributesDefinition.LANG);
    }
    
    @Override
    public String getPictureUrl() {
        return (String) getAttribute(SinaAttributesDefinition.PROFILE_IMAGE_URL);
    }
    
    @Override
    public String getProfileUrl() {
        return (String) getAttribute(SinaAttributesDefinition.URL);
    }
    
    public Boolean getContributorsEnabled() {
        return (Boolean) getAttribute(SinaAttributesDefinition.CONTRIBUTORS_ENABLED);
    }
    
    public Date getCreatedAt() {
        return (Date) getAttribute(SinaAttributesDefinition.CREATED_AT);
    }
    
    public Boolean getDefaultProfile() {
        return (Boolean) getAttribute(SinaAttributesDefinition.DEFAULT_PROFILE);
    }
    
    public Boolean getDefaultProfileImage() {
        return (Boolean) getAttribute(SinaAttributesDefinition.DEFAULT_PROFILE_IMAGE);
    }
    
    public String getDescription() {
        return (String) getAttribute(SinaAttributesDefinition.DESCRIPTION);
    }
    
    public Integer getFavouritesCount() {
        return (Integer) getAttribute(SinaAttributesDefinition.FAVOURITES_COUNT);
    }
    
    public Boolean getFollowRequestSent() {
        return (Boolean) getAttribute(SinaAttributesDefinition.FOLLOW_REQUEST_SENT);
    }
    
    public Integer getFollowersCount() {
        return (Integer) getAttribute(SinaAttributesDefinition.FOLLOWERS_COUNT);
    }
    
    public Boolean getFollowing() {
        return (Boolean) getAttribute(SinaAttributesDefinition.FOLLOWING);
    }
    
    public Integer getFriendsCount() {
        return (Integer) getAttribute(SinaAttributesDefinition.FRIENDS_COUNT);
    }
    
    public Boolean getGeoEnabled() {
        return (Boolean) getAttribute(SinaAttributesDefinition.GEO_ENABLED);
    }
    
    public Boolean getIsTranslator() {
        return (Boolean) getAttribute(SinaAttributesDefinition.IS_TRANSLATOR);
    }
    
    public Integer getListedCount() {
        return (Integer) getAttribute(SinaAttributesDefinition.LISTED_COUNT);
    }
    
    public Boolean getNotifications() {
        return (Boolean) getAttribute(SinaAttributesDefinition.NOTIFICATIONS);
    }
    
    public Color getProfileBackgroundColor() {
        return (Color) getAttribute(SinaAttributesDefinition.PROFILE_BACKGROUND_COLOR);
    }
    
    public String getProfileBackgroundImageUrl() {
        return (String) getAttribute(SinaAttributesDefinition.PROFILE_BACKGROUND_IMAGE_URL);
    }
    
    public String getProfileBackgroundImageUrlHttps() {
        return (String) getAttribute(SinaAttributesDefinition.PROFILE_BACKGROUND_IMAGE_URL_HTTPS);
    }
    
    public Boolean getProfileBackgroundTile() {
        return (Boolean) getAttribute(SinaAttributesDefinition.PROFILE_BACKGROUND_TILE);
    }
    
    public String getProfileImageUrlHttps() {
        return (String) getAttribute(SinaAttributesDefinition.PROFILE_IMAGE_URL_HTTPS);
    }
    
    public Color getProfileLinkColor() {
        return (Color) getAttribute(SinaAttributesDefinition.PROFILE_LINK_COLOR);
    }
    
    public Color getProfileSidebarBorderColor() {
        return (Color) getAttribute(SinaAttributesDefinition.PROFILE_SIDEBAR_BORDER_COLOR);
    }
    
    public Color getProfileSidebarFillColor() {
        return (Color) getAttribute(SinaAttributesDefinition.PROFILE_SIDEBAR_FILL_COLOR);
    }
    
    public Color getProfileTextColor() {
        return (Color) getAttribute(SinaAttributesDefinition.PROFILE_TEXT_COLOR);
    }
    
    public Boolean getProfileUseBackgroundImage() {
        return (Boolean) getAttribute(SinaAttributesDefinition.PROFILE_USE_BACKGROUND_IMAGE);
    }
    
    public Boolean getProtected() {
        return (Boolean) getAttribute(SinaAttributesDefinition.PROTECTED);
    }
    
    public Boolean getShowAllInlineMedia() {
        return (Boolean) getAttribute(SinaAttributesDefinition.SHOW_ALL_INLINE_MEDIA);
    }
    
    public Integer getStatusesCount() {
        return (Integer) getAttribute(SinaAttributesDefinition.STATUSES_COUNT);
    }
    
    public String getTimeZone() {
        return (String) getAttribute(SinaAttributesDefinition.TIME_ZONE);
    }
    
    public Integer getUtcOffset() {
        return (Integer) getAttribute(SinaAttributesDefinition.UTC_OFFSET);
    }
    
    public Boolean getVerified() {
        return (Boolean) getAttribute(SinaAttributesDefinition.VERIFIED);
    }
}
