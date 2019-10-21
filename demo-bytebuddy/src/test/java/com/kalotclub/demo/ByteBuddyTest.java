package com.kalotclub.demo;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Date: 2019-08-21 23:07
 *
 * @author hongchen.cao
 */
public class ByteBuddyTest {
    @Test
    public void byteBuddyTest() throws IllegalAccessException, InstantiationException {
        Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello World!"))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded();

        assertThat(dynamicType.newInstance().toString(), is("Hello World!"));
    }
}
