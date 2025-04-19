package com.saberPro.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiantes")
public class Estudiante {

    @Id
    private String id;

    private String tipoDocumento;
    private Integer numeroDocumento; 
    private String primerApellido;
    private String segundoApellido;
    private String primerNombre;
    private String segundoNombre;
    private String correoElectronico;
    private String numeroTelefonico;
    private String numeroRegistro;
    private Object puntaje; 
    private String nivelSaberPro;
    private String mediaNacional;
    private String estado;

    private Integer comunicacionEscrita;
    private String nivelComunicacionEscrita;
    private Integer razonamientoCuantitativo;
    private String nivelRazonamientoCuantitativo;
    private Integer lecturaCritica;
    private String nivelLecturaCritica;
    private Integer competenciasCiudadanas;
    private String nivelCompetenciasCiudadanas;
    private Integer ingles;
    private String nivelSaberIngles;
    private Integer formulacionDeProyectos;
    private String nivelFormulacionDeProyectos;
    private Integer pensamientoCientifico;
    private String nivelPensamientoCientifico;
    private Integer disenoDeSoftware;
    private String nivelDisenoDeSoftware;
    private String nivelIngles;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}
	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	public String getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	public String getNivelSaberPro() {
		return nivelSaberPro;
	}
	public void setNivelSaberPro(String nivelSaberPro) {
		this.nivelSaberPro = nivelSaberPro;
	}
	public String getMediaNacional() {
		return mediaNacional;
	}
	public void setMediaNacional(String mediaNacional) {
		this.mediaNacional = mediaNacional;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getComunicacionEscrita() {
		return comunicacionEscrita;
	}
	public void setComunicacionEscrita(Integer comunicacionEscrita) {
		this.comunicacionEscrita = comunicacionEscrita;
	}
	public String getNivelComunicacionEscrita() {
		return nivelComunicacionEscrita;
	}
	public void setNivelComunicacionEscrita(String nivelComunicacionEscrita) {
		this.nivelComunicacionEscrita = nivelComunicacionEscrita;
	}
	public Integer getRazonamientoCuantitativo() {
		return razonamientoCuantitativo;
	}
	public void setRazonamientoCuantitativo(Integer razonamientoCuantitativo) {
		this.razonamientoCuantitativo = razonamientoCuantitativo;
	}
	public String getNivelRazonamientoCuantitativo() {
		return nivelRazonamientoCuantitativo;
	}
	public void setNivelRazonamientoCuantitativo(String nivelRazonamientoCuantitativo) {
		this.nivelRazonamientoCuantitativo = nivelRazonamientoCuantitativo;
	}
	public Integer getLecturaCritica() {
		return lecturaCritica;
	}
	public void setLecturaCritica(Integer lecturaCritica) {
		this.lecturaCritica = lecturaCritica;
	}
	public String getNivelLecturaCritica() {
		return nivelLecturaCritica;
	}
	public void setNivelLecturaCritica(String nivelLecturaCritica) {
		this.nivelLecturaCritica = nivelLecturaCritica;
	}
	public Integer getCompetenciasCiudadanas() {
		return competenciasCiudadanas;
	}
	public void setCompetenciasCiudadanas(Integer competenciasCiudadanas) {
		this.competenciasCiudadanas = competenciasCiudadanas;
	}
	public String getNivelCompetenciasCiudadanas() {
		return nivelCompetenciasCiudadanas;
	}
	public void setNivelCompetenciasCiudadanas(String nivelCompetenciasCiudadanas) {
		this.nivelCompetenciasCiudadanas = nivelCompetenciasCiudadanas;
	}
	public Integer getIngles() {
		return ingles;
	}
	public void setIngles(Integer ingles) {
		this.ingles = ingles;
	}
	public String getNivelIngles() {
		return nivelIngles;
	}
	public void setNivelIngles(String nivelIngles) {
		this.nivelIngles = nivelIngles;
	}
	public Integer getFormulacionDeProyectos() {
		return formulacionDeProyectos;
	}
	public void setFormulacionDeProyectos(Integer formulacionDeProyectos) {
		this.formulacionDeProyectos = formulacionDeProyectos;
	}
	public String getNivelFormulacionDeProyectos() {
		return nivelFormulacionDeProyectos;
	}
	public void setNivelFormulacionDeProyectos(String nivelFormulacionDeProyectos) {
		this.nivelFormulacionDeProyectos = nivelFormulacionDeProyectos;
	}
	public Integer getPensamientoCientifico() {
		return pensamientoCientifico;
	}
	public void setPensamientoCientifico(Integer pensamientoCientifico) {
		this.pensamientoCientifico = pensamientoCientifico;
	}
	public String getNivelPensamientoCientifico() {
		return nivelPensamientoCientifico;
	}
	public void setNivelPensamientoCientifico(String nivelPensamientoCientifico) {
		this.nivelPensamientoCientifico = nivelPensamientoCientifico;
	}
	public Integer getDisenoDeSoftware() {
		return disenoDeSoftware;
	}
	public void setDisenoDeSoftware(Integer disenoDeSoftware) {
		this.disenoDeSoftware = disenoDeSoftware;
	}
	public String getNivelDisenoDeSoftware() {
		return nivelDisenoDeSoftware;
	}
	public void setNivelDisenoDeSoftware(String nivelDisenoDeSoftware) {
		this.nivelDisenoDeSoftware = nivelDisenoDeSoftware;
	}
	public String getNivelSaberIngles() {
		return nivelSaberIngles;
	}
	public void setNivelSaberIngles(String nivelSaberIngles) {
		this.nivelSaberIngles = nivelSaberIngles;
	}
	public void setPuntaje(Object puntaje) {
		this.puntaje = puntaje;
	}
	public Object getPuntaje() {
		return puntaje;
	}

    
	// Método para calcular el nivel
    private String calcularNivel(Integer puntaje) {
        if (puntaje > 300 || puntaje < 0) {
            return "Error";
        } else if (puntaje >= 191) {
            return "Nivel 4";
        } else if (puntaje >= 156) {
            return "Nivel 3";
        } else if (puntaje >= 126) {
            return "Nivel 2";
        } else if (puntaje >= 0) {
            return "Nivel 1";
        }
        return "Error";
    }

    // Método que actualiza todos los niveles
    public void calcularNiveles() {
        this.nivelComunicacionEscrita = calcularNivel(comunicacionEscrita);
        this.nivelRazonamientoCuantitativo = calcularNivel(razonamientoCuantitativo);
        this.nivelLecturaCritica = calcularNivel(lecturaCritica);
        this.nivelCompetenciasCiudadanas = calcularNivel(competenciasCiudadanas);
        this.nivelSaberIngles = calcularNivel(ingles);
        this.nivelFormulacionDeProyectos = calcularNivel(formulacionDeProyectos);
        this.nivelPensamientoCientifico = calcularNivel(pensamientoCientifico);
        this.nivelDisenoDeSoftware = calcularNivel(disenoDeSoftware);
    }
}
