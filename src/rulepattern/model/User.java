package rulepattern.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {

    private String userName;

    private LocalDate dateOfBirth;

    private long totalOrders;

    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", totalOrders=" + totalOrders +
                ", createdAt=" + createdAt +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
