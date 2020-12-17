package eredua.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import domain.Event;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

public class CreateQuestionsBean {
	private Date data;
	private String galdera;
	private Event event;
	private float apustua;
	private List<Event> eventuak = new Vector<Event>();
	
	public void onDateSelect(SelectEvent event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data aukeratua: " + this.data ));	
		BLFacade facadeBL;
		facadeBL = FacadeBean.getBusinessLogic();
		eventuak = facadeBL.getEvents(this.data);
	}
	
	public String getGaldera() {
		return galdera;
	}

	public void setGaldera(String galdera) {
		this.galdera = galdera;
	}

	public float getApustua() {
		return apustua;
	}

	public void setApustua(float apustua) {
		this.apustua = apustua;
	}
	
	public void createQuestions() throws EventFinished, QuestionAlreadyExist {
		BLFacade facadeBL;
		facadeBL = FacadeBean.getBusinessLogic();
		System.out.println(event.getDescription());
		System.out.println(this.galdera);
		System.out.println(this.apustua);
		facadeBL.createQuestion(event, this.galdera, this.apustua);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public List<Event> getEventuak() {
		return eventuak; 
	}
	
	public void proba() {
		System.out.println(eventuak);
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void setEventuak(List<Event> eventuak) {
		this.eventuak = eventuak;
	}
	
}
