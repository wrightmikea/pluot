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

