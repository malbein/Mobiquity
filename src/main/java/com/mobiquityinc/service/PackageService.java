package com.mobiquityinc.service;

import com.mobiquityinc.domain.Item;
import com.mobiquityinc.domain.Response;

import java.util.List;

/**
 * Service to fill the package with the items
 */
public class PackageService {

    public static void fillPackage(Response current, Float maxWeight, List<Item> items, Response base){
        //Validate the current values with the one I will send
        if(current.getCost() > base.getCost() || (current.getCost().equals(base.getCost()) && current.getWeight() < base.getWeight())){
            base.setCost(current.getCost());
            base.setWeight(current.getWeight());
            base.getCostIndex().clear();
            base.getCostIndex().addAll(current.getCostIndex());
        }
        //Run logic in a recursive way so we can check all posibilities and the code is cleaner
        if(!items.isEmpty()){
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                if(item.getWeight() <= maxWeight){
                    current.getCostIndex().add(item.getIndex());
                    current.setCost(current.getCost() + item.getCost());
                    current.setWeight(current.getWeight() + item.getWeight());
                    fillPackage(current, maxWeight - item.getWeight(), items.subList(i+1, items.size()), base);
                    current.getCostIndex().remove(item.getIndex());
                    current.setCost(current.getCost() - item.getCost());
                    current.setWeight(current.getWeight() - item.getWeight());
                }
            }
        }

    }
}
