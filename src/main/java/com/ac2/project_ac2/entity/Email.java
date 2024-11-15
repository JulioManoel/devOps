package com.ac2.project_ac2.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
    private String address;
    
    public Email() {}

    public Email(String address) {
    	this.setAddress(address);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
    	if (address == null || !address.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email inválido");
        }
    	
        this.address = address;
    }
}