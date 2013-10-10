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