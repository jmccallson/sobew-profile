package org.sobew.entities;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Component
public class ProfileUserEntity {
  private Long userId;
  private String contactName;
  private String contactNameLc;
  private Timestamp createDate;
  private Timestamp updateDate;
  private String loginName;
  private String loginNameLc;
  private String firstName;
  private String firstNameNls;
  private String lastName;
  private String lastNameNls;
  private String displayName;
  private String email;
  private String emailLc;
  private String country;
  private Boolean emailVerify;
  private Timestamp deletedDate;
  private String accountType;
  private Boolean enabled;
  private String phoneNumber;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public String getContactNameLc() {
    return contactNameLc;
  }

  public void setContactNameLc(String contactNameLc) {
    this.contactNameLc = contactNameLc;
  }

  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }

  public Timestamp getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Timestamp updateDate) {
    this.updateDate = updateDate;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getLoginNameLc() {
    return loginNameLc;
  }

  public void setLoginNameLc(String loginNameLc) {
    this.loginNameLc = loginNameLc;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstNameNls() {
    return firstNameNls;
  }

  public void setFirstNameNls(String firstNameNls) {
    this.firstNameNls = firstNameNls;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastNameNls() {
    return lastNameNls;
  }

  public void setLastNameNls(String lastNameNls) {
    this.lastNameNls = lastNameNls;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmailLc() {
    return emailLc;
  }

  public void setEmailLc(String emailLc) {
    this.emailLc = emailLc;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Boolean getEmailVerify() {
    return emailVerify;
  }

  public void setEmailVerify(Boolean emailVerify) {
    this.emailVerify = emailVerify;
  }

  public Timestamp getDeletedDate() {
    return deletedDate;
  }

  public void setDeletedDate(Timestamp deletedDate) {
    this.deletedDate = deletedDate;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
