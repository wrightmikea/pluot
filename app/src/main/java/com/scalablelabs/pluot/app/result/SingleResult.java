package com.scalablelabs.pluot.app.result;

import com.scalablelabs.pluot.api.entity.Entity;

/**
 *
 */
public class SingleResult<T extends Entity> extends AbstractResult {
  private T _returnedData;

  public SingleResult(Status status, T returnedData) {
    super(status);
    _returnedData = returnedData;
  }

  public T getEntity() {
    return _returnedData;
  }
}
