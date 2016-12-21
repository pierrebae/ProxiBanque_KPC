package com.proxibanque.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proxibanque.model.Client;
import com.proxibanque.model.Counsellor;
import com.proxibanque.service.ServiceCounsellor;

@Component("counsellorController")
@ViewScoped
public class CounsellorController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ServiceCounsellor counsellorService;
	

	private Counsellor counsellor;
	private List<Counsellor> counsellors;
	private List<Counsellor> selectedCounsellors;
	private Counsellor selectedCounsellor;
	private long idCounsellor;
	private Client client;

	private BarChartModel barModel;
//	private BarChartModel model;
//	private ChartSeries nombreClient;
	
	private String login;
	private String password;

	@PostConstruct
	public void init() {
		refreshList();
		createBarModels();
	}

	public void refreshList() {

		this.counsellor = new Counsellor();
		this.selectedCounsellor = new Counsellor();
		this.client = new Client();

		this.counsellors = new ArrayList<Counsellor>();
		this.selectedCounsellors = new ArrayList<Counsellor>();
		try {
			this.counsellors.addAll(counsellorService.findAll());
			this.selectedCounsellors.addAll(counsellors);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadCounsellors() throws Exception {

		counsellors = counsellorService.findAll();

	}

	public String saveCounsellor() throws Exception {
		counsellorService.persist(this.counsellor);
		refreshList();
		return "listCounsellors";
	}

	public String removeCounsellor(Counsellor counsellor) throws Exception {

		counsellorService.remove(counsellor.getId());
		refreshList();
		return "listCounsellors";
	}

	public void updateCounsellor() {
		try {
			counsellorService.merge(this.selectedCounsellor);
			refreshList();
			notificationSuccess("mise à jour conseiller");
		} catch (Exception e) {
			notificationError(e, "mise à jour conseiller");
		}

	}

	public void notificationSuccess(String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation " + operation + " success");
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Opération réussie");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation " + operation + " Error ", e);
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel(RowEditEvent event) {
		refreshList();
	}

	public void reset() {
		refreshList();
		RequestContext.getCurrentInstance().reset("formCounsellors:panel");
	}

	public String removeCounsellors() throws Exception {

		selectedCounsellors = getSelectedCounsellors();

		if (getSelectedCounsellors() != null) {
			for (Counsellor counsellor : selectedCounsellors) {
				counsellorService.remove(counsellor.getId());
				refreshList();
			}

			return "listClients";
		} else {
			return "";
		}
	}
	
	private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries nombreClients = new ChartSeries();
        nombreClients.setLabel("nombre de Clients");
        for (Counsellor counsellor : counsellors) {
			int nombre = counsellor.getClients().size();
			nombreClients.set(counsellor.getLastName(), nombre);
		}

        model.addSeries(nombreClients);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
	
	public void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Nombre de Clients par Conseillers");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Conseillers");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre de Clients");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
	
	
	

	public List<Counsellor> getSelectedCounsellors() {
		return selectedCounsellors;
	}

	public void setSelectedCounsellors(List<Counsellor> selectedCounsellors) {
		this.selectedCounsellors = selectedCounsellors;
	}

	public Counsellor getSelectedCounsellor() {
		return selectedCounsellor;
	}

	public void setSelectedCounsellor(Counsellor selectedCounsellor) {
		this.selectedCounsellor = selectedCounsellor;
	}

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}

	public List<Counsellor> getCounsellors() {
		return counsellors;
	}

	public void setCounsellors(List<Counsellor> counsellors) {
		this.counsellors = counsellors;
	}

	public long getIdCounsellor() {
		return idCounsellor;
	}

	public void setIdCounsellor(long idCounsellor) {
		this.idCounsellor = idCounsellor;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

}
