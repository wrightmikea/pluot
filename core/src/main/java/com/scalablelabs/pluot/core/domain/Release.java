package com.scalablelabs.pluot.core.domain;


import com.scalablelabs.pluot.api.attr.Family;
import com.scalablelabs.pluot.api.attr.Product;
import com.scalablelabs.pluot.api.entity.AbstractEntity;
import com.scalablelabs.pluot.api.entity.Entity;

/**
 *
 */
public class Release extends AbstractEntity implements Entity {

  private Family _family;
  private Product _product;
  private String _release;
  private String _source;

  public Release(Product product, Family family, String release, String source) {
    _product = product;
    _family = family;
    _release = release;
    _source = source;
  }

  public Product getProduct() {
    return _product;
  }

  public Family getFamily() {
    return _family;
  }

  public String getRelease() {
    return _release;
  }

  public String getSource() {
    return _source;
  }

  public void setProduct(Product product) {
    _product = product;
  }

  public void setFamily(Family family) {
    _family = family;
  }

  public void setRelease(String release) {
    _release = release;
  }

  public void setSource(String source) {
    _source = source;
  }
}

