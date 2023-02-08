package com.spring.codeSharingPlatform.dto;

import com.spring.codeSharingPlatform.model.SharedCode;

public class SharedCodeResponseDTO {

    private SharedCode sharedCode;
    private Long timeLeft;
private  boolean isPrivate;
    public SharedCodeResponseDTO(SharedCode sharedCode, Long timeLeft, boolean isPrivate) {
        this.sharedCode = sharedCode;
        this.timeLeft = timeLeft;
        this.isPrivate = isPrivate;
    }

    public SharedCode getSharedCode() {
        return sharedCode;
    }

    public void setSharedCode(SharedCode sharedCode) {
        this.sharedCode = sharedCode;
    }

    public Long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Long timeLeft) {
        this.timeLeft = timeLeft;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
}
