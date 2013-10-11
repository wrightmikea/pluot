package com.scalablelabs.pluot.core.domain;

import com.scalablelabs.pluot.core.domain.Release;
import com.scalablelabs.pluot.core.domain.Releases;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 *
 */
public class ReleaseTest {

  Releases _releases = null;

  @Before
  public void setUp() {
    _releases = new Releases();
  }

  @After
  public void tearDown() {
    _releases = null;
  }

  @Test
  public void testCreateRelease() throws Exception {
    Release release = new Release("Foo", "Foo 1.0", "[placeholder]");

    assertThat(release).isNotNull();
    assertThat(release.getRelease()).isEqualTo("Foo 1.0");
    assertThat(release.getName()).isEqualTo("Foo");
  }

  @Test
  public void testAddRelease() throws Exception {
    Release release = new Release("Bar", "Bar 2.0.1", "[placeholder]");
    _releases.add(release);

    assertThat(release).isNotNull();
    assertThat(_releases.getAll().size()).isEqualTo(1);
  }

  @Test
  public void testGetReleasesWhenNone() throws Exception {
    List<Release> releases = _releases.getAll();

    assertThat(releases).isNotNull();
    assertThat(releases.size()).isEqualTo(0);
  }

  @Test
  public void testGetRelease() throws Exception {
    Release release = new Release("Foo","Foo 1.0", "[placeholder]");
    _releases.add(release);

    assertThat(_releases).isNotNull();
    assertThat(_releases.getAll().size()).isEqualTo(1);
    assertThat(_releases.get(release.getKey()).getRelease()).isEqualTo("Foo 1.0");
    assertThat(_releases.get(release.getKey()).getName()).isEqualTo("Foo");
  }

  @Test
  public void testGetNewRelease() throws Exception {
    Release release1 = new Release("Foo", "Foo 1.0", "[placeholder]");
    release1.setKey(1);
    _releases.add(release1);

    Release release2 = new Release("Bar", "Bar 2.0", "[placeholder]");
    release2.setKey(2);
    _releases.add(release2);

    assertThat(_releases).isNotNull();
    assertThat(_releases.getAll().size()).isEqualTo(2);
    assertThat(_releases.get(release2.getKey()).getRelease()).isEqualTo("Bar 2.0");
    assertThat(_releases.get(release2.getKey()).getName()).isEqualTo("Bar");}

  @Test
  public void testDeleteRelease() throws Exception {
    Release release = new Release("Foo", "Foo 1.0", "[placeholder]");
    release.setKey(1);
    _releases.add(release);

    assertThat(_releases).isNotNull();
    assertThat(_releases.getAll().size()).isEqualTo(1);

    _releases.delete(release.getKey());

    assertThat(_releases.getAll().size()).isEqualTo(0);
  }

  @Test
  public void testUpdateRelease() throws Exception {
    Release release = new Release("Foo", "Foo 1.0", "[placeholder]");
    release.setKey(1);
    _releases.add(release);

    assertThat(_releases).isNotNull();
    assertThat(_releases.getAll().size()).isEqualTo(1);

    Release update = new Release("Bar", "Bar 2.0", "[placeholder2]");
    _releases.update(release.getKey(), update);

    assertThat(_releases.get(release.getKey()).getRelease()).isEqualTo("Bar 2.0");
    assertThat(_releases.get(release.getKey()).getName()).isEqualTo("Bar");
    assertThat(_releases.get(release.getKey()).getSource()).isEqualTo("[placeholder2]");
  }
}

