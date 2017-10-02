package com.API.JavaAPI2.redisConnection;

import com.lambdaworks.redis.*;

/*


import com.hubspot.dropwizard.guice.GuiceBundle;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;


*/public class RedisConnection {

	RedisConnection(String[] args)
	{
		// Syntax: redis://[password@]host[:port][/databaseNumber]
        RedisClient redisClient = RedisClient.create("redis://password@localhost:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();

        System.out.println("Connected to Redis");

        connection.close();
        redisClient.shutdown();
	};
}
