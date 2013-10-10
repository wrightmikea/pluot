package com.scalablelabs.pluot.app.status;

import org.joda.time.DateTime;

/**
 *
 */
public class Statistic {
  private Integer _count;
  private DateTime _lastChangeAt;
  private String _name;

  public Statistic(String name, Integer initialCount, DateTime maybeLastChangeAt) {
    _name = name;
    _count = initialCount;
    _lastChangeAt = maybeLastChangeAt;
  }

  public void markNewEvent() {
    ++ _count;
    _lastChangeAt = new DateTime();
  }

  public Integer getCount() {
    return _count;
  }

  public String getName() {
    return _name;
  }

  public DateTime getLastChangeAt() {
    return _lastChangeAt;
  }
}
