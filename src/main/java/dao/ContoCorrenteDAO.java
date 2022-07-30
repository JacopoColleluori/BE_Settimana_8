package dao;

import java.util.List;


import javax.ws.rs.core.Response;

import entity.ContoCorrente;
import entity.Movimento;

public interface ContoCorrenteDAO {


	
	public List<ContoCorrente> getAllConti() ;


	
	public Response crea(ContoCorrente c) ;

	
	public Response aggiorna(ContoCorrente c) ;

	
	public Response cancella(ContoCorrente c) ;

	
	public Response operazione(Movimento o) ;
	
	public List<Movimento> getAllMovimenti() ;

}
