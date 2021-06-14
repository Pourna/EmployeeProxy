
package com.service.main.api.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "houseNumber",
    "streetName",
    "district",
    "state",
    "country",
    "pinCode"
})
@Generated("jsonschema2pojo")
public class Address {

    @JsonProperty("houseNumber")
    private Integer houseNumber;
    @JsonProperty("streetName")
    private String streetName;
    @JsonProperty("district")
    private String district;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    private String country;
    @JsonProperty("pinCode")
    private Integer pinCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("houseNumber")
    public Integer getHouseNumber() {
        return houseNumber;
    }

    @JsonProperty("houseNumber")
    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    @JsonProperty("streetName")
    public String getStreetName() {
        return streetName;
    }

    @JsonProperty("streetName")
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @JsonProperty("district")
    public String getDistrict() {
        return district;
    }

    @JsonProperty("district")
    public void setDistrict(String district) {
        this.district = district;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("pinCode")
    public Integer getPinCode() {
        return pinCode;
    }

    @JsonProperty("pinCode")
    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
