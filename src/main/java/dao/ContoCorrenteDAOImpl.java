package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import entity.ContoCorrente;
import entity.Movimento;

public class ContoCorrenteDAOImpl implements ContoCorrenteDAO{
	private static List<ContoCorrente> conti=new ArrayList<>();
	private static List<Movimento> operazioni=new ArrayList<>();



	
	public List<ContoCorrente> getAllConti() {

		return conti;
	}


	
	public Response crea(ContoCorrente c) {
		conti.add(c);
		String result="Inserimento avvenuto con successo";
		return Response.status(201).entity(result).build();

	}

	
	public Response aggiorna(ContoCorrente c) {

		if(conti.contains(c)) {
			int index=conti.lastIndexOf(c);
			conti.set(index, c);
			return Response.status(200).entity("Aggiornamento effettuata con successo").build();

		}
		return Response.status(404).entity("Errore aggiornamento").build();
	}

	
	public Response cancella(ContoCorrente c) {

		if(conti.contains(c)) {
			conti.remove(c);
			return Response.status(200).entity("Cancellazione effettuata con successo").build();
		}
		return Response.status(404).entity("Errore cancellazione").build();
	}

	
	public Response operazione(Movimento o) {

		for (ContoCorrente conto : conti) {

			if (conto.getIban().equals(o.getIban())) {

				//prelievo
				if(o.isPrelievo()&o.getImporto()>0) {
					double saldoFinale=conto.getSaldo() - o.getImporto();
					conto.setSaldo(saldoFinale);
					int index=conti.lastIndexOf(conto);
					conti.set(index, conto);
					operazioni.add(o);
					return Response.status(200).entity("Prelievo effettuato").build();
				}
				//deposito
				if(o.isDeposito()&o.getImporto()>0) {
					double saldoFinale=conto.getSaldo() + o.getImporto();
					conto.setSaldo(saldoFinale);
					int index=conti.lastIndexOf(conto);
					conti.set(index, conto);
					operazioni.add(o);
					return Response.status(200).entity("Deposito effettuato").build();
				}
			}
		}
		return Response.status(404).entity("Errore operazione:iban errato o importo non valido").build();
	}
	
	public List<Movimento> getAllMovimenti() {

		return operazioni;
	}
}
