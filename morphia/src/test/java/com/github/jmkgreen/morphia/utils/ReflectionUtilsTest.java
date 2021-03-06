/**
 * 
 */
package com.github.jmkgreen.morphia.utils;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

import com.github.jmkgreen.morphia.TestBase;
import com.github.jmkgreen.morphia.annotations.Id;
import com.github.jmkgreen.morphia.annotations.Index;
import com.github.jmkgreen.morphia.annotations.Indexes;

/**
 * @author Uwe Schaefer, (us@thomas-daily.de)
 * @author Scott Hernandez
 */
public class ReflectionUtilsTest extends TestBase
{

    /**
     * Test method for
     * {@link com.github.jmkgreen.morphia.utils.ReflectionUtils#implementsInterface(java.lang.Class, java.lang.Class)}
     * .
     */
    @Test
	public void testImplementsInterface() {
        Assert.assertTrue(ReflectionUtils.implementsInterface(ArrayList.class, List.class));
        Assert.assertTrue(ReflectionUtils.implementsInterface(ArrayList.class, Collection.class));
        Assert.assertFalse(ReflectionUtils.implementsInterface(Set.class, List.class));
    }
    
    @Test
    public void testInheritedClassAnnotations() {
    	List<Indexes> annotations = ReflectionUtils.getAnnotations(Foobie.class, Indexes.class);
    	Assert.assertEquals(2, annotations.size());
    	Assert.assertTrue(ReflectionUtils.getAnnotation(Foobie.class, Indexes.class) instanceof Indexes);
    }

    @Indexes(@Index("id"))
    private static class Foo {
    	@Id int id;
    }
    
    @Indexes(@Index("test"))
    private static class Foobie extends Foo {
    	String test;
    }
}
