package dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Decorators {

    public static Coffee decorate(final Coffee coffee, final Coffee decorator) {
        return (Coffee) Proxy.newProxyInstance(Coffee.class.getClassLoader(), new Class[]{Coffee.class}, new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Coffee target = coffee;
                Method m = decorator.getClass().getMethod(method.getName(), method.getParameterTypes());
                if (m.getDeclaringClass() == decorator.getClass()) {
                    target = decorator;
                }
                return method.invoke(target, args);
            }
        });
    }
}
