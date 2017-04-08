package com.kowalik.dominik.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by dominik on 2017-03-26.
 */

@Entity
@Component
@Table(name = "ACCOUNT")
public class Account implements Comparable<Account> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false, name = "USERNAME")
    private String userName;

    @Column(nullable = false, name = "PASSWORD")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (getId() != null ? !getId().equals(account.getId()) : account.getId() != null) return false;
        if (getUserName() != null ? !getUserName().equals(account.getUserName()) : account.getUserName() != null)
            return false;
        return getPassword() != null ? getPassword().equals(account.getPassword()) : account.getPassword() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int compareTo(Account o) {
        if(this.equals(o)) return 0;
        return this.id.compareTo(o.getId());
    }

}
