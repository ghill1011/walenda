package com.ghill1011.walenda.redislabs;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class RedisCloud {

  private String name;
  private String instance_name;
  private String binding_name;
  private Credentials credentials;
  private String syslog_drain_url;
  private List<String> volume_mounts; //ArrayList maybe?
  private String label;
  private String provider;
  private String plan;
  private List<String> tags;  //ArrayList maybe?

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getInstanceName() {
    return instance_name;
  }
  public void setInstanceName(String instance_name) {
    this.instance_name = instance_name;
  }
  public String getBindingName() {
    return binding_name;
  }
  public void setBindingName(String binding_name) {
    this.binding_name = binding_name;
  }
  public Credentials getCredentials() {
    return credentials;
  }
  public void setCredentials(Credentials credentials) {
    this.credentials = credentials;
  }
  public List<String> getVolumeMounts() {
    return volume_mounts;
  }
  public void setVolumeMounts(List<String> volume_mounts) {
    this.volume_mounts = volume_mounts;
  }
  public void setLabel(String label) {
    this.label = label;
  }
  public String getLabel() {
    return label;
  }
  public void setProvider(String provider) {
    this.provider = provider;
  }
  public String getProvider() {
    return provider;
  }
  public void setPlan(String plan) {
    this.plan = plan;
  }
  public String getPlan() {
    return plan;
  }
  public List<String> getTags() {
    return tags;
  }
  public void setTags(List<String> tags) {
    this.tags = tags;
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("*** REDIS CLOUD DETAILS ***\n");
    sb.append("Name: "+getName()+"\n");
    sb.append("Instance Name: "+getInstanceName()+"\n");
    sb.append("Binding Name: "+getBindingName()+"\n");
    if (getCredentials() != null) {
      sb.append("Credentials: "+getCredentials()+"\n");
    }
    if (getVolumeMounts() != null) {
      sb.append("Volume Mounts: "+Arrays.toString(getVolumeMounts().toArray())+"\n");
    }
    sb.append("Label: "+getLabel()+"\n");
    sb.append("Provider: "+getProvider()+"\n");
    sb.append("Plan: "+getPlan()+"\n");
    if (getTags() != null) {
      sb.append("Tags: "+Arrays.toString(getTags().toArray())+"\n");
    }
    return sb.toString();
  }
}
