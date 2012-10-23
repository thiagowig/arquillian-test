package br.com.arkhi.test.arquillian.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.arkhi.test.arquillian.entity.Beer;
import br.com.arkhi.test.arquillian.entity.Hop;
import br.com.arkhi.test.arquillian.entity.Malt;
import br.com.arkhi.test.arquillian.entity.Yeast;
import br.com.arkhi.test.arquillian.exception.DataValidationException;
import br.com.arkhi.test.arquillian.service.BeerService;

/**
 * 
 * @author thiago
 *
 */
@WebServlet(urlPatterns="/saveBeer")
public class BeerController extends HttpServlet {
	
	@EJB
	private BeerService beerService;
	
	/**
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			this.executeDoPost(req, resp);
			
		} catch (DataValidationException e) {
			resp.sendRedirect("index.jsp?warningMessage=" + e.getMessage());

		} catch (EJBException e) {
			this.treatEJBException(resp, e);
			
		} catch (Exception e) {
			this.treatGenericException(resp, e);
		}
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws DataValidationException 
	 */
	private void executeDoPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, DataValidationException {
		this.beerService.create(this.retrieveBeerFromRequest(req));
		resp.sendRedirect("index.jsp?successMessage=Registro inserido com sucesso");
	}
	
	/**
	 * 
	 * @param req
	 * @return
	 */
	private Beer retrieveBeerFromRequest(HttpServletRequest req) {
		Beer beer = new Beer();
		
		Malt malt = new Malt();
		malt.setId(Integer.parseInt(req.getParameter("malt")));
		
		Hop hop = new Hop();
		hop.setId(Integer.parseInt(req.getParameter("hop")));
		
		Yeast yeast = new Yeast();
		yeast.setId(Integer.parseInt(req.getParameter("yeast")));
		
		beer.setMalt(malt);
		beer.setHop(hop);
		beer.setYeast(yeast);
		beer.setName(req.getParameter("beerName"));
		
		return beer;
	}
	
	/**
	 * 
	 * @param resp
	 * @param e
	 * @throws IOException
	 */
	private void treatEJBException(HttpServletResponse resp, EJBException e) throws IOException {
		if (e.getCause() != null && e.getCause().getMessage() != null && !e.getCause().getMessage().equals("")) {
			resp.sendRedirect("index.jsp?warningMessage=" + e.getCause().getMessage());
			
		} else {
			this.treatGenericException(resp, e);
		}
	}
	
	/**
	 * 
	 * @param resp
	 * @param e
	 * @throws IOException
	 */
	private void treatGenericException(HttpServletResponse resp, Exception e) throws IOException {
		e.printStackTrace();
		resp.sendRedirect("index.jsp?errorMessage=Ocorreu um erro. Tente mais tarde.");
	}
	
}
