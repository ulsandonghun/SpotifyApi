package SpotifyPlaylist;

import java.io.IOException;
import java.text.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

public class createAccesstokenExample {
    private static final String clientId = "f44ba55629874250bddde56310980a50";
    private static final String clientSecret = "c7446a870f4b4e399078cc75eb30b5fd";
    private static SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId)
            .setClientSecret(clientSecret).build();
    public static void accesstoken() {
        ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            System.out.println("Expires in: " + clientCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        accesstoken();
    }
}
