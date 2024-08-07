package anzolin.marcelo.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUserName(String userName);

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.userName = :userName")
    User findByUserNameFetchRoles(@Param("userName") String userName);
}
