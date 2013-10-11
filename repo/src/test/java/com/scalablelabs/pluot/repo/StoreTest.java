package com.scalablelabs.pluot.repo;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 */
public class StoreTest {

  @Test
  public void testGetEntityFromEmptyStore() {
    Store<EntityImpl> entityImplStore = new Store<>();
    List<EntityImpl> entities = entityImplStore.getEntities();
    assertThat(entities).hasSize(0);
  }

  @Test
  public void testStoredEntityIsRetrieved() {
    Store<EntityImpl> entityImplStore = new Store<>();
    int key = entityImplStore.storeEntity(new EntityImpl("Foo"));
    EntityImpl retrieved = entityImplStore.getEntity(key);
    assertThat(retrieved.getId()).isEqualTo("Foo");
  }

  @Test
  public void testDeletedEntityIsNotFound() {
    Store<EntityImpl> entityImplStore = new Store<>();
    int key = entityImplStore.storeEntity(new EntityImpl("Foo"));
    entityImplStore.deleteEntity(key);
    EntityImpl retrieved = entityImplStore.getEntity(key);
    assertThat(retrieved).isNull();
  }

}

