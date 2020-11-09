package ru.sbrf.cu.patterns.decorator;

public final class DataSourceImpl implements DataSource {
  @Override
  public int getInteger() {
    return 15;
  }
}
