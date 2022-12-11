package com.bslnd.seva.card.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.UUID;

import static com.bslnd.seva.card.validation.ValidationConstants.EMAIL_REGEX;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_ADDRESS;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_CITY;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_DOB;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_EMAIL;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_FATHER_NAME;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_FULL_NAME;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_GENDER;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_GOTRA;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_KNOWN_LANGUAGE;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_NATIONALITY;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_PATH_YEAR;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_PHONE;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_PIN;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_POB;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_PROFESSION;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_QUALIFICATION;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_STATE;
import static com.bslnd.seva.card.validation.ValidationConstants.INVALID_TOB;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Sevadar {

    private final String uuid;

    @NotBlank(message = INVALID_FULL_NAME)
    private final String fullName;

    @NotBlank(message = INVALID_FATHER_NAME)
    private final String fatherName;

    @NotBlank(message = INVALID_GENDER)
    private final String gender;

    @Email(message = INVALID_EMAIL, regexp = EMAIL_REGEX)
    private final String email;

    @NotBlank(message = INVALID_PHONE)
    private final String phone;

    @NotBlank(message = INVALID_ADDRESS)
    private final String address;

    @NotBlank(message = INVALID_STATE)
    private final String state;

    @NotBlank(message = INVALID_CITY)
    private final String city;

    @NotBlank(message = INVALID_PIN)
    private final String pin;

    @NotBlank(message = INVALID_PROFESSION)
    private final String profession;

    @NotBlank(message = INVALID_QUALIFICATION)
    private final String qualification;

    @NotNull(message = INVALID_PATH_YEAR)
    private final String pathYear;

    @NotBlank(message = INVALID_KNOWN_LANGUAGE)
    private final String knownLanguage;

    @NotBlank(message = INVALID_GOTRA)
    private final String gotra;

    @NotBlank(message = INVALID_DOB)
    private final String dob;

    @NotBlank(message = INVALID_TOB)
    private final String tob;

    @NotBlank(message = INVALID_POB)
    private final String pob;

    @NotBlank(message = INVALID_NATIONALITY)
    private final String nationality;

    private String userPhoto;

    public Sevadar(@JsonProperty("uuid") final String uuid, @JsonProperty("full_name") final String fullName,
                   @JsonProperty("father_spouse_name") final String fatherName, @JsonProperty("gender") final String gender,
                   @JsonProperty("email") final String email, @JsonProperty("phone_number") final String phone, @JsonProperty("address") final String address,
                   @JsonProperty("state") final String state, @JsonProperty("city") final String city, @JsonProperty("pincode") final String pin,
                   @JsonProperty("profession") final String profession, @JsonProperty("qualification") final String qualification, @JsonProperty("paath_taken_year") final String pathYear,
                   @JsonProperty("known_language") final String knownLanguage, @JsonProperty("gotra") final String gotra, @JsonProperty("dob") final String dob,
                   @JsonProperty("tob") final String tob, @JsonProperty("placeofbirth") final String pob, @JsonProperty("nationality") final String nationality) {
        this.uuid = uuid != null ? uuid : UUID.randomUUID().toString();
        this.fullName = fullName;
        this.fatherName = fatherName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.state = state;
        this.city = city;
        this.pin = pin;
        this.profession = profession;
        this.qualification = qualification;
        this.pathYear = pathYear;
        this.knownLanguage = knownLanguage;
        this.gotra = gotra;
        this.dob = dob;
        this.tob = tob;
        this.pob = pob;
        this.nationality = nationality;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getPin() {
        return pin;
    }

    public String getProfession() {
        return profession;
    }

    public String getQualification() {
        return qualification;
    }

    public String getPathYear() {
        return pathYear;
    }

    public String getKnownLanguage() {
        return knownLanguage;
    }

    public String getGotra() {
        return gotra;
    }

    public String getDob() {
        return dob;
    }

    public String getTob() {
        return tob;
    }

    public String getPob() {
        return pob;
    }

    public String getNationality() {
        return nationality;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
}
