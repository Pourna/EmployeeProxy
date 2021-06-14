
package com.service.main.api.dto;

import java.util.HashMap;
import java.util.List;
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
    "id",
    "firstName",
    "lastName",
    "age",
    "gender",
    "contactNumber",
    "emergencyContact",
    "currentAddress",
    "permanentAddress",
    "leaves",
    "salaries"
})
@Generated("jsonschema2pojo")
public class Employee {

    @JsonProperty("id")
    private String id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("contactNumber")
    private Integer contactNumber;
    @JsonProperty("emergencyContact")
    private Integer emergencyContact;
    @JsonProperty("currentAddress")
    private Address currentAddress;
    @JsonProperty("permanentAddress")
    private Address permanentAddress;
    @JsonProperty("leaves")
    private List<Leave> leaves = null;
    @JsonProperty("salaries")
    private List<Salary> salaries = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("contactNumber")
    public Integer getContactNumber() {
        return contactNumber;
    }

    @JsonProperty("contactNumber")
    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    @JsonProperty("emergencyContact")
    public Integer getEmergencyContact() {
        return emergencyContact;
    }

    @JsonProperty("emergencyContact")
    public void setEmergencyContact(Integer emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    @JsonProperty("currentAddress")
    public Address getCurrentAddress() {
        return currentAddress;
    }

    @JsonProperty("currentAddress")
    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    @JsonProperty("permanentAddress")
    public Address getPermanentAddress() {
        return permanentAddress;
    }

    @JsonProperty("permanentAddress")
    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    @JsonProperty("leaves")
    public List<Leave> getLeaves() {
        return leaves;
    }

    @JsonProperty("leaves")
    public void setLeaves(List<Leave> leaves) {
        this.leaves = leaves;
    }

    @JsonProperty("salaries")
    public List<Salary> getSalaries() {
        return salaries;
    }

    @JsonProperty("salaries")
    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
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
