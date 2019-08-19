package com.mobiquityinc.domain;

import com.mobiquityinc.service.PackageService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    Set<Integer> maxCostIndex = new HashSet<>();
    Float maxCost = 0f;

    /**
     * This method calculate the max cost with the items we have
     */
    public void calculateMaxCost(){
        itemList.sort((o1, o2) -> {
            int i = o2.getWeight().compareTo(o1.getWeight());
            if(i==0){
                return o2.getCost().compareTo(o1.getCost());
            }
            return i;
        });
        Response response = new Response();
        PackageService.fillPackage(new Response(), maxWeight, itemList, response);

        maxCostIndex = response.getCostIndex();
        maxCost = response.getCost();

//        for (int i = 0; i < itemList.size(); i++) {
//            Item item = itemList.get(i);
//            Set<Integer> currentIndex = new HashSet<>();
//            Float currentCost = 0f;
//            Float availableWeight = maxWeight;
//            if(item.getWeight()>maxWeight)
//                continue;
//            currentIndex.add(item.getIndex());
//            currentCost += item.getCost();
//            availableWeight -= item.getWeight();
//
//            if(currentCost > maxCost){
//                maxCost = currentCost;
//                maxCostIndex = currentIndex;
//            }
//            int j = i+1;
//            while (j < itemList.size()){
//                for (int k = j; k < itemList.size(); k++) {
//                    Item item1 = itemList.get(k);
//                    if(item1.getWeight()>availableWeight)
//                        continue;
//                    currentIndex.add(item1.getIndex());
//                    currentCost += item1.getCost();
//                    availableWeight -= item1.getWeight();
//                }
//                if(currentCost > maxCost){
//                    maxCost = currentCost;
//                    maxCostIndex = currentIndex;
//                }
//                j++;
//            }
//        }
    }

    public Set<Integer> getMaxCostIndex(){
        return maxCostIndex;
    }

    public Float getMaxCost(){
        return maxCost;
    }
}
