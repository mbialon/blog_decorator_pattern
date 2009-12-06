package dp.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Enhancers {

  public static Coffee enhance(final Coffee coffee, final Coffee enhancer) {
    MethodInterceptor interceptor = new MethodInterceptor() {
      public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Class<? extends Coffee> enhancerClass = enhancer.getClass();
        Method m = enhancerClass.getMethod(method.getName(), method.getParameterTypes());
        Object target = m.getDeclaringClass() == enhancerClass ? enhancer : coffee;
        return method.invoke(target, objects);
      }
    };

    Enhancer e = new Enhancer();
    e.setSuperclass(Coffee.class);
    e.setCallback(interceptor);

    return (Coffee) e.create(new Class[] { String.class }, new Object[] { "" });
  }
}
