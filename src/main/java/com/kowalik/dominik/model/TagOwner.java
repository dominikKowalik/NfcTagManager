package com.kowalik.dominik.model;

import javax.persistence.*;

/**
 * Created by dominik on 2017-04-02.
 */

@Entity
@Table(name = "TAGOWNER")
public class TagOwner implements Comparable<TagOwner> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long id;

    @Column(name = "NAME", nullable = false, length = 30)
    public String name;

    @Column(name = "LASTNAME", nullable = false, length = 30)
    public String lastname;

    @Column(name = "COMPANYNAME", length = 30)
    public String companyName;

    @Column(name = "PHONENUMBER", length = 30)
    public String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(TagOwner o) {
        if(this.equals(o)) return  0;
        return this.id.compareTo(o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagOwner tagOwner = (TagOwner) o;

        if (getId() != null ? !getId().equals(tagOwner.getId()) : tagOwner.getId() != null) return false;
        if (getName() != null ? !getName().equals(tagOwner.getName()) : tagOwner.getName() != null) return false;
        if (getLastname() != null ? !getLastname().equals(tagOwner.getLastname()) : tagOwner.getLastname() != null)
            return false;
        if (getCompanyName() != null ? !getCompanyName().equals(tagOwner.getCompanyName()) : tagOwner.getCompanyName() != null)
            return false;
        return getPhoneNumber() != null ? getPhoneNumber().equals(tagOwner.getPhoneNumber()) : tagOwner.getPhoneNumber() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
        result = 31 * result + (getCompanyName() != null ? getCompanyName().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TagOwner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
