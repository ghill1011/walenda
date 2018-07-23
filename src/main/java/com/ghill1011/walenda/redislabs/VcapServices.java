package walenda;

import java.util.Arrays;
import com.google.gson.annotations.SerializedName;

public class VcapServices {
  private RedisCloud[] rediscloud;

  public RedisCloud[] getRedisCloud() {
    return rediscloud;
  }
  public void setRedisCloud(RedisCloud[] rediscloud) {
    this.rediscloud = rediscloud;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (getRedisCloud()!=null) {
          sb.append("Redis Cloud:  "+Arrays.toString(getRedisCloud()));
        }    return sb.toString();
  }
}
