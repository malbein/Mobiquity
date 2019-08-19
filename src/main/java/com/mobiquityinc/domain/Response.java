package com.mobiquityinc.domain;

import java.util.HashSet;
import java.util.Set;

public class Response {
    private Set<Integer> costIndex = new HashSet<>();
    private Float cost = 0f;

    public Set<Integer> getCostIndex() {
        return costIndex;
    }

    public void setCostIndex(Set<Integer> costIndex) {
        this.costIndex = costIndex;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
