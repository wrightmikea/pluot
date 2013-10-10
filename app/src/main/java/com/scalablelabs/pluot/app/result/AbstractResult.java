package com.scalablelabs.pluot.app.result;

/**
 *
 */
public abstract class AbstractResult {
  private Status _status;

  protected AbstractResult(Status status) {
    _status = status;
  }

  public Status getStatus() {
    return _status;
  }

}

