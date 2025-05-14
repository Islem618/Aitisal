package org.aitisal.model;

public class PrivacySettings {
    private boolean profilePublic = true;
    private boolean postsPublic = true;

    public boolean isProfilePublic() { return profilePublic; }
    public boolean isPostsPublic() { return postsPublic; }

    public void setProfilePublic(boolean profilePublic) { this.profilePublic = profilePublic; }
    public void setPostsPublic(boolean postsPublic) { this.postsPublic = postsPublic; }
}