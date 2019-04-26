package br.com.progic.successds.api.service;

import java.util.GregorianCalendar;

import org.springframework.stereotype.Service;

import br.com.progic.successds.model.Pessoa;

@Service
public class PessoaService {
	
	public static final String SIGNO_PEIXES = "Peixes";
	public static final String SIGNO_AQUARIO = "Aquário";
	public static final String SIGNO_CAPRICORNIO = "Capricórnio";
	public static final String SIGNO_ARIES = "Áries";
	public static final String SIGNO_TOURO = "Touro";
	public static final String SIGNO_GEMEOS = "Gêmeos";
	public static final String SIGNO_CANCER = "Câncer";
	public static final String SIGNO_LEAO = "Leão";
	public static final String SIGNO_VIRGEM = "Virgem";
	public static final String SIGNO_LIBRA = "Libra";
	public static final String SIGNO_ESCORPIAO = "Escorpião";
	public static final String SIGNO_SAGITARIO = "Sagitário";
	
	
	public Pessoa inserirSignoPessoa(Pessoa pessoa) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(pessoa.getDataNascimento());
		int dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		int mes = calendar.get(GregorianCalendar.MONTH) + 1;
		pessoa.setSigno(obterSignoPorDataNascimento(dia, mes));
		return pessoa;
	}
	
	public String obterSignoPorDataNascimento(int dia, int mes) {
	    String signo = "";
	    switch (mes) {
	        case 1:
	            if (dia > 21) {
	                signo = PessoaService.SIGNO_AQUARIO;
	            } else {
	                signo =  PessoaService.SIGNO_CAPRICORNIO;
	            }
	            break;
	        case 2:
	                if (dia > 19) {
	                    signo =  PessoaService.SIGNO_PEIXES;
	                } else {
	                    signo =  PessoaService.SIGNO_AQUARIO;
	                }
	                break;
	        case 3:
	                if (dia > 20) {
	                    signo =  PessoaService.SIGNO_ARIES;
	                } else {
	                    signo =  PessoaService.SIGNO_PEIXES;
	                }
	                break;
	        case 4:
	                if (dia > 20) {
	                    signo =  PessoaService.SIGNO_TOURO;
	                } else {
	                    signo =  PessoaService.SIGNO_ARIES;
	                }
	                break;
	        case 5:
	                if (dia > 21) {
	                    signo =  PessoaService.SIGNO_GEMEOS;
	                } else {
	                    signo =  PessoaService.SIGNO_TOURO;
	                }
	                break;
	        case 6:
	                if (dia > 20) {
	                    signo =  PessoaService.SIGNO_CANCER;
	                } else {
	                    signo =  PessoaService.SIGNO_GEMEOS;
	                }
	                break;
	        case 7:
	                if (dia > 22) {
	                    signo =  PessoaService.SIGNO_LEAO;
	                } else {
	                    signo =  PessoaService.SIGNO_CANCER;
	                }
	                break;
	        case 8:
	                if (dia > 21) {
	                    signo =  PessoaService.SIGNO_VIRGEM;
	                } else {
	                    signo =  PessoaService.SIGNO_LEAO;
	                }
	                break;
	        case 9:
	                if (dia > 22) {
	                    signo =  PessoaService.SIGNO_LIBRA;
	                } else {
	                    signo =  PessoaService.SIGNO_VIRGEM;
	                }
	                break;
	        case 10:
	                if (dia > 22) {
	                    signo =  PessoaService.SIGNO_ESCORPIAO;
	                } else {
	                    signo =  PessoaService.SIGNO_LIBRA;
	                }
	                break;
	        case 11:
	                if (dia > 21) {
	                    signo =  PessoaService.SIGNO_SAGITARIO;
	                } else {
	                    signo =  PessoaService.SIGNO_ESCORPIAO;
	                }
	                break;
	        case 12:
	                if (dia > 21) {
	                    signo =  PessoaService.SIGNO_CAPRICORNIO;
	                } else {
	                    signo =  PessoaService.SIGNO_SAGITARIO;
	                }
	        break;
	    }
	    return signo;
	}

}
