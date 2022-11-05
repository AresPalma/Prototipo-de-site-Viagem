package br.com.agencia.model;


	import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import br.com.agencia.security.Permissoes.RoleName;

import java.io.Serializable;
	import java.util.UUID;

	@Entity
	@Table(name = "TB_ROLE")
	
	public class Login implements GrantedAuthority, Serializable {
	    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private UUID roleId;
	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false, unique = true)
	    private RoleName roleName;


	    @Override
	    public String getAuthority() {
	        return this.roleName.toString();
	    }

	    public UUID getRoleId() {
	        return roleId;
	    }

	    public void setRoleId(UUID roleId) {
	        this.roleId = roleId;
	    }

	    public RoleName getRoleName() {
	        return roleName;
	    }

	    public void setRoleName(RoleName roleName) {
	        this.roleName = roleName;
	    }
	}


