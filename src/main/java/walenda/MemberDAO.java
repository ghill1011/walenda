package walenda;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class MemberDAO {
  public static final String key = "members";

  public static List<String> getAll(String organization) {
    // get a connection to jedis
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    // get the list of organizations
    List<String> list = jedis.lrange(organization+"."+key, 0, -1);

    // release the jedis connection
    poolManager.close();
    return list;
  }

  public static void insert(String organization, String member) {
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    jedis.lpush(organization+"."+key, member);

    poolManager.close();
    return;
  }

  public static void delete(String organization, String member) {
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    // remove the members of the organization and the organization
    jedis.lrem(organization+"."+key, 0, member);

    poolManager.close();
    return;
  }
}
