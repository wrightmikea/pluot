/**
 Copyright (c) 2013 Michael A. Wright.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
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
