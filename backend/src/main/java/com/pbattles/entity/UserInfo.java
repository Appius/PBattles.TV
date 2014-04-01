package com.pbattles.entity;

/**
 * Created by Nazar_Sheremeta on 3/25/14.
 */
public class UserInfo {

    public UserInfo() {
    }

    public UserInfo(String sessionId) {
        this.sessionId = sessionId;
    }

    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (!sessionId.equals(userInfo.sessionId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return sessionId.hashCode();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "sessionId='" + sessionId + '\'' +
                '}';
    }
}
