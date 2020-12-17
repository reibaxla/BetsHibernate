package eredua.bean;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import domain.Event;
import domain.Question;

public class QueryQuestionsBean {
	private Date data;
	private  List<Question> galderak = new Vector<Question>();
	private Event event;
	private List<Event> eventuak = new Vector<Event>();

	public void onDateSelect(SelectEvent event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data aukeratua: " + this.event));
		BLFacade facadeBL;
		facadeBL = FacadeBean.getBusinessLogic();
		eventuak = facadeBL.getEvents(this.data);
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public void setEvent() {
		System.out.println(event.getDescription());
		galderak = event.getQuestions();
	}

	public List<Event> getEventuak() {
		return eventuak;
	}

	public void setEventuak(List<Event> eventuak) {
		this.eventuak = eventuak;
	}


	public List<Question> getGalderak() {
		return galderak;
	}


	public void setGalderak(List<Question> galderak) {
		this.galderak = galderak;
	}	
}