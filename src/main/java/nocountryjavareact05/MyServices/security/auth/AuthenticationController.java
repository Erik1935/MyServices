/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  jakarta.servlet.http.HttpServletRequest
 *  jakarta.servlet.http.HttpServletResponse
 *  nocountryjavareact05.MyServices.security.auth.AuthenticationController
 *  nocountryjavareact05.MyServices.security.auth.AuthenticationRequest
 *  nocountryjavareact05.MyServices.security.auth.AuthenticationResponse
 *  nocountryjavareact05.MyServices.security.auth.AuthenticationService
 *  nocountryjavareact05.MyServices.security.auth.LogoutController
 *  nocountryjavareact05.MyServices.security.auth.RegisterRequest
 *  org.springframework.http.HttpStatus
 *  org.springframework.http.HttpStatusCode
 *  org.springframework.http.ResponseEntity
 *  org.springframework.web.bind.annotation.CrossOrigin
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package nocountryjavareact05.MyServices.security.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import nocountryjavareact05.MyServices.security.auth.AuthenticationRequest;
import nocountryjavareact05.MyServices.security.auth.AuthenticationResponse;
import nocountryjavareact05.MyServices.security.auth.AuthenticationService;
import nocountryjavareact05.MyServices.security.auth.LogoutController;
import nocountryjavareact05.MyServices.security.auth.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping(value="/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(this.service.register(request));
    }

    @PostMapping(value="/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(this.service.authenticate(request));
    }

    @GetMapping(value="/logout")
    public ResponseEntity<?> closeSession(HttpServletRequest request, HttpServletResponse response) {
        LogoutController logoutController = new LogoutController();
        logoutController.logout(request, response);
        return new ResponseEntity("Sesion cerrada", (HttpStatusCode)HttpStatus.OK);
    }

}

