package br.com.arkhi.test.arquillian.cache;

import java.util.List;

import br.com.arkhi.test.arquillian.entity.Yeast;
import br.com.arkhi.test.arquillian.entity.Hop;
import br.com.arkhi.test.arquillian.entity.Malt;
import br.com.arkhi.test.arquillian.locator.ServiceLocator;
import br.com.arkhi.test.arquillian.service.YeastService;
import br.com.arkhi.test.arquillian.service.HopService;
import br.com.arkhi.test.arquillian.service.MaltService;

public class EntitiesCache {
	
	private static List<Malt> maltList;
	private static List<Hop> hopList;
	private static List<Yeast> yeastList;
	
	private MaltService maltService;
	private HopService hopService;
	private YeastService yeastService;

	public List<Malt> getMalts() {
		if (EntitiesCache.maltList == null) {
			EntitiesCache.maltList = this.getMaltService().findAll();
		}
		
		return EntitiesCache.maltList;
	}
	
	public List<Hop> getHops() {
		if (EntitiesCache.hopList == null) {
			EntitiesCache.hopList = this.getHopService().findAll();
		}
		
		return EntitiesCache.hopList;
	}
	
	public List<Yeast> getYeasts() {
		if (EntitiesCache.yeastList == null) {
			EntitiesCache.yeastList = this.getYeastService().findAll();
		}
		
		return EntitiesCache.yeastList;
	}

	private MaltService getMaltService() {
		if (this.maltService == null) {
			this.maltService = (MaltService) ServiceLocator.getInstance().returnInstance("java:app/rush-hour-ejb/MaltServiceBean");
		}
		
		return maltService;
	}

	private HopService getHopService() {
		if (this.hopService == null) {
			this.hopService = (HopService) ServiceLocator.getInstance().returnInstance("java:app/rush-hour-ejb/HopServiceBean");
		}
		
		return hopService;
	}

	private YeastService getYeastService() {
		if (this.yeastService == null) {
			this.yeastService = (YeastService) ServiceLocator.getInstance().returnInstance("java:app/rush-hour-ejb/YeastServiceBean");
		}
		
		return yeastService;
	}
	
}
