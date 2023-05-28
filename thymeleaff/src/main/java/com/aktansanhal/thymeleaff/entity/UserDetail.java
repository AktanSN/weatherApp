package com.aktansanhal.thymeleaff.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_detail")
public class UserDetail {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String detail;

        @ManyToOne()
        @JoinColumn(name = "user_id")
        private User user;


        public UserDetail() {
        }

        public UserDetail(Long id, String detail, User user) {
                this.id = id;
                this.detail = detail;
                this.user = user;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getDetail() {
                return detail;
        }

        public void setDetail(String detail) {
                this.detail = detail;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }
}
