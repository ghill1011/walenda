package walenda;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class PartnerList {
  private String partnerlist;
/*
  public PartnerList(String seed) {
    // get a connection to persistence
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    // set the account list
    jedis.lpush("Partners", "BankOfAmerica");
    jedis.lpush("Partners", "Citibank");

    // release the persistence connection
    poolManager.close();
  }


  public Bank(String partner) {
    this.partner = partner;

    // get a connection to persistence
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    // get the account list
    List<String> list = jedis.lrange(partner+".members", 0, jedis.llen(partner+".members"));
    String ml = "[";
    for (String item:list) {
      ml += item+",";
    }
    ml = ml.replaceAll(",+$",""); //trim trailing ","
    ml +="]";
    setMemberList(ml);
    System.out.println(ml);

    // release the persistence connection
    poolManager.close();
  }
  */

  public void addPartner (String partner) {
    // get a connection to persistence
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    // set the account list
    jedis.lpush("Partners", partner);

    // release the persistence connection
    poolManager.close();
  }

  public void deletePartner (String partner) {
    // get a connection to persistence
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    // set the account list
    jedis.del(partner+".members");
    jedis.lrem("Partners", 0, partner);

    // release the persistence connection
    poolManager.close();
  }

}
