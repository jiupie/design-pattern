package com.wl.dubbo;

import java.util.Arrays;
import java.util.List;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/8/12
 */
public class DubboFilterDemo {

    public static void main(String[] args) {
        Invoker next = (context) -> {
            return "end filter channel";
        };
        List<Filter> filterList = Arrays.asList(new TestFilter1(), new TestFilter2());

        for (int i = filterList.size() - 1; i >= 0; i--) {
            int finalI = i;
            Invoker finalInvokerNext = next;
            next = (context) -> filterList.get(finalI).filter(context, finalInvokerNext);
        }
        System.out.println(next.invoke(new InvocationContext()));
    }

}

interface Invoker {
    Object invoke(InvocationContext invocationContext);
}


class InvocationContext {

}

interface Filter {
    Object filter(InvocationContext invocationContext, Invoker invoker);
}

class TestFilter1 implements Filter {

    @Override
    public Object filter(InvocationContext invocationContext, Invoker invoker) {
        System.out.println("i am testFilter 1");
        return invoker.invoke(invocationContext);
    }
}

class TestFilter2 implements Filter {

    @Override
    public Object filter(InvocationContext invocationContext, Invoker invoker) {
        System.out.println("i am testFilter 2");
        return invoker.invoke(invocationContext);
    }
}


