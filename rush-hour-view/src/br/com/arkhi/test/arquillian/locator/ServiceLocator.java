package br.com.arkhi.test.arquillian.locator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 
 * @author thiago
 *
 */
public final class ServiceLocator {

	private static ServiceLocator serviceLocator;
	
	public static ServiceLocator getInstance() {
		if (serviceLocator == null) {
			serviceLocator = new ServiceLocator();
		}
		return serviceLocator;
	}
	
	public Object returnInstance(String jndiName) {		
		try {
			Context context = new InitialContext();
			return context.lookup(jndiName);
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
}