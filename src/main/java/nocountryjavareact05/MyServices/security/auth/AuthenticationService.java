package nocountryjavareact05.MyServices.security.auth;


import lombok.RequiredArgsConstructor;

import nocountryjavareact05.MyServices.entidades.User;
import nocountryjavareact05.MyServices.repositories.UserRepository;
import nocountryjavareact05.MyServices.security.config.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    var user = User.builder()
            .name(request.getName())
            .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
            .pais(request.getPais())
            .localidad(request.getLocalidad())
            .provincia(request.getProvincia())
            .role("User")
        .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    //System.out.println("request.getEmail() autheb = " + request.getEmail());
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
        )
    );
    System.out.println("Aqui va la ejecucion");
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    //System.out.println("user.getName() = " + user.getName());
    var jwtToken = jwtService.generateToken(user);
    System.out.println("jwtToken = " + jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
}
