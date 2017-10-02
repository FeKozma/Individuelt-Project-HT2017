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

import java.util.List;

import com.lambdaworks.redis.api.async.RedisScriptingAsyncCommands;

/**
 * Asynchronous executed commands for Scripting.
 * 
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 3.0
 * @deprecated Use {@literal RedisScriptingAsyncCommands}
 */
@Deprecated
public interface RedisScriptingAsyncConnection<K, V> {
    /**
     * Execute a Lua script server side.
     * 
     * @param script Lua 5.1 script.
     * @param type output type
     * @param keys key names
     * @param <T> expected return type
     * @return script result
     */
    <T> RedisFuture<T> eval(String script, ScriptOutputType type, K... keys);

    /**
     * Execute a Lua script server side.
     * 
     * @param script Lua 5.1 script.
     * @param type the type
     * @param keys the keys
     * @param values the values
     * @param <T> expected return type
     * @return script result
     */
    <T> RedisFuture<T> eval(String script, ScriptOutputType type, K[] keys, V... values);

    /**
     * Evaluates a script cached on the server side by its SHA1 digest
     * 
     * @param digest SHA1 of the script
     * @param type the type
     * @param keys the keys
     * @param <T> expected return type
     * @return script result
     */
    <T> RedisFuture<T> evalsha(String digest, ScriptOutputType type, K... keys);

    /**
     * Execute a Lua script server side.
     * 
     * @param digest SHA1 of the script
     * @param type the type
     * @param keys the keys
     * @param values the values
     * @param <T> expected return type
     * @return script result
     */
    <T> RedisFuture<T> evalsha(String digest, ScriptOutputType type, K[] keys, V... values);

    /**
     * Check existence of scripts in the script cache.
     * 
     * @param digests script digests
     * @return RedisFuture&lt;List&lt;Boolean&gt;&gt; array-reply The command returns an array of integers that correspond to
     *         the specified SHA1 digest arguments. For every corresponding SHA1 digest of a script that actually exists in the
     *         script cache, an 1 is returned, otherwise 0 is returned.
     */
    RedisFuture<List<Boolean>> scriptExists(String... digests);

    /**
     * Remove all the scripts from the script cache.
     * 
     * @return RedisFuture&lt;String&gt; simple-string-reply
     */
    RedisFuture<String> scriptFlush();

    /**
     * Kill the script currently in execution.
     * 
     * @return RedisFuture&lt;String&gt; simple-string-reply
     */
    RedisFuture<String> scriptKill();

    /**
     * Load the specified Lua script into the script cache.
     * 
     * @param script script content
     * @return RedisFuture&lt;String&gt; bulk-string-reply This command returns the SHA1 digest of the script added into the
     *         script cache.
     */
    RedisFuture<String> scriptLoad(V script);
}