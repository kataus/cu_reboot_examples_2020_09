package ru.sbrf.cu.patterns.factorymethod;


public class ConfigurationDB implements Configuration {
  @Override
  public String params() {
    return "params from DB";
  }
}
