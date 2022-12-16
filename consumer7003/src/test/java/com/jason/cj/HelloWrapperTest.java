package com.jason.cj;

import com.jason.cj.service.FeignService;
import com.jason.cj.service.HelloWrapper;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author jiancheng
 * @date 2022/9/3 8:45 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloWrapperTest {
    @Mock
    private FeignService feignService;

    @InjectMocks
    HelloWrapper helloWrapper;

    @Before
    public void setUp(){
        Mockito.when(feignService.hello(Mockito.any())).thenAnswer( a -> {
           String param = (String) a.getArguments()[0] ;
           if(param == null){
               throw new RuntimeException("mock call exception!");
           }
           return "mock data";
        });
    }

    @Test(expected = Exception.class)
    public void sayHelloTestException(){
        String result = helloWrapper.sayHello(null);
    }

    @Test
    public void sayHelloTest(){
        String result;
        result = helloWrapper.sayHello("xxx");

        Assert.assertTrue(StringUtils.isNotBlank(result));

    }

}
