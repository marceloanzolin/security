package anzolin.marcelo.security.ping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class Ping {

        @RequestMapping
        public String ping() {
            return "pingando";
        }
}
