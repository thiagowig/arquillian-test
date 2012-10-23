package br.com.arkhi.test.arquillian;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.performance.annotation.Performance;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BeerTest {
	
	@Deployment
	public static JavaArchive createFile() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class);
		
		jar.addPackages(true, "br");
		jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		jar.addAsManifestResource("test-persistence.xml", "persistence.xml");
		
		return jar;
	}
	
	@Test
	@Performance(time=12000)
	public void test() throws InterruptedException {
		Thread.sleep(1000000);
		Assert.assertEquals(1, 1);
	}
	
}