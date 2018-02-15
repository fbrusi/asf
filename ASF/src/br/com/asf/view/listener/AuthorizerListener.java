package br.com.asf.view.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.asf.view.LoggedUserBean;

public class AuthorizerListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoggedUserBean loggedUserBean;
	
	@Override
	public void beforePhase(PhaseEvent event) { }

	@Override
	public void afterPhase(PhaseEvent event) {
		
		FacesContext context = event.getFacesContext();
		
		if("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		
		if(!loggedUserBean.isLoggedIn()) {
			
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}
