
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
    "month",
    "year",
    "basic",
    "bonus",
    "hra",
    "total"
})
@Generated("jsonschema2pojo")
public class Salary {

    @JsonProperty("month")
    private String month;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("basic")
    private Double basic;
    @JsonProperty("bonus")
    private Double bonus;
    @JsonProperty("hra")
    private Double hra;
    @JsonProperty("total")
    private Double total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("month")
    public String getMonth() {
        return month;
    }

    @JsonProperty("month")
    public void setMonth(String month) {
        this.month = month;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("basic")
    public Double getBasic() {
        return basic;
    }

    @JsonProperty("basic")
    public void setBasic(Double basic) {
        this.basic = basic;
    }

    @JsonProperty("bonus")
    public Double getBonus() {
        return bonus;
    }

    @JsonProperty("bonus")
    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @JsonProperty("hra")
    public Double getHra() {
        return hra;
    }

    @JsonProperty("hra")
    public void setHra(Double hra) {
        this.hra = hra;
    }

    @JsonProperty("total")
    public Double getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Double total) {
        this.total = total;
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
