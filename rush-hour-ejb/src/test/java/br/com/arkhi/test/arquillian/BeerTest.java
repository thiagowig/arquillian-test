package br.com.arkhi.test.arquillian;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.arkhi.test.arquillian.entity.Malt;
import br.com.arkhi.test.arquillian.exception.DataValidationException;

@RunWith(Arquillian.class)
public class BeerTest {
	
	@Inject
	private UserTransaction userTransaction;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Deployment
	public static JavaArchive createApp() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class);
		
		jar.addPackages(true, "br");
		jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		jar.addAsManifestResource("test-persistence.xml", "persistence.xml");
		
		System.out.println(jar.toString(true));
		
		return jar;
	}
	
	@Test
	public void testInit() throws DataValidationException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException {
		Assert.assertNotNull(this.entityManager);
		Assert.assertNotNull(this.userTransaction);
		
		this.userTransaction.begin();
		this.entityManager.joinTransaction();
		
		Malt malt = new Malt();
		malt.setId(200);
		malt.setName("Malte do Lazaro Ramos");
		
		this.entityManager.persist(malt);
		
		this.userTransaction.commit();
	}
	
}
