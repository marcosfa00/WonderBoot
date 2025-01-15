package com.marcosfa.wonderboot.web.trips.dto;

import com.marcosfa.wonderboot.rest.location.city.dto.CityDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TripCityDTO {

    private Long id;
    private CityDTO city;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal expenses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public void setExpenses(BigDecimal expenses) {
        this.expenses = expenses;
    }
}
