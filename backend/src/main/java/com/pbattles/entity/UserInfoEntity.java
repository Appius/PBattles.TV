package com.pbattles.entity;

import org.springframework.data.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 02.04.14
 * Time: 0:54
 * To change this template use File | Settings | File Templates.
 */
public class UserInfoEntity {

    @Id
    private Long user_id;
    private Long session_id;
    private String account_name;

    public UserInfoEntity() {
    }

    public UserInfoEntity(Long user_id, Long session_id, String account_name) {
        this.user_id = user_id;
        this.session_id = session_id;
        this.account_name = account_name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoEntity that = (UserInfoEntity) o;

        if (account_name != null ? !account_name.equals(that.account_name) : that.account_name != null) return false;
        if (session_id != null ? !session_id.equals(that.session_id) : that.session_id != null) return false;
        if (!user_id.equals(that.user_id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user_id.hashCode();
        result = 31 * result + (session_id != null ? session_id.hashCode() : 0);
        result = 31 * result + (account_name != null ? account_name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "user_id=" + user_id +
                ", session_id=" + session_id +
                ", account_name='" + account_name + '\'' +
                '}';
    }


}
