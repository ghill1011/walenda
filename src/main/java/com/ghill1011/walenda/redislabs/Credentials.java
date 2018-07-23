package walenda;

public class Credentials {
  private String hostname;
  private String password;
  private String port;

  public void setHostName(String hostname) {
    this.hostname = hostname;
  }
  public String getHostName() {
    return this.hostname;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPassword() {
    return this.password;
  }
  public void setPort(String port) {
    this.port = port;
  }
  public String getPort() {
    return this.port;
  }
  @Override
  public String toString() {
    return "Hostname: "+ getHostName()+", Password: "+getPassword()+", Port: "+getPort();
  }
}
