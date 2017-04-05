package com.kowalik.dominik.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by dominik on 2017-03-14.
 */

@Entity
@Component
@Table(name = "NFCTAG")
public class NfcTag implements Comparable<NfcTag> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "nfcId", nullable = false)
    private String nfcId;

    @Column(name = "ISADMINTAG", nullable = false)
    private Boolean isAdminTag;

    @Column(name = "GROUPNUMBER", nullable = false)
    private Integer groupNumber;

    @OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "TAGOWNER")
    private TagOwner tagOwner;

    /**
     * This method is invoked before persist the object, since I want to set isAdminTag on false by default
     */
    @PrePersist
    public void prePersist(){
        if(isAdminTag == null)
            isAdminTag = false;
    }

    @Override
    public int compareTo(NfcTag o) {
        if(this.equals(o)) return 0;
        return getId().compareTo(o.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNfcId() {
        return nfcId;
    }

    public void setNfcId(String nfcId) {
        this.nfcId = nfcId;
    }

    public Boolean getIsAdminTag() {
        return isAdminTag;
    }

    public void setIsAdminTag(Boolean adminTag) {
        isAdminTag = adminTag;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public TagOwner getTagOwner() {
        return tagOwner;
    }

    public void setTagOwner(TagOwner tagOwner) {
        this.tagOwner = tagOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NfcTag nfcTag = (NfcTag) o;

        if (getId() != null ? !getId().equals(nfcTag.getId()) : nfcTag.getId() != null) return false;
        if (getNfcId() != null ? !getNfcId().equals(nfcTag.getNfcId()) : nfcTag.getNfcId() != null) return false;
        if (isAdminTag != null ? !isAdminTag.equals(nfcTag.isAdminTag) : nfcTag.isAdminTag != null) return false;
        if (getGroupNumber() != null ? !getGroupNumber().equals(nfcTag.getGroupNumber()) : nfcTag.getGroupNumber() != null)
            return false;
        return getTagOwner() != null ? getTagOwner().equals(nfcTag.getTagOwner()) : nfcTag.getTagOwner() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNfcId() != null ? getNfcId().hashCode() : 0);
        result = 31 * result + (isAdminTag != null ? isAdminTag.hashCode() : 0);
        result = 31 * result + (getGroupNumber() != null ? getGroupNumber().hashCode() : 0);
        result = 31 * result + (getTagOwner() != null ? getTagOwner().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NfcTag{" +
                "id=" + id +
                ", nfcId='" + nfcId + '\'' +
                ", isAdminTag=" + isAdminTag +
                ", groupNumber=" + groupNumber +
                ", tagOwner=" + tagOwner +
                '}';
    }
}
