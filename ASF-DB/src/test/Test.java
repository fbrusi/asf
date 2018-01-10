package test;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.asf.db.dao.GenericDao;
import br.com.asf.db.model.Company;
import br.com.asf.db.model.Contract;
import br.com.asf.db.util.JPAUtil;

public class Test {

	public static void main(String[] args) {

		//EntityManager manager = new JPAUtil().geEntityManager(); manager.close();
		
		saveTest();
		System.out.println("================================");
		readByIdTest();
		System.out.println("================================");
		readAllTest();
		System.out.println("================================");
		removeTest();
		System.out.println("================================");
		readAllTest();
		System.out.println("================================");
		updateTest();
		System.out.println("================================");
		readAllTest();
	}

	private static void saveTest() {

		EntityManager manager = new JPAUtil().geEntityManager();
		GenericDao<Contract> dao = new GenericDao<Contract>(manager);

		Contract contract = new Contract();
		contract.setContractNumber(Long.valueOf(54321));
		contract.setForeignValue(BigInteger.valueOf(500));
		contract.setValue(BigInteger.valueOf(800));
		contract.setCreateDate(Calendar.getInstance().getTime());
		contract.setExpirationDate(Calendar.getInstance().getTime());

		manager.getTransaction().begin();
		dao.save(contract);
		manager.getTransaction().commit();
		
		GenericDao<Company> daoTest = new GenericDao<Company>(manager);
		
		Company company = new Company();
		company.setName("Citibomb");
		company.setCnpj("12444999000198");
		
		manager.getTransaction().begin();
		daoTest.save(company);
		manager.getTransaction().commit();

		manager.close();

		System.out.println("Contrato gravado com sucesso!");
	}

	private static void readByIdTest() {

		EntityManager manager = new JPAUtil().geEntityManager();
		GenericDao<Contract> dao = new GenericDao<Contract>(manager);

		Contract contract = dao.searchById(Contract.class, 2);
		System.out.println("Número do contrato: " + contract.getContractNumber());
		
		manager.close();
	}

	private static void readAllTest() {

		EntityManager manager = new JPAUtil().geEntityManager();
		GenericDao<Contract> dao = new GenericDao<Contract>(manager);
		
		List<Contract> contractList = dao.getAll(Contract.class);
		for(Contract contract : contractList) {
			System.out.println("ID: " + contract.getId());
		}
		
		manager.close();
	}

	private static void removeTest() {

		EntityManager manager = new JPAUtil().geEntityManager();
		GenericDao<Contract> dao = new GenericDao<Contract>(manager);
		
		Contract contract = dao.searchById(Contract.class, 1);
		
		manager.getTransaction().begin();
		dao.remove(contract);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	private static void updateTest() {
		
		EntityManager manager = new JPAUtil().geEntityManager();
		GenericDao<Contract> dao = new GenericDao<Contract>(manager);
		
		manager.getTransaction().begin();
		Contract contract = dao.searchById(Contract.class, 2);
		contract.setValue(BigInteger.valueOf(500000));
		manager.getTransaction().commit();
		
		manager.close();
	}
}
