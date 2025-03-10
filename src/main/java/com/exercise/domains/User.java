package com.exercise.domains;

import com.exercise.domains.enums.UserType;

import java.time.LocalDate;


public class User {

    private final String userId;
    private final UserType type;
    private final LocalDate customerSince;

    public User(String userId, UserType type, LocalDate customerSince) {
        this.userId = userId;
        this.type = type;
        this.customerSince = customerSince;
    }

    public String getUserId() {
        return userId;
    }

    public UserType getType() {
        return type;
    }

    public LocalDate getCustomerSince() {
        return customerSince;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", type=" + type +
                ", customerSince=" + customerSince +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String userId;
        private UserType type;
        private LocalDate customerSince;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder type(UserType type) {
            this.type = type;
            return this;
        }

        public Builder customerSince(LocalDate customerSince) {
            this.customerSince = customerSince;
            return this;
        }

        public User build() {
            return new User(userId, type, customerSince);
        }
    }

}
