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

import com.scalablelabs.pluot.api.crud.Collection;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Releases implements Collection<Release> {

  List<Release> _releases;

  public Releases() {
    _releases = new ArrayList<>();
  }

  public void add(Release release) {
    _releases.add(release);
  }

  public Release get(int id) {
    for (Release release : _releases) {
      if (release.getKey() == id) {
        return release;
      }
    }
    return null;
  }

  public List<Release> getAll() {
    return _releases;
  }

  public void delete(int id) {
    for (Release release : _releases) {
      if (release.getKey() == id) {
        _releases.remove(release);
        break;
      }
    }
  }

  public void update(int id, Release update) {
    for (Release release : _releases) {
      if (release.getKey() == id) {
        release.setName(update.getName());
        release.setRelease(update.getRelease());
        release.setSource(update.getSource());
      }
    }
  }
}
