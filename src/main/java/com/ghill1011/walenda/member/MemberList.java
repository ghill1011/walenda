package com.ghill1011.walenda.member;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.ghill1011.walenda.redislabs.PoolManager;

public class MemberList {
  private String memberlist;
  private String partner;

  public MemberList() {
    // get a connection to persistence
    PoolManager poolManager = new PoolManager();
    Jedis jedis = poolManager.getJedis();

    // set the account list
    jedis.lpush("BankOfAmerica.members", "1234567890123456789");
    jedis.lpush("BankOfAmerica.members", "9123456789012345678");
    jedis.lpush("BankOfAmerica.members", "8912345678901234567");
    jedis.lpush("BankOfAmerica.members", "7891234567890123456");
    jedis.lpush("BankOfAmerica.members", "6789123456789012345");
    jedis.lpush("BankOfAmerica.members", "5678912345678901234");
    jedis.lpush("BankOfAmerica.members", "4567891234567890123");

    jedis.lpush("Citibank.members", "1234567890123456789");
    jedis.lpush("Citibank.members", "9123456789012345678");
    jedis.lpush("Citibank.members", "8912345678901234567");
    jedis.lpush("Citibank.members", "7891234567890123456");

    System.out.println("Citibank member list length: "+jedis.llen("Citibank.members"));

    // release the persistence connection
    poolManager.close();
  }

  public MemberList(String partner) {
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

  public void setMemberList(String memberlist) {
    this.memberlist = memberlist;
  }
  public String getMemberList() {
    return this.memberlist;
  }
  public void setPartner(String partner) {
    this.partner = partner;
  }
  public String getPartner() {
    return this.partner;
  }

}
