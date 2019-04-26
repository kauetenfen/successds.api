package br.com.progic.successds.api.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.progic.successds.api.service.UtilService;

@RestController
public class UtilController {
	
	@Autowired
	UtilService utilService;
	
	@GetMapping("/fibonacci/{inicio}/{quantidade}")
	public String obterSequenciaFibonacci(@PathVariable Long inicio, @PathVariable Integer quantidade) {
		return utilService.calcularSequenciaFibonacci(inicio, quantidade);
	}
	
	@GetMapping("/")
    public void index(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendRedirect(req.getContextPath() + "/index.xhtml");
    }
}
