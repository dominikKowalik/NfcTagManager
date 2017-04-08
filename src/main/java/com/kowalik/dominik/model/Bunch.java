package com.kowalik.dominik.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dominik on 2017-04-07.
 */

@Entity
@Table(name = "BUNCH")
@Component
public class Bunch{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "NUMBER", nullable = false, unique = true)
    private Integer number;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bunch", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<NfcTag> nfcTagList;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ENABLEAPPLICATIONS", joinColumns = @JoinColumn(name = "NFCTAGID"))
    @Column(name = "APPLICATION")
    private Set<String> enableApplications;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public Set<String> getEnableApplications() {
        return enableApplications;
    }

    public void setEnableApplications(Set<String> enableApplications) {
        this.enableApplications = enableApplications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bunch group = (Bunch) o;

        if (getId() != null ? !getId().equals(group.getId()) : group.getId() != null) return false;
        if (getNumber() != null ? !getNumber().equals(group.getNumber()) : group.getNumber() != null) return false;
        return getEnableApplications() != null ? getEnableApplications().equals(group.getEnableApplications()) : group.getEnableApplications() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getEnableApplications() != null ? getEnableApplications().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", number=" + number +
                ", enableApplications=" + enableApplications +
                '}';
    }

    public Set<NfcTag> getNfcTagList() {
        return nfcTagList;
    }

    public void setNfcTagList(Set<NfcTag> nfcTagList) {
        this.nfcTagList = nfcTagList;
    }
}
