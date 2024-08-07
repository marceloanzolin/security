package anzolin.marcelo.security.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

//cclasse criada para passsar as informações do usuario, esta classe o sprin vai estar entendendo

@Getter
public class UserPrincipal {
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority>  authorities;

    private UserPrincipal(User user){
        this.username = user.getUserName();
        this.password = user.getPassword();

        this.authorities = user.getRoles().stream().map(role -> {
                    return new SimpleGrantedAuthority("ROLE_".concat(role.getName())); //spring espera este formato
                }).toList();
        }

        //utilçizado bastante no padrao factory singleton a gnt não instancia a classe user principal diretamente chamaou o metodo user principal que é  statico
        public static UserPrincipal create(User user){
            return new UserPrincipal(user);
        }
}
