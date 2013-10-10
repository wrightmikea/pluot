package com.scalablelabs.pluot.core.domain;



import com.scalablelabs.pluot.api.attr.crud.Collection;
import com.scalablelabs.pluot.core.domain.Release;

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
        release.setFamily(update.getFamily());
        release.setProduct(update.getProduct());
        release.setRelease(update.getRelease());
        release.setSource(update.getSource());
      }
    }
  }
}
