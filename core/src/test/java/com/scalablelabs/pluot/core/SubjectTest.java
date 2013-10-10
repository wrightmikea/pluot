package com.scalablelabs.pluot.core;

import com.scalablelabs.pluot.core.Subject;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 *
 */
public class SubjectTest {

  @Test
  public void testDoSomething() throws Exception {
    assertThat(new Subject().doSomething()).isEqualTo("subject");
  }
}
