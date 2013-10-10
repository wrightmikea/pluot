package com.scalablelabs.pluot.repo;

import com.scalablelabs.pluot.api.entity.AbstractEntity;
import com.scalablelabs.pluot.api.entity.Entity;

/**
 *
 */
class EntityImpl extends AbstractEntity implements Entity {
  private String _id;
  public EntityImpl(String id) {
    _id = id;
  }
  public String getId() {
    return _id;
  }
}
