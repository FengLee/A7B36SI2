package com.cvut.naKup;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * NaKup specific base for unit tests.
 * 
 * Extends {@link AbstractTransactionalJUnit4SpringContextTests}.
 * 
 * @author Marek Cech
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class NaKupTest extends AbstractTransactionalJUnit4SpringContextTests  {

}
