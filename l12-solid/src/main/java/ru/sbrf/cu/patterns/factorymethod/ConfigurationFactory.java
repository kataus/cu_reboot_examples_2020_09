package ru.sbrf.cu.patterns.factorymethod;

class ConfigurationFactory {

  static Configuration getConfiguration(String param) {
    if ("file".equals(param)) {
      return new ConfigurationFile();
    }
    if ("db".equals(param)) {
      return new ConfigurationDB();
    }
    throw new IllegalArgumentException("unknown param:" + param);
  }
}
