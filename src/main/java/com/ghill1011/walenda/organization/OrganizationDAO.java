package com.ghill1011.walenda.organization;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class OrganizationDAO {
  public static final String key = "organizations";

  public static List<String> getAll() {
    // get a connection to jedis
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    // get the list of organizations
    List<String> list = jedis.lrange(key, 0, -1);

    // release the jedis connection
    poolManager.close();
    return list;
  }

  public static void insert(String organization) {
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    jedis.lpush(key, organization);

    poolManager.close();
    return;
  }

  public static void delete(String organization) {
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    // remove the members of the organization and the organization
    // this feels a little bit like cheating but since I konw the construct of the repository this is just simpler
    jedis.del(organization+".members");
    jedis.lrem(key, 0, organization);

    poolManager.close();
    return;
  }

}
