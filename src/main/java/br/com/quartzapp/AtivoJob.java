package br.com.quartzapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class AtivoJob implements Job {
	
	private static Logger logger = Logger.getLogger(AtivoJob.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			File pastaOrigem = new File("C:\\Users\\marllon.pinheiro\\Desktop\\Ativos");
			File[] arquivos = pastaOrigem.listFiles();
			AtivoDAO ativoDao = new AtivoDAO();
			if (arquivos.length != 0) {
				for (File arquivo : arquivos) {
					if (arquivo.isFile() && arquivo.getName().endsWith(".txt") && arquivo.length() != 0) {
						try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
							String linha;
							while ((linha = leitor.readLine()) != null) {
								String[] ativoString = linha.split("\\|");
								Ativo ativo = new Ativo();
								ativo.setNome(ativoString[0]);
								ativo.setPreco(new BigDecimal(ativoString[1]));
								ativo.setDataRegistro(LocalDateTime.now());
								ativoDao.cadastrar(ativo);
							}
						}
						File pastaDestino = new File("C:\\Users\\marllon.pinheiro\\Desktop\\backup", arquivo.getName());
						arquivo.renameTo(pastaDestino);
					} else {
						logger.info("O arquivo está vazio.");
					}
				}
			} else {
				logger.info("A pasta está vazia.");
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new JobExecutionException("Informações preenchidas de forma errada.", ex);
		} catch (NullPointerException ex) {
			throw new JobExecutionException("Erro ao ler arquivo.", ex);
		} catch (IOException ex) {
			throw new JobExecutionException("Arquivo não existe ou não foi encontrado.", ex);
		}

	}

}
