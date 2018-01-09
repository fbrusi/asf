package test;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.asf.db.models.Contract;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("asf");
		EntityManager manager = factory.createEntityManager();
		
		Contract contract = new Contract();
		contract.setContractNumber(Long.valueOf(12345));
		contract.setForeignValue(BigInteger.valueOf(118));
		contract.setValue(BigInteger.valueOf(330));
		
		manager.getTransaction().begin();
		manager.persist(contract);
		manager.getTransaction().commit();
		
		Contract contract2 = manager.find(Contract.class, Long.valueOf(1));
		System.out.println(contract2.getForeignValue());
		
		manager.close();
		factory.close();
		
		System.out.println("Contrato gravado com sucesso!");
	}
}
