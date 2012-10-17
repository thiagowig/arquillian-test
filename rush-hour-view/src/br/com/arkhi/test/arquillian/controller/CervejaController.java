package br.com.arkhi.test.arquillian.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.arkhi.test.arquillian.entity.Cerveja;
import br.com.arkhi.test.arquillian.service.CervejaService;

@WebServlet(urlPatterns="/salvarCerveja")
public class CervejaController extends HttpServlet {

	@EJB
	private CervejaService beerService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		beerService.create(this.recuperarCerveja(req));
		resp.sendRedirect("second.jsp");
	}
	
	private Cerveja recuperarCerveja(HttpServletRequest req) {
		Cerveja cerveja = new Cerveja();
		
		cerveja.setNome(req.getParameter("nomeCerveja"));
		
		return cerveja;
	}
}
