package br.com.arkhi.test.arquillian;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.arkhi.test.arquillian.entity.Malt;

@RunWith(Arquillian.class)
public class BeerTest {
	
	@Deployment
	public static JavaArchive createFile() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class);
		
		jar.addClass(Malt.class);
		jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		
		return jar;
	}
	
	@Test
	public void test() throws InterruptedException {
		Assert.assertEquals(1, 1);
	}
	
}
