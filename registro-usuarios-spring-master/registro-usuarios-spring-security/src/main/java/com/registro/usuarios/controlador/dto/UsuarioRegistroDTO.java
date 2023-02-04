package com.registro.usuarios.controlador.dto;
/*
 * Esta clase tiene como finalidad de crear un objeto plano (POJO) con una serie de atributos que puedan ser enviados o recuperados 
 * del servidor en una sola invocación.
 * Es importante evitar tener operaciones de negocio o métodos que realicen cálculos sobre los datos, es por ello que solo deberemos 
 * de tener los métodos GET y SET de los respectivos atributos del DTO.
 */
public class UsuarioRegistroDTO {

	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public UsuarioRegistroDTO(String nombre, String apellido, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	public UsuarioRegistroDTO() {

	}

}
