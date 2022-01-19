package mx.gob.cbpeh.bpd.dto;

import java.util.List;
import mx.gob.cbpeh.bpd.modelo.CatColonia;
import mx.gob.cbpeh.bpd.modelo.CatCp;
import mx.gob.cbpeh.bpd.modelo.CatMunicipio;

public class AnidadosDto {
	
	List<CatMunicipio> municipiosRepo;
	List<CatCp> cpsRepo;
	List<CatColonia> coloniasRepo;
	
	List<CatMunicipio> municipiosDesa;
	List<CatCp> cpsDesa;
	List<CatColonia> coloniasDesa;
	
	List<CatMunicipio> municipiosActa;
	List<CatCp> cpsActa;
	List<CatColonia> coloniasActa;
	
	public List<CatMunicipio> getMunicipiosRepo() {
		return municipiosRepo;
	}
	public void setMunicipiosRepo(List<CatMunicipio> municipiosRepo) {
		this.municipiosRepo = municipiosRepo;
	}
	public List<CatCp> getCpsRepo() {
		return cpsRepo;
	}
	public void setCpsRepo(List<CatCp> cpsRepo) {
		this.cpsRepo = cpsRepo;
	}
	public List<CatColonia> getColoniasRepo() {
		return coloniasRepo;
	}
	public void setColoniasRepo(List<CatColonia> coloniasRepo) {
		this.coloniasRepo = coloniasRepo;
	}
	public List<CatMunicipio> getMunicipiosDesa() {
		return municipiosDesa;
	}
	public void setMunicipiosDesa(List<CatMunicipio> municipiosDesa) {
		this.municipiosDesa = municipiosDesa;
	}
	public List<CatCp> getCpsDesa() {
		return cpsDesa;
	}
	public void setCpsDesa(List<CatCp> cpsDesa) {
		this.cpsDesa = cpsDesa;
	}
	public List<CatColonia> getColoniasDesa() {
		return coloniasDesa;
	}
	public void setColoniasDesa(List<CatColonia> coloniasDesa) {
		this.coloniasDesa = coloniasDesa;
	}
	public List<CatMunicipio> getMunicipiosActa() {
		return municipiosActa;
	}
	public void setMunicipiosActa(List<CatMunicipio> municipiosActa) {
		this.municipiosActa = municipiosActa;
	}
	public List<CatCp> getCpsActa() {
		return cpsActa;
	}
	public void setCpsActa(List<CatCp> cpsActa) {
		this.cpsActa = cpsActa;
	}
	public List<CatColonia> getColoniasActa() {
		return coloniasActa;
	}
	public void setColoniasActa(List<CatColonia> coloniasActa) {
		this.coloniasActa = coloniasActa;
	}
	
}
