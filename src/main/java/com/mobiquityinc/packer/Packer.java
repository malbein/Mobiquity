package com.mobiquityinc.packer;

import com.mobiquityinc.domain.Package;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.service.PackageFileReaderService;

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
    packageList.forEach(aPackage -> {
      System.out.println(aPackage.getMaxCostIndex());
    });
    return null;
  }
}
