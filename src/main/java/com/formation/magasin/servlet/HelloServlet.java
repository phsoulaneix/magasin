package com.formation.magasin.servlet;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.magasin.model.entity.Article;
import com.formation.magasin.model.entity.Client;
import com.formation.magasin.model.manager.MagasinManager;

/**
 * The Class HelloServlet.
 */
@Controller
@RequestMapping("/hello")
public class HelloServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		final MagasinManager magasinManager = (MagasinManager) ctx
				.getBean("magasinManagerImpl");

		List<Client> list = magasinManager.getClients();
		System.out.println("Client count: " + list.size());

		final Client client = new Client();
		client.setNom("johndoe");
		client.setPrenom("John Doe");
		magasinManager.addClient(client);
		System.out.println("Client inserted!");
		magasinManager.addArticle(new Article("toto", 10));

		list = magasinManager.getClients();
		System.out.println("Client count: " + list.size());

		model.addAttribute("nb", list.size());

		return "hello";
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// *
	// javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	// * , javax.servlet.http.HttpServletResponse)
	// */
	// @Override
	// public void doGet(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	// final ApplicationContext ctx = new ClassPathXmlApplicationContext(
	// "spring.xml");
	//
	// final MagasinManager magasinManager = (MagasinManager) ctx
	// .getBean("magasinManagerImpl");
	//
	// List<Client> list = magasinManager.getClients();
	// System.out.println("Client count: " + list.size());
	//
	// final Client client = new Client();
	// client.setNom("johndoe");
	// client.setPrenom("John Doe");
	// magasinManager.addClient(client);
	// System.out.println("Client inserted!");
	//
	// list = magasinManager.getClients();
	// System.out.println("User count: " + list.size());
	//
	// req.setAttribute("nb", list.size());
	// this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
	// .forward(req, resp);
	// }
}
