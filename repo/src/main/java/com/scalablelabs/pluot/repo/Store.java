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
package com.scalablelabs.pluot.repo;

import com.scalablelabs.pluot.api.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class Store<T extends Entity> {

  private static int _nextKey = 100;

  Map<Integer, T> _store = new HashMap<>();

  public List<T> getEntities() {
      List<T> entities = new ArrayList<>();
      for (Integer key : _store.keySet()) {
         entities.add(_store.get(key));
      }
      return entities;
  }

  public int storeEntity(T entity) {
    int key = nextKey();
      entity.setKey(key);
    _store.put(key, entity);
    return key;
  }

  public T getEntity(int key) {
    return _store.get(key);
  }

  public Object deleteEntity(int key) {
    return _store.remove(key);
  }

  private static int nextKey() {
    ++_nextKey;
    return _nextKey;
  }
}