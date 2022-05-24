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
  static JUnitTest testObject;
  
  @Test public void test1() {
    assertThat(this, is(not(sameInstance(testObject))));
    testObject = this;
  }

  @Test public void test2() {
    assertThat(this, is(not(sameInstance(testObject))));
    testObject = this;
  }

  @Test public void test3() {
    assertThat(this, is(not(sameInstance(testObject))));
    testObject = this;
  }
