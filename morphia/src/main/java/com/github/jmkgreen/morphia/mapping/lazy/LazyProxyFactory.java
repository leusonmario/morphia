/**
 *
 */
package com.github.jmkgreen.morphia.mapping.lazy;

import com.github.jmkgreen.morphia.Key;
import java.util.Collection;
import java.util.Map;

/**
 * @author uwe schaefer
 */
@SuppressWarnings("unchecked")
public interface LazyProxyFactory {
    <T> T createProxy(Class<T> targetClass, final Key<T> key,
                      final DatastoreProvider p);

    <T extends Collection> T createListProxy(T listToProxy,
                                             Class referenceObjClass, boolean ignoreMissing, DatastoreProvider p);

    <T extends Map> T createMapProxy(final T mapToProxy,
                                     final Class referenceObjClass, final boolean ignoreMissing,
                                     final DatastoreProvider p);

}
