package com.cn.ssmr.model;

import java.io.Serializable;

/**
 * Created by sewef on 2017/9/25.
 */


public class Member implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1959528436584592183L;

    public Member() {
    }

    public Member(String id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    private String id;
    private String nickname;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
