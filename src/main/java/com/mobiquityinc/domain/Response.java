package com.mobiquityinc.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * This is a object used to handle the information we need of the packages to be return
 */
public class Response {
    private Set<Integer> costIndex = new HashSet<>();
    private Float cost = 0f;
    private Float weight = 0f;

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

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
