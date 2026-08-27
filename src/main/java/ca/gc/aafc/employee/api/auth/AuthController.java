package ca.gc.aafc.employee.api.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        // 1. Authenticate username/password
        Authentication authentication = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        // 2. Get authenticated user
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // 3. Generate JWT
        String token = jwtService.generateToken(userDetails);

        // 4. Return JWT to client
        return new AuthResponse(token);
    }
}
