package com.kowalik.dominik.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by dominik on 2017-03-14.
 */

@Entity
@Component
@Table(name = "NFCTAG")
public class NfcTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NFCUIDHEX", nullable = false)
    private String nfcUidHex;

    @Column(name = "ISADMINTAG", nullable = false)
    private Boolean isAdminTag;

    @Column(name = "GROUPNUMBER", nullable = false)
    private Integer groupNumber;

    /**
     * This method is invoked before persist the object, since I want to set isAdminTag on false by default
     */
    @PrePersist
    public void prePersist(){
        if(isAdminTag == null)
            isAdminTag = false;
    }

    @Override
    public String toString() {
        return "NfcTag{" +
                "id=" + id +
                ", nfcUidHex='" + nfcUidHex + '\'' +
                ", isAdminTag=" + isAdminTag +
                ", groupNumber=" + groupNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NfcTag nfcTag = (NfcTag) o;

        if (getId() != null ? !getId().equals(nfcTag.getId()) : nfcTag.getId() != null) return false;
        if (getNfcUidHex() != null ? !getNfcUidHex().equals(nfcTag.getNfcUidHex()) : nfcTag.getNfcUidHex() != null)
            return false;
        if (isAdminTag != null ? !isAdminTag.equals(nfcTag.isAdminTag) : nfcTag.isAdminTag != null) return false;
        return getGroupNumber() != null ? getGroupNumber().equals(nfcTag.getGroupNumber()) : nfcTag.getGroupNumber() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNfcUidHex() != null ? getNfcUidHex().hashCode() : 0);
        result = 31 * result + (isAdminTag != null ? isAdminTag.hashCode() : 0);
        result = 31 * result + (getGroupNumber() != null ? getGroupNumber().hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNfcUidHex() {
        return nfcUidHex;
    }

    public void setNfcUidHex(String nfcUidHex) {
        this.nfcUidHex = nfcUidHex;
    }

    public Boolean getAdminTag() {
        return isAdminTag;
    }

    public void setAdminTag(Boolean adminTag) {
        isAdminTag = adminTag;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }
}
