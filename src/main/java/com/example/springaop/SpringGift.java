package com.example.springaop;

import java.util.concurrent.atomic.AtomicInteger;

public class SpringGift {

    private String role;
    private AtomicInteger gift;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AtomicInteger getGift() {
        return gift;
    }

    public void setGift(AtomicInteger gift) {
        this.gift = gift;
    }
}
