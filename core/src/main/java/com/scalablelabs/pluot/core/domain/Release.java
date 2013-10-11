package com.scalablelabs.pluot.core.domain;


import com.scalablelabs.pluot.api.entity.AbstractEntity;
import com.scalablelabs.pluot.api.entity.Entity;

/**
 *
 */
public class Release extends AbstractEntity implements Entity {

  private String _name;
  private String _release;
  private String _source;

  public Release(String name, String release, String source) {
    _name = name;
    _release = release;
    _source = source;
  }

  public String getName() {
    return _name;
  }

  public String getRelease() {
    return _release;
  }

  public String getSource() {
    return _source;
  }

  public void setName(String name) {
    _name = name;
  }

  public void setRelease(String release) {
    _release = release;
  }

  public void setSource(String source) {
    _source = source;
  }
}

