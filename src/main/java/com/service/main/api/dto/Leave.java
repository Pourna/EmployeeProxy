
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
    "noOfDays",
    "fromDate",
    "toDate",
    "status"
})
@Generated("jsonschema2pojo")
public class Leave {

    @JsonProperty("noOfDays")
    private Double noOfDays;
    @JsonProperty("fromDate")
    private Long fromDate;
    @JsonProperty("toDate")
    private Long toDate;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("noOfDays")
    public Double getNoOfDays() {
        return noOfDays;
    }

    @JsonProperty("noOfDays")
    public void setNoOfDays(Double noOfDays) {
        this.noOfDays = noOfDays;
    }

    @JsonProperty("fromDate")
    public Long getFromDate() {
        return fromDate;
    }

    @JsonProperty("fromDate")
    public void setFromDate(Long fromDate) {
        this.fromDate = fromDate;
    }

    @JsonProperty("toDate")
    public Long getToDate() {
        return toDate;
    }

    @JsonProperty("toDate")
    public void setToDate(Long toDate) {
        this.toDate = toDate;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
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
