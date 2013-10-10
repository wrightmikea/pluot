package com.scalablelabs.pluot.api.attr.crud;

import java.util.List;

/**
 *
 */
public interface Collection<T> {

  public List<T> getAll();
  public T get(int id);
  public void add(T object);
  public void delete(int id);
  public void update(int id, T object);
}
