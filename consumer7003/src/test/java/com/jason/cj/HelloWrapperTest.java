package com.jason.cj;

import com.jason.cj.service.FeignService;
import com.jason.cj.wrapper.HelloWrapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author jiancheng
 * @date 2022/9/3 8:45 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloWrapperTest {
    //直接mock掉远程接口服务
    @Mock
    private FeignService feignService;

    @InjectMocks
    HelloWrapper helloWrapper;

    //mock远程的调用方法的，构造自己需要的各种分支情况，从而验证自己的代码逻辑是否正确
    @Before
    public void setUp(){
        Mockito.when(feignService.hello(Mockito.any())).thenAnswer( a -> {
           String param = (String) a.getArguments()[0] ;
           if(param == null){
               throw new RuntimeException("mock call exception!");
           }else if("111".equals(param)){
               return "mock-111";
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
        String content = "111";
        result = helloWrapper.sayHello(content);
        assertEquals(result,"mock-111" + "-wrapper");
    }
}
