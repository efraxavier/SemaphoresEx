package controller;
import java.util.concurrent.Semaphore;


public class ThreadCruzamento extends Thread {

	private int idCarro,sentido;
	private Semaphore semaforo;

	public ThreadCruzamento(int idCarro, int sentido, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.sentido = sentido;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		carroChegando(sentido);
		// Sessao Critica
		try {
			semaforo.acquire();
			carroCruzando(sentido);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		// Fim
		carroAtravessou(sentido);

	}

	private void carroChegando(int sentido) {
		switch (sentido) {
		case 0:
			try {
				System.out.println("Carro #" + idCarro + " chegando no sentido Leste");
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			try {
				System.out.println("Carro #" + idCarro + " chegando no sentido Oeste");
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				System.out.println("Carro #" + idCarro + " chegando no sentido Sul");
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				System.out.println("Carro #" + idCarro + " chegando no sentido Norte");
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

	}
	private void carroCruzando(int sentido) {
		switch (sentido) {
		case 0:
			try {
				System.out.println("#" + idCarro + " está atravessando de Leste a Oeste");
				sleep(500);
				sentido = 1;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			try {
				System.out.println("#" + idCarro + " está atravessando de Oeste a Leste");
				sleep(500);
				sentido = 0;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				System.out.println("#" + idCarro + " está atravessando de Sul a Norte");
				sleep(500);
				sentido = 3;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				System.out.println("#" + idCarro + " está atravessando de Norte a Sul");
				sleep(500);
				sentido = 2;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

	}

	private void carroAtravessou(int sentido) {
		switch (sentido) {
		case 0:
			try {
				System.out.println("#" + idCarro + " atravessou para Oeste");
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			try {
				System.out.println("#" + idCarro + " atravessou para Leste");
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				System.out.println("#" + idCarro + " atravessou para Norte");
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				System.out.println("#" + idCarro + " atravessou para Sul");
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

	}


}
