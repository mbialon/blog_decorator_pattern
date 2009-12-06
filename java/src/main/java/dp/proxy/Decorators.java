package dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Decorators {

  public static Coffee decorate(final Coffee coffee, final Coffee decorator) {
    InvocationHandler handler = new InvocationHandler() {
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<? extends Coffee> decoratorClass = decorator.getClass();
        Method m = decoratorClass.getMethod(method.getName(), method.getParameterTypes());
        Coffee target = m.getDeclaringClass() == decoratorClass ? decorator : coffee;
        return method.invoke(target, args);
      }
    };
    return (Coffee) Proxy.newProxyInstance(Coffee.class.getClassLoader(), new Class[] { Coffee.class }, handler);
  }
}
