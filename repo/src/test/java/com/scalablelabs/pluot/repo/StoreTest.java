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

