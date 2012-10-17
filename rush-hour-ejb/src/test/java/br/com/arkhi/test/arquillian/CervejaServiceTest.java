package br.com.arkhi.test.arquillian;

import javax.ejb.EJB;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.arkhi.test.arquillian.entity.Cerveja;
import br.com.arkhi.test.arquillian.service.CervejaService;

@RunWith(Arquillian.class)
public class CervejaServiceTest {
	
	@EJB
	private CervejaService cervejaService;
	
	@Deployment
	public static JavaArchive criarArquivo() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class);
		
		jar.addPackages(true, "br");
		jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		jar.addAsManifestResource("test-persistence.xml", "persistence.xml");
		
		System.out.println(jar.toString(true));
		
		return jar;
	}
	
	@Test
	public void testar() {
		Assert.assertNotNull(cervejaService);
	}

	@Test
	public void test() {
		Cerveja cerveja = new Cerveja();
		cerveja.setNome("Arkhi Beer");
		
		this.cervejaService.create(cerveja);
		
		Assert.assertEquals(new Long(1), cerveja.getId());
	}
}
