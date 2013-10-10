package com.scalablelabs.pluot.api.entity;

/**
 *
 */
public abstract class AbstractEntity implements Entity {
  private int _key = -1;

  @Override
  public int getKey() {
    return _key;
  }

  @Override
  public void setKey(int key) {
    _key = key;
  }
}