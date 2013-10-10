package com.scalablelabs.pluot.core.domain;

import com.scalablelabs.pluot.api.attr.Family;
import com.scalablelabs.pluot.api.attr.Product;
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
    Release release = new Release(Product.PC, Family.DIAMOND, "PC 7.0.5", "[placeholder]");

    assertThat(release).isNotNull();
    assertThat(release.getRelease()).isEqualTo("PC 7.0.5");
    assertThat(release.getProduct()).isEqualTo(Product.PC);
    assertThat(release.getFamily()).isEqualTo(Family.DIAMOND);
  }

  @Test
  public void testAddRelease() throws Exception {
    Release release = new Release(Product.PC, Family.DIAMOND, "PC 7.0.5", "[placeholder]");
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
    Release release = new Release(Product.PC, Family.DIAMOND, "PC 7.0.5", "[placeholder]");
    _releases.add(release);

    assertThat(_releases).isNotNull();
    assertThat(_releases.getAll().size()).isEqualTo(1);
    assertThat(_releases.get(release.getKey()).getRelease()).isEqualTo("PC 7.0.5");
    assertThat(_releases.get(release.getKey()).getProduct()).isEqualTo(Product.PC);
    assertThat(_releases.get(release.getKey()).getFamily()).isEqualTo(Family.DIAMOND);
  }

  @Test
  public void testGetNewRelease() throws Exception {
    Release release1 = new Release(Product.PC, Family.DIAMOND, "PC 7.0.5", "[placeholder]");
    release1.setKey(1);
    _releases.add(release1);

    Release release2 = new Release(Product.CC, Family.EMERALD, "CC 8.0.5", "[placeholder]");
    release2.setKey(2);
    _releases.add(release2);

    assertThat(_releases).isNotNull();
    assertThat(_releases.getAll().size()).isEqualTo(2);
    assertThat(_releases.get(release2.getKey()).getRelease()).isEqualTo("CC 8.0.5");
    assertThat(_releases.get(release2.getKey()).getProduct()).isEqualTo(Product.CC);
    assertThat(_releases.get(release2.getKey()).getFamily()).isEqualTo(Family.EMERALD);}

  @Test
  public void testDeleteRelease() throws Exception {
    Release release = new Release(Product.PC, Family.DIAMOND, "PC 7.0.5", "[placeholder]");
    release.setKey(1);
    _releases.add(release);

    assertThat(_releases).isNotNull();
    assertThat(_releases.getAll().size()).isEqualTo(1);

    _releases.delete(release.getKey());

    assertThat(_releases.getAll().size()).isEqualTo(0);
  }

  @Test
  public void testUpdateRelease() throws Exception {
    Release release = new Release(Product.PC, Family.DIAMOND, "PC 7.0.5", "[placeholder]");
    release.setKey(1);
    _releases.add(release);

    assertThat(_releases).isNotNull();
    assertThat(_releases.getAll().size()).isEqualTo(1);

    Release update = new Release(Product.CC, Family.EMERALD, "CC 8.0.1", "[placeholder2]");
    _releases.update(release.getKey(), update);

    assertThat(_releases.get(release.getKey()).getRelease()).isEqualTo("CC 8.0.1");
    assertThat(_releases.get(release.getKey()).getFamily()).isEqualTo(Family.EMERALD);
    assertThat(_releases.get(release.getKey()).getProduct()).isEqualTo(Product.CC);
    assertThat(_releases.get(release.getKey()).getSource()).isEqualTo("[placeholder2]");
  }
}

