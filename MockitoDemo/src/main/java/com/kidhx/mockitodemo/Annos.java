package com.kidhx.mockitodemo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import javax.xml.bind.SchemaOutputResolver;

import static org.mockito.Mockito.when;

/**
 * @Author wb-hx347246
 * @Date 2018/5/14 16:18
 */
//@RunWith(MockitoJUnitRunner.class)
public class Annos {

    @Spy
    @InjectMocks
    private MockAndSpy spy;

    @Mock
    private InnerObject innerObject;

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

  /*  @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }*/

    @Test
    public void TestMethod() {
        MockitoAnnotations.initMocks(MockAndSpy.class);
        when(spy.sayHello()).thenReturn("mock");

        String field = spy.innerObject.field;

        System.out.println(field);

        System.out.println(spy.sayHello());


    }
}
