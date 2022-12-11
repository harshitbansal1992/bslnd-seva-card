package com.bslnd.seva.card.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocalDataModel extends Sevadar {
    private final String userPhoto;

    public LocalDataModel(final String uuid, final String fullName,
                          final String fatherName, final String gender,
                          final String email, final String phone, final String address,
                          final String state, final String city, final String pin,
                          final String profession, final String qualification, final String pathYear,
                          final String knownLanguage, final String gotra, final String dob,
                          final String tob, final String pob, final String nationality,
                          @JsonProperty("userPhoto") final String userPhoto) {
        super(uuid, fullName, fatherName, gender, email, phone,
                address, state, city, pin, profession, qualification,
                pathYear, knownLanguage, gotra,
                dob, tob, pob, nationality);

        this.userPhoto = userPhoto;
    }

    public String getPathToProfilePic() {
        return userPhoto;
    }
}
