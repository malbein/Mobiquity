package com.mobiquityinc.domain;

import com.mobiquityinc.service.PackageService;

import java.util.List;
import java.util.Set;

/**
 * This represents the package you send to a friend (is one line in the document we read)
 */
public class Package {

    private Float maxWeight;

    private List<Item> itemList;

    public Package(Float maxWeight, List<Item> itemList) {
        this.maxWeight = maxWeight;
        this.itemList = itemList;
    }

    public Float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    /** LOGIC **/

    private Response response = new Response();

    /**
     * This method calculate the max cost with the items we have
     */
    public void calculateMaxCost(){
        PackageService.fillPackage(new Response(), maxWeight, itemList, response);
    }

    public Set<Integer> getMaxCostIndex(){
        return response.getCostIndex();
    }

    public Float getMaxCost(){
        return response.getCost();
    }
}
