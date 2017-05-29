package org.pac4j.oauth.run;

import com.esotericsoftware.kryo.Kryo;
import org.pac4j.core.client.IndirectClient;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.Gender;
import org.pac4j.core.profile.ProfileHelper;
import org.pac4j.core.run.RunClient;
import org.pac4j.core.util.CommonHelper;
import org.pac4j.core.util.TestsHelper;
import org.pac4j.oauth.client.SinaClient;
import org.pac4j.oauth.profile.sina.SinaProfile;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Run manually a test for the {@link SinaClient}.
 *
 * @author xiexianbin
 * @since 1.9.6
 */
public final class RunSinaClient extends RunClient {

    public static void main(String[] args) throws Exception {
        new RunSinaClient().run();
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
        final SinaClient sinaClient = new SinaClient();
        sinaClient.setKey("3nJPbVTVRZWAyUgoUKQ8UA");
        sinaClient.setSecret("h6LZyZJmcW46Vu8R47MYfeXTSYGI30EqnWaSwVhFkbA");
        sinaClient.setCallbackUrl(PAC4J_URL);
        return sinaClient;
    }

    @Override
    protected void registerForKryo(final Kryo kryo) {
        kryo.register(SinaProfile.class);
    }

    @Override
    protected boolean canCancel() {
        return true;
    }

    @Override
    protected void verifyProfile(CommonProfile userProfile) {
        final SinaProfile profile = (SinaProfile) userProfile;
        assertEquals("488358057", profile.getId());
        assertEquals(SinaProfile.class.getName() + CommonProfile.SEPARATOR + "488358057", profile.getTypedId());
        assertTrue(ProfileHelper.isTypedIdOf(profile.getTypedId(), SinaProfile.class));
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
