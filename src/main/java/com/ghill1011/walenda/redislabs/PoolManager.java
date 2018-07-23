package com.ghill1011.walenda.redislabs;

import java.util.Arrays;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PoolManager {
  private JedisPool pool = null;
  private Jedis jedis = null;

  public PoolManager() {
      String vcap_services = System.getenv("VCAP_SERVICES");
      if (vcap_services == null || vcap_services.length() <= 0) return; // log it
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      VcapServices vcap = gson.fromJson(vcap_services, VcapServices.class);

      RedisCloud[] rediscloud = vcap.getRedisCloud();

      for (RedisCloud rc:rediscloud) {
        pool = new JedisPool(new JedisPoolConfig(),
                rc.getCredentials().getHostName(),
                Integer.parseInt(rc.getCredentials().getPort()),
                Protocol.DEFAULT_TIMEOUT,
                rc.getCredentials().getPassword());
        break; // I just want one.  Will change when needed
      }
      if (pool == null)  return;
      jedis = pool.getResource();
  }

  public Jedis getJedis() {
    return jedis;
  }

  public void close() {
    pool.returnResource(jedis);
    pool.close();
  }

}
