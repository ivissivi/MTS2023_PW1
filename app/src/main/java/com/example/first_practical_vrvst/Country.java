package com.example.first_practical_vrvst;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("name")
    private Name name;

    public Name getName() {
        return name;
    }

    public class Name {
        @SerializedName("common")
        private String common;

        public String getCommon() {
            return common;
        }

        @SerializedName("official")
        private String official;

        public String getOfficial() {
            return official;
        }
    }
}



