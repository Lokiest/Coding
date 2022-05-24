package springbook.learningtest.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.either;
import static org.junit.matchers.JUnitMatchers.hasItem;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class JUnitTest {
  static Set<JUnitTest> testObjects = new HashSet<JunitTest>();
  
  @Test public void test1() {
    assertThat(testObjects, not(hasItem(this)));
    testObjects.add(this);
  }

  @Test public void test1() {
    assertThat(testObjects, not(hasItem(this)));
    testObjects.add(this);
  }

  @Test public void test1() {
    assertThat(testObjects, not(hasItem(this)));
    testObjects.add(this);
  }
