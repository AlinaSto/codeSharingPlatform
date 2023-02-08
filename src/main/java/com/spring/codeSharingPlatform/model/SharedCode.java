package com.spring.codeSharingPlatform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class SharedCode {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    String code;

    @Column
    Long allowedViewTime;

    @Column
    Integer views;

    @Column
    LocalDateTime createdDate;

    public SharedCode() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAllowedViewTime() {
        return allowedViewTime;
    }

    public void setAllowedViewTime(Long timeLeft) {
        this.allowedViewTime = timeLeft;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDateTime(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    //metode apelate in service
    public boolean isPublic(){
        return this.views == 0 && allowedViewTime ==0;
    }
    public Long getSecondsPassedSinceCreation(){
        return ChronoUnit.SECONDS.between(this.createdDate, LocalDateTime.now());
    }

    public boolean isExpired(){
        return (getSecondsPassedSinceCreation() > this.getAllowedViewTime() || (this.views == 0));
    }

    public Long getTimeLeft (){
        return this.allowedViewTime - getSecondsPassedSinceCreation();
    }
}
