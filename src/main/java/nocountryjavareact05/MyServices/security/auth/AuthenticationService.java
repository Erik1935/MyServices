/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  nocountryjavareact05.MyServices.entidades.User
 *  nocountryjavareact05.MyServices.repositories.UserRepository
 *  nocountryjavareact05.MyServices.security.auth.AuthenticationRequest
 *  nocountryjavareact05.MyServices.security.auth.AuthenticationResponse
 *  nocountryjavareact05.MyServices.security.auth.AuthenticationService
 *  nocountryjavareact05.MyServices.security.auth.RegisterRequest
 *  nocountryjavareact05.MyServices.security.config.JwtService
 *  org.springframework.security.authentication.AuthenticationManager
 *  org.springframework.security.authentication.UsernamePasswordAuthenticationToken
 *  org.springframework.security.core.Authentication
 *  org.springframework.security.core.userdetails.UserDetails
 *  org.springframework.security.crypto.password.PasswordEncoder
 *  org.springframework.stereotype.Service
 */
package nocountryjavareact05.MyServices.security.auth;

import lombok.RequiredArgsConstructor;
import nocountryjavareact05.MyServices.entidades.User;
import nocountryjavareact05.MyServices.repositories.UserRepository;
import nocountryjavareact05.MyServices.security.config.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder().name(request.getName()).lastname(request.getLastname()).email(request.getEmail()).password(this.passwordEncoder.encode((CharSequence)request.getPassword())).pais(request.getPais()).localidad(request.getLocalidad()).provincia(request.getProvincia()).role("User").build();
        this.repository.save(user);
        String jwtToken = this.jwtService.generateToken((UserDetails)user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        this.authenticationManager.authenticate((Authentication)new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        System.out.println("Aqui va la ejecucion");
        User user = (User)this.repository.findByEmail(request.getEmail()).orElseThrow();
        String jwtToken = this.jwtService.generateToken((UserDetails)user);
        System.out.println("jwtToken = " + jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

}

