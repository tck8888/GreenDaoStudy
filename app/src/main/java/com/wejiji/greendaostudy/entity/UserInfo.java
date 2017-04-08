package com.wejiji.greendaostudy.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by tck on 2017/4/8.
 */
@Entity
public class UserInfo {
    @Id
    private Long id;
    @Property
    private String nickname;
    @Generated(hash = 1082974741)
    public UserInfo(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
    @Generated(hash = 1279772520)
    public UserInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
