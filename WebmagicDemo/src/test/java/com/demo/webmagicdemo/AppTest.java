package com.demo.webmagicdemo;

import static org.junit.Assert.assertTrue;

import lombok.extern.java.Log;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Unit test for simple App.
 */
@Log
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        SimpleDateFormat yYmmDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(yYmmDDHHMMSS.format(new Date(System.currentTimeMillis())));
        System.out.println(UUID.randomUUID());
    }
}
