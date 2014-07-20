/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.openhft.collect.hash;


/**
 * Common configuration for factories of hash containers with {@code Object} keys.
 *
 * <p>Currently {@code ObjHashFactory} allows to specify only if {@code null} keys are allowed
 * or disallowed in hash containers, constructed by the factory. This is a performance hint:
 * hash containers might, but aren't required to throw {@link NullPointerException} on putting
 * {@code null} key, if {@code null} key is disallowed.
 *
 * <p>By default, {@code null} key is allowed.
 *
 * @param <T> the concrete factory type which extends this interface
 */
public interface ObjHashFactory<T extends ObjHashFactory<T>> extends HashContainerFactory<T> {

    /**
     * Returns {@code true} if {@code null} key is allowed, {@code false} otherwise.
     *
     * <p>Default: {@code true}.
     *
     * @return {@code true} if null key is allowed, {@code false} otherwise
     */
    boolean isNullKeyAllowed();

    /**
     * Returns a copy of this factory with {@code null} key allowed or disallowed, as specified.
     *
     * <p>This is a performance hint: hash containers might, but aren't required to throw
     * {@link NullPointerException} on putting {@code null} key, if {@code null} key is disallowed.
     */
    T withNullKeyAllowed(boolean nullKeyAllowed);
}