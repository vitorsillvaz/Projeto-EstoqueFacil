package jobs;

import java.util.Date;

import models.Categoria;
import models.Produto;
import models.Status;
import models.Usuario;
import models.Perfil;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job{
	@Override
	public void doJob() throws Exception {
		if (Categoria.count() == 0) {
			Categoria vestuario = new Categoria("Vestuário");
			vestuario.save();
			
			Categoria alimento = new Categoria("Alimento");
			alimento.save();
			
			Categoria eletronicos = new Categoria("Eletrônicos");
			eletronicos.save();
			
			Categoria limpeza = new Categoria("Limpeza");
			limpeza.save();
			
			Categoria cosmeticos = new Categoria("Cosméticos");
			cosmeticos.save();
			
			Usuario joao = new Usuario();
			joao.email = "j@gmail.com";
			joao.nome = "João Vítor";
			joao.senha = "123456";
			joao.perfil = Perfil.ADMINISTRADOR;
			joao.save();
			
			Usuario admin = new Usuario();
			admin.email = "admin@gmail.com";
			admin.nome = "João Vítor";
			admin.senha = "123456";
			admin.perfil = Perfil.ADMINISTRADOR;
			admin.save();

			
			Usuario maria = new Usuario();
			maria.email = "m@gmail.com";
			maria.nome = "Maria Gilmara";
			maria.senha = "123456";
			maria.perfil = Perfil.ASSISTENTE;
			maria.save();
		}
			
			
	}

}
