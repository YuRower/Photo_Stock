package service.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import ua.univer.photostock.model.ImageResource;

@Interceptor
public class ImageResourceInterceptor {

    @AroundInvoke
    public Object aroundProcessImageResource(InvocationContext ic)
            throws Exception {
        try (ImageResource imageResource = (ImageResource) ic
                .getParameters()[0]) {
            return ic.proceed();
        }
    }
}