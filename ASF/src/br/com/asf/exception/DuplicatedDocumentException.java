package br.com.asf.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class DuplicatedDocumentException extends Exception {

	private static final long serialVersionUID = 1L;

	//TODO Implementar exceções de aplicação que fazem rollback, se necessário
}
