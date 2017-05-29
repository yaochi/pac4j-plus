package org.pac4j.oauth.run;

import com.esotericsoftware.kryo.Kryo;
import org.pac4j.core.client.IndirectClient;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.Gender;
import org.pac4j.core.profile.ProfileHelper;
import org.pac4j.core.run.RunClient;
import org.pac4j.core.util.CommonHelper;
import org.pac4j.core.util.TestsHelper;
import org.pac4j.oauth.client.QQClient;
import org.pac4j.oauth.profile.qq.QQProfile;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Run manually a test for the {@link QQClient}.
 *
 * @author xiexianbin
 * @since 1.9.6
 */
public final class RunQQClient extends RunClient {

    public static void main(String[] args) throws Exception {
        new RunQQClient().run();
    }

    @Override
    protected String getLogin() {
        return "testscribeup@gmail.com";
    }

    @Override
    protected String getPassword() {
        return "testpwdscribeup";
    }

    @Override
    protected IndirectClient getClient() {
        final QQClient qqClient = new QQClient();
        qqClient.setKey("3nJPbVTVRZWAyUgoUKQ8UA");
        qqClient.setSecret("h6LZyZJmcW46Vu8R47MYfeXTSYGI30EqnWaSwVhFkbA");
        qqClient.setCallbackUrl(PAC4J_URL);
        return qqClient;
    }

    @Override
    protected void registerForKryo(final Kryo kryo) {
        kryo.register(QQProfile.class);
    }

    @Override
    protected boolean canCancel() {
        return true;
    }

    @Override
    protected void verifyProfile(CommonProfile userProfile) {
        final QQProfile profile = (QQProfile) userProfile;
        assertEquals("488358057", profile.getId());
        assertEquals(QQProfile.class.getName() + CommonProfile.SEPARATOR + "488358057", profile.getTypedId());
        assertTrue(ProfileHelper.isTypedIdOf(profile.getTypedId(), QQProfile.class));
        assertTrue(CommonHelper.isNotBlank(profile.getAccessToken()));
        assertCommonProfile(userProfile, null, null, null, "test scribeUP", "testscribeUP", Gender.UNSPECIFIED,
                Locale.UK, ".twimg.com/sticky/default_profile_images/default_profile_5_normal.png",
                "http://t.co/fNjYqp7wZ8", "New York");
        assertFalse(profile.getContributorsEnabled());
        assertEquals(TestsHelper.getFormattedDate(1328872224000L, "EEE MMM dd HH:mm:ss Z yyyy", Locale.US), profile
                .getCreatedAt().toString());
        assertTrue(profile.getDefaultProfile());
        assertTrue(profile.getDefaultProfileImage());
        assertEquals("biographie", profile.getDescription());
        assertEquals(0, profile.getFavouritesCount().intValue());
        assertFalse(profile.getFollowRequestSent());
        assertEquals(0, profile.getFollowersCount().intValue());
        assertFalse(profile.getFollowing());
        assertEquals(0, profile.getFriendsCount().intValue());
        assertFalse(profile.getGeoEnabled());
        assertFalse(profile.getIsTranslator());
        assertEquals(0, profile.getListedCount().intValue());
        assertFalse(profile.getNotifications());
        assertTrue(profile.getProfileBackgroundImageUrl().contains(".twimg.com/images/themes/theme1/bg.png"));
        assertTrue(profile.getProfileBackgroundImageUrlHttps().endsWith("/images/themes/theme1/bg.png"));
        assertFalse(profile.getProfileBackgroundTile());
        assertTrue(profile.getProfileImageUrlHttps().endsWith(
                "/sticky/default_profile_images/default_profile_5_normal.png"));
        assertTrue(profile.getProfileUseBackgroundImage());
        assertTrue(profile.getProtected());
        assertNull(profile.getShowAllInlineMedia());
        assertEquals(0, profile.getStatusesCount().intValue());
        assertEquals("Amsterdam", profile.getTimeZone());
        assertEquals(7200, profile.getUtcOffset().intValue());
        assertFalse(profile.getVerified());
        assertNotNull(profile.getAccessSecret());
        assertEquals(37, profile.getAttributes().size());
    }
}
