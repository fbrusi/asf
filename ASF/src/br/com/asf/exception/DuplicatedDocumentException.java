package br.com.asf.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class DuplicatedDocumentException extends Exception {

	private static final long serialVersionUID = 1L;

	//TODO Implementar exce��es de aplica��o que fazem rollback, se necess�rio
}
