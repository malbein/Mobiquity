package com.mobiquityinc.packer;

import com.mobiquityinc.domain.Package;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.service.PackageFileReaderService;

import java.util.Iterator;
import java.util.List;

public class Packer {

  private Packer() {
  }

  public static String pack(String filePath) throws APIException {

    //Read file
    List<Package> packageList = PackageFileReaderService.read(filePath);

    //Calculate Max Cost of the package
    packageList = calculateMaxCost(packageList);

    //Print results;
    return printResult(packageList);
  }

  private static List<Package> calculateMaxCost(List<Package> packageList){
    packageList.forEach(aPackage -> {
      aPackage.calculateMaxCost();
    });
    return packageList;
  }

  private static String printResult(List<Package> packageList){
    StringBuffer buffer = new StringBuffer();
    packageList.forEach(aPackage -> {
      if(aPackage.getMaxCostIndex().isEmpty()){
        buffer.append("-");
      }
      for(Iterator<Integer> iterator = aPackage.getMaxCostIndex().iterator();iterator.hasNext();){
        buffer.append(iterator.next().toString());
        if(iterator.hasNext()){
          buffer.append(",");
        }
      }
      buffer.append("\n");
    });
    System.out.println(buffer.toString());
    return buffer.toString();
  }
}
