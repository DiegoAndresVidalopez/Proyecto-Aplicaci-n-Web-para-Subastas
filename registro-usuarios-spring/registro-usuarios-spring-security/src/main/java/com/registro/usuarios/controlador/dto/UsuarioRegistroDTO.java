package com.registro.usuarios.controlador.dto;
import javax.persistence.Column;
import javax.validation.constraints.*;


public class UsuarioRegistroDTO {

	private Long id;

	@NotNull(message = "{user.name.empty}")
    @Size(min = 5, max = 50, message = "la cantidad de caracteres del nombre debe estar entre 5 y 50")
	private String nombre;

	@NotNull(message = "{user.lastname.empty}")
	@Size(min = 5, max = 50, message = "{user.lastname.length}")
	private String apellido;

	@NotNull(message = "{user.email.empty}")
	@Email(message = "{user.email.mask}")
	private String email;

    @NotNull
	@Size(min = 10, max = 20)
	@Column(nullable = false, length = 20)
	private String password;

	@NotNull
	@Size(min = 10, max = 20)
	@Column(nullable = false, length = 20)
	private String Username; 

	@Pattern(message = "{user.telephone.pattern}", regexp = "[6][0-9]{8}")
	private int telefono;

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

	public String getUsername() {
		return this.Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public UsuarioRegistroDTO(String nombre, String apellido, String email, String password, String Username, int telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.Username = Username;
		this.telefono = telefono;
	}

	public UsuarioRegistroDTO() {

	}

}
