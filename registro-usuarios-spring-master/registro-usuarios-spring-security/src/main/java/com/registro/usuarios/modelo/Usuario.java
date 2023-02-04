package com.registro.usuarios.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
@Entity: son los objetos de persistencia almacenados como un registro en la base de datos.
@table: tabla BD
uniqueConstraint: conjunto de una o varias columnas de una tabla que se identifican de 
forma exclusiva en un registro en una tabla.
*/
@Entity 
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	@Id //@id: unico, @GeneratedValue: autoincremental
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    //@Column: setiliza para agregar la columna al nombre en la tabla de una base de datos
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	private String email;
	private String password;
	
	/*
	 * @ManyToMany: relacion muchos a muchos (un usuario puede tener N roles, muchos roles le pueden pertener a un usuario)
	 * tabla intermedia (usuarios_roles),  en la cual esta el ID del usuario y del rol para vincularlos.
	 * fetch: (carga perezosa) patrón de diseño que utilizamos para aplazar la inicialización de un objeto todo el tiempo que sea posible
	 * hasta cuando lo necesitemos.
	 * EAGER: patrón de diseño en el que la inicialización de datos se produce en el acto.
	 * CascadeType.ALL: se aplican todos los tipos de cascada.
	 */
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
			)
	private Collection<Rol> roles;

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

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	public Usuario(Long id, String nombre, String apellido, String email, String password, Collection<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Usuario() {
		
	}

}
