package br.com.arkhi.test.arquillian.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

import br.com.arkhi.test.arquillian.entity.Cerveja;
import br.com.arkhi.test.arquillian.entity.Levedo;
import br.com.arkhi.test.arquillian.entity.Lupulo;
import br.com.arkhi.test.arquillian.entity.Malte;
import br.com.arkhi.test.arquillian.locator.ServiceLocator;
import br.com.arkhi.test.arquillian.service.CervejaService;
import br.com.arkhi.test.arquillian.service.LevedoService;
import br.com.arkhi.test.arquillian.service.LupuloService;
import br.com.arkhi.test.arquillian.service.MalteService;

/**
 * 
 * @author thiago
 *
 */
@WebServlet(urlPatterns="/salvarCerveja")
public class CervejaController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2798878422506636381L;
	
	@EJB
	private CervejaService cervejaService;
	@EJB
	private MalteService malteService;
	@EJB
	private LupuloService lupuloService;
	@EJB
	private LevedoService levedoService;
	
	/**
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			this.executarDoPost(req, resp);
			
		} catch (EJBException e) {
			this.tratarEJBException(resp, e);
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("index.jsp?errorMessage=Ocorreu um erro. Tente mais tarde.");
		}
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void executarDoPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		this.cervejaService.create(this.recuperarCervejaDoRequest(req));
		resp.sendRedirect("index.jsp?successMessage=Registro inserido com sucesso");
	}
	
	/**
	 * 
	 * @param req
	 * @return
	 */
	private Cerveja recuperarCervejaDoRequest(HttpServletRequest req) {
		Cerveja cerveja = new Cerveja();
		
		Malte malte = new Malte();
		malte.setId(Integer.parseInt(req.getParameter("malte")));
		
		Lupulo lupulo = new Lupulo();
		lupulo.setId(Integer.parseInt(req.getParameter("lupulo")));
		
		Levedo levedo = new Levedo();
		levedo.setId(Integer.parseInt(req.getParameter("levedo")));
		
		cerveja.setNome(req.getParameter("nomeCerveja"));
		cerveja.setMalte(malte);
		cerveja.setLupulo(lupulo);
		cerveja.setLevedo(levedo);
		
		return cerveja;
	}
	
	/**
	 * 
	 * @param resp
	 * @param e
	 * @throws IOException
	 */
	private void tratarEJBException(HttpServletResponse resp, EJBException e)
			throws IOException {
		if (e.getCause() instanceof ValidationException) {
			resp.sendRedirect("index.jsp?warningMessage=" + e.getCause().getMessage());
		} else {
			throw e;
		}
	}
	
	public List<Malte> getMaltes() {
		if (this.malteService == null) {
			this.malteService = (MalteService) ServiceLocator.getInstance().returnInstance("java:app/rush-hour-ejb/MalteServiceBean");
		}
		
		return this.malteService.findAll();
	}
	
	public List<Lupulo> getLupulos() {
		if (this.lupuloService == null) {
			this.lupuloService = (LupuloService) ServiceLocator.getInstance().returnInstance("java:app/rush-hour-ejb/LupuloServiceBean");
		}
		
		return this.lupuloService.findAll();
	}
	
	public List<Levedo> getLevedos() {
		if (this.levedoService == null) {
			this.levedoService = (LevedoService) ServiceLocator.getInstance().returnInstance("java:app/rush-hour-ejb/LevedoServiceBean");
		}
		return this.levedoService.findAll();
	}
}
