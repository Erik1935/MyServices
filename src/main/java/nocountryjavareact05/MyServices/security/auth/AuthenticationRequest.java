/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  nocountryjavareact05.MyServices.security.auth.AuthenticationRequest
 *  nocountryjavareact05.MyServices.security.auth.AuthenticationRequest$AuthenticationRequestBuilder
 */
package nocountryjavareact05.MyServices.security.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private String email;
    private String password;

}

