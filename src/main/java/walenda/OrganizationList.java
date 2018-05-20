package walenda;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class OrganizationList {
  /*private String organizations;

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


  public OrganizationList(String partner) {
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
  
  public void add (String organization) {
    // get a connection to persistence
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    // add the organization to the list
    jedis.lpush("ogranizations", organization);

    // release the persistence connection
    poolManager.close();
  }

  public void delete (String organization) {
    // get a connection to persistence
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    // set the account list
    jedis.del(organization+".members");
    jedis.lrem("ogranizations", 0, organization);

    // release the persistence connection
    poolManager.close();
  }

}
