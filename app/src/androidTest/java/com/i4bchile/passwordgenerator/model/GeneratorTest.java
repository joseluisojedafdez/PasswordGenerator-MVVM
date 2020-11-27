package com.i4bchile.passwordgenerator.model;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneratorTest extends TestCase {
    Generator test;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        test=new Generator();

    }


    @Test
    public void testGeneratePassword_10() {

        String result=test.generatePassword(10);
        Assert.assertEquals(10,result.length());

    }
}