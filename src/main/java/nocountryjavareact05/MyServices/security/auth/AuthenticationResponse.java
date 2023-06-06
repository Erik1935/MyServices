/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  nocountryjavareact05.MyServices.security.auth.AuthenticationResponse
 *  nocountryjavareact05.MyServices.security.auth.AuthenticationResponse$AuthenticationResponseBuilder
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
public class AuthenticationResponse {
    private String token;


}

