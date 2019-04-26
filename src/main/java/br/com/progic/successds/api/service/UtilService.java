package br.com.progic.successds.api.service;

import org.springframework.stereotype.Service;

@Service
public class UtilService {
	
	private static final String CARACTER_VIRGULA = ",";

	public String calcularSequenciaFibonacci(long numeroInicial, int quantidadeNumeros) {
		StringBuilder sb = new StringBuilder();
		boolean limite = true;
		int iInicial = 0;
			
		while (limite) {
			long proximoNumero = proximoNumeroFibonacci(iInicial);
			iInicial++;
			if(proximoNumero >= numeroInicial) {
				limite = false;
			}
		}
		quantidadeNumeros = iInicial + quantidadeNumeros;
		for (int i = iInicial - 1; i < quantidadeNumeros - 1; i++) {
            sb.append(proximoNumeroFibonacci(i));
            if (i + 1 < quantidadeNumeros - 1) {
				sb.append(UtilService.CARACTER_VIRGULA);
			}
        }
		return sb.toString();
	}
	
	private long proximoNumeroFibonacci (int n) {
        return (n < 2) ? n : proximoNumeroFibonacci(n - 1) + proximoNumeroFibonacci(n - 2);
    }
}
