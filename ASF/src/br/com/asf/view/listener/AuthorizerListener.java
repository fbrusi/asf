package br.com.asf.view.listener;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.asf.constant.Profile;
import br.com.asf.view.LoggedUserBean;

public class AuthorizerListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	private static final List<String> nonLoggedPages = new ArrayList<>();
	private static final List<String> adminPages = new ArrayList<>();
	
	static {
		
		nonLoggedPages.add("/login.xhtml");
		nonLoggedPages.add("/signup.xhtml");
		nonLoggedPages.add("/signup2.xhtml");
		
		adminPages.add("/companyManager.xhtml");
	}
	
	@Inject
	private LoggedUserBean loggedUserBean;
	
	@Override
	public void beforePhase(PhaseEvent event) { }

	@Override
	public void afterPhase(PhaseEvent event) {
		
		FacesContext context = event.getFacesContext();
		
		if(AuthorizerListener.nonLoggedPages.contains(context.getViewRoot().getViewId())) {
			
			loggedUserBean.logout();
			return;
		}
		
		if(!loggedUserBean.isLoggedIn() || 
				!loggedUserBean.isLoggedIn() ||
				(adminPages.contains(context.getViewRoot().getViewId()) && !loggedUserBean.getClient().getProfile().equals(Profile.ADMINISTRADOR))) {
			
			loggedUserBean.logout();

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
