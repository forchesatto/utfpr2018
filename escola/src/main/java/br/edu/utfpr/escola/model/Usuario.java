package br.edu.utfpr.escola.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = -469759354805228603L;
	
	@Id
	@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq")
	@GeneratedValue(generator = "usuario_seq", strategy = GenerationType.SEQUENCE)
	private Long codigo;
	@Column(length = 150, nullable = false)
	private String nome;
	@Column(length = 150, nullable = false)
	private String username;
	@Column(length = 150, nullable = false)
	private String password;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<Permissao> permissoes;
	
	public Usuario(){
		this.permissoes = new HashSet<>();
	}
	
	public void addPermissao(Permissao permissao){
		if(permissoes == null){
			permissoes = new HashSet<>();
		}
		permissoes.add(permissao);
	}
	
	public void removerPermissao(Permissao permissao){
		if(permissoes != null){
			permissoes.remove(permissao);
		}
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return permissoes;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Collection<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Collection<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	

}
