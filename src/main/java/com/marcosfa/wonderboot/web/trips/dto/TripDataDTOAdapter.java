package com.marcosfa.wonderboot.web.trips.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TripDataDTOAdapter {
    private Long id;
    private String name;
    private int totalCities;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalDays;
    private BigDecimal totalCost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCities() {
        return totalCities;
    }

    public void setTotalCities(int totalCities) {
        this.totalCities = totalCities;
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

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
