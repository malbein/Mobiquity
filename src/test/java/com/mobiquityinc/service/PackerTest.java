package com.mobiquityinc.service;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.Packer;
import org.junit.Assert;
import org.junit.Test;

/**
 * This test to emulate how is going to be call from the main program
 */
public class PackerTest {

    @Test
    public void main() throws APIException {
        String expected = "4\n-\n2,7\n8,9\n";
        String output = Packer.pack("src/test/resources/multiple.txt");
        Assert.assertEquals(expected,output);
    }

}
