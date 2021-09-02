package com.simsim.voteMatch.model;
import javax.persistence.*;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "admins")
public class Admin {
@Id
@Column(name = "ID_ADMIN")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
        private Long id_admin;

        @Column(name="userName")
        private String userName;

        @Column(name="password")
        private String password;

        public String getUserName() {
                return userName;
        }

        public String getPassword() {
                return password;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}
