package view;

import java.util.Random;
import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class MainCruzamento {


		public static void main(String[] args) {
			
			
			int permissoes = 1;
			
			Semaphore semaforo = new Semaphore(permissoes);
			
			for(int idCarro = 0; idCarro < 6; idCarro++) {
				Random generator = new Random();
				int sentido = generator.nextInt(4);

				Thread tCarro = new ThreadCruzamento(idCarro,sentido,semaforo);
				tCarro.start();
			}
		}
		
	}
