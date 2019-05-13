package com.adaming.run;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.entities.Utilisateur;
import com.adaming.service.interfaces.IUtilisateurService;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IUtilisateurService utilisateurService = (IUtilisateurService) context.getBean("utilisateurService");
		
		Utilisateur u1 = new Utilisateur("mail1", "nom1", "prenom1");
		Utilisateur u2 = new Utilisateur("mail2", "nom2", "prenom2");
		Utilisateur u3 = new Utilisateur("mail3", "nom3", "prenom3");
		
		utilisateurService.create(u1);
		utilisateurService.create(u2);
		utilisateurService.create(u3);
		System.out.println("Recherche par Id");
		Utilisateur disp = utilisateurService.getById(Utilisateur.class, u1.getIdUtilisateur());
		System.out.println("L'utilisateur est : " + disp.getIdUtilisateur());
		System.out.println("Recherche des utilisateurs");
		List<Utilisateur> utilisateurs = utilisateurService.find(Utilisateur.class);
			for (Utilisateur utilisateur : utilisateurs)
			{
				System.out.println(utilisateur);
			}
		
//		Utilisateur u3 = new Utilisateur(1l, "mail", "nom1", "prenom1");
//		utilisateurService.update(u3);
			
//		utilisateurService.delete(u3);

	}

}
