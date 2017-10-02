/*
 * Copyright 2011-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.API.redis;

import com.lambdaworks.redis.api.async.RedisHLLAsyncCommands;

/**
 * Asynchronous executed commands for HyperLogLog (PF* commands).
 * 
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 3.0
 * @deprecated Use {@link RedisHLLAsyncCommands}
 */
@Deprecated
public interface RedisHLLAsyncConnection<K, V> {
    /**
     * Adds the specified elements to the specified HyperLogLog.
     *
     * @param key the key
     * @param value the value
     * @param moreValues more values
     *
     * @return RedisFuture&lt;Long&gt; integer-reply specifically:
     *
     *         1 if at least 1 HyperLogLog internal register was altered. 0 otherwise.
     */
    RedisFuture<Long> pfadd(K key, V value, V... moreValues);

    /**
     * Merge N different HyperLogLogs into a single one.
     *
     * @param destkey the destination key
     * @param sourcekey the source key
     * @param moreSourceKeys more source keys
     *
     * @return RedisFuture&lt;String&gt; simple-string-reply The command just returns {@code OK}.
     */
    RedisFuture<String> pfmerge(K destkey, K sourcekey, K... moreSourceKeys);

    /**
     * Return the approximated cardinality of the set(s) observed by the HyperLogLog at key(s).
     *
     * @param key the key
     * @param moreKeys more keys
     *
     * @return RedisFuture&lt;Long&gt; integer-reply specifically:
     *
     *         The approximated number of unique elements observed via {@code PFADD}.
     */
    RedisFuture<Long> pfcount(K key, K... moreKeys);

}