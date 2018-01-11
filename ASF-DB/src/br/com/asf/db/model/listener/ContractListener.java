package br.com.asf.db.model.listener;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PostPersist;

import br.com.asf.db.dao.GenericDao;
import br.com.asf.db.model.Audit;
import br.com.asf.db.model.Contract;
import br.com.asf.db.util.JPAUtil;

public class ContractListener {

	@PostPersist
	public void registerAudit(Contract contract) {
		
		EntityManager manager = new JPAUtil().geEntityManager();
		GenericDao<Audit> dao = new GenericDao<Audit>(manager);
		
		Audit audit = new Audit();
		audit.setEventDate(LocalDateTime.now());
		audit.setDescritpion("Contrato adicionado. ID: " + contract.getId());
		
		manager.getTransaction().begin();
		dao.save(audit);
		manager.getTransaction().commit();
		
		manager.close();
	}
}
