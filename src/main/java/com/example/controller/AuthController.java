package com.example.controller;

import com.example.auth.CryptService;
import com.example.database.NoSQLDatabaseService;
import com.example.dto.AuthOkResponseDTO;
import com.example.dto.AuthTockenResponse;
import com.example.dto.request.AuthRequestDTO;
import com.example.service.AuthService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/rest/Auth")
public class AuthController {

    private final NoSQLDatabaseService noSQLDatabaseService;
    private final AuthService authService;
    private final CryptService cryptService;

    @Autowired
    public AuthController(NoSQLDatabaseService noSQLDatabaseService, AuthService authService, CryptService cryptService) {
        this.noSQLDatabaseService = noSQLDatabaseService;
        this.authService = authService;
        this.cryptService = cryptService;
    }

    @GetMapping("/auth({email})")
    public AuthTockenResponse getRandomString(@PathVariable String email) {
        String generatedString = RandomStringUtils.random(8,true,true);
        return createAuthTockenResponse(email, generatedString);
    }

    @PostMapping("auth/login")
    public AuthOkResponseDTO login(@RequestBody AuthRequestDTO authRequestDTO) throws Exception {
        String cryptedPassword = authService.getCustomerPassword(authRequestDTO.getEmail());
        String originalPassword = cryptService.decrypt(cryptedPassword, CryptService.APP_KEY);

        String tokenWeSendToClient = noSQLDatabaseService.getValue(authRequestDTO.getEmail());
        String cryptTokenResult = cryptService.encrypt(tokenWeSendToClient, originalPassword);

        if (authRequestDTO.getCryptedToken().equals(cryptTokenResult)) {
            AuthOkResponseDTO authOkResponse = new AuthOkResponseDTO();
            authOkResponse.setSecretContent("main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning\n" +
                    "2020-05-02 13:17:08.153  INFO 7712 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed\n" +
                    "2020-05-02 13:17:08.163  INFO 7712 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)\n" +
                    "2020-05-02 13:17:08.169  INFO 7712 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references\n" +
                    "2020-05-02 13:17:08.304  INFO 7712 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''\n" +
                    "2020-05-02 13:17:08.305  INFO 7712 --- [           main] com.groupj5.homework.Application         : Started Application in 2.717 seconds (JVM running for 3.107)");
            noSQLDatabaseService.remove(authRequestDTO.getEmail());
            return authOkResponse;
        } else {
            noSQLDatabaseService.remove(authRequestDTO.getEmail());
            throw new Exception("NEED TO MAKE ERROR AUTHCONTROLLER");
        }
    }

    private AuthTockenResponse createAuthTockenResponse(@PathVariable String email, String generatedString) {
        AuthTockenResponse authTockenResponse = new AuthTockenResponse();
        authTockenResponse.setToken(generatedString);
        authTockenResponse.setCustomerEmail(email);
        return authTockenResponse;
    }

}
