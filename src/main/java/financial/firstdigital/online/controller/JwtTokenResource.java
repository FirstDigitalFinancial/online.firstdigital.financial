package financial.firstdigital.online.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/token")
public class JwtTokenResource {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenResource.class);

    public JwtTokenResource() {

    }
}
