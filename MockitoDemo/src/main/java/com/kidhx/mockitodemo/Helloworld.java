package com.kidhx.mockitodemo;

import org.mockito.InOrder;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author wb-hx347246
 * @Date 2018/5/14 14:31
 */
public class Helloworld {

    public static void main(String[] args) {
        List mock = mock(List.class);

        mock.add("one");

//        verify(mock,never()).add("one");

        doThrow(new IllegalMonitorStateException("error occur")).when(mock).clear();

        verify(mock,times(3)).add("one");


//        verifyZeroInteractions(mock);
    }
}
