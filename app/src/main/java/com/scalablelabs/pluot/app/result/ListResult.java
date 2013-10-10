package com.scalablelabs.pluot.app.result;

import com.scalablelabs.pluot.api.entity.Entity;

import java.util.List;

/**
 *
 */
public class ListResult<T extends Entity> extends AbstractResult {

  private List<T> _returnedData;

  public ListResult(Status status, List<T> returnedData) {
    super(status);
    _returnedData = returnedData;
  }

  public List<T> getEntities() {
    return _returnedData;
  }
}

