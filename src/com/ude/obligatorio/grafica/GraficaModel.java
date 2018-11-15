package com.ude.obligatorio.grafica;

import java.util.List;

import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;
import com.ude.obligatorio.logica.valueObjects.VORevision;

public class GraficaModel {

	private String mensajeError;
	private String mensajeExito;
	private List<VORevision> listRev;
	private List<VOFolio> listFol;
	private VOFolioMaxRev voMaxRev;
	private String desc;
	
	
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	public List<VORevision> getListRev() {
		return listRev;
	}
	public void setListRev(List<VORevision> listRev) {
		this.listRev = listRev;
	}
	public List<VOFolio> getListFol() {
		return listFol;
	}
	public void setListFol(List<VOFolio> listFol) {
		this.listFol = listFol;
	}
	public VOFolioMaxRev getVoMaxRev() {
		return voMaxRev;
	}
	public void setVoMaxRev(VOFolioMaxRev voMaxRev) {
		this.voMaxRev = voMaxRev;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMensajeExito() {
		return mensajeExito;
	}
	public void setMensajeExito(String mensajeExito) {
		this.mensajeExito = mensajeExito;
	}
	
	
	
}
