package ru.sbrf.cu.patterns.factorymethod;


public class ConfigurationFile implements Configuration {
  @Override
  public String params() {
    return "params from file";
  }
}
