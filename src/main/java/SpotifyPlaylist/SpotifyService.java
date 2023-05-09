package SpotifyPlaylist;

import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchArtistsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpotifyService {

    @Value("f44ba55629874250bddde56310980a50")
    private String clientId;

    @Value("c7446a870f4b4e399078cc75eb30b5fd")
    private String clientSecret;

    private String accessToken;

    private SpotifyApi getSpotifyApi() {
        return new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setAccessToken(accessToken)
                .build();
    }

    public void authenticate() throws IOException, ParseException, SpotifyWebApiException {
        final SpotifyApi spotifyApi = getSpotifyApi();
        final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
        final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
        accessToken = clientCredentials.getAccessToken();
    }

    public List<Track> searchTracksByArtist(String artistName) throws IOException, ParseException, SpotifyWebApiException {
        if (accessToken == null) {
            authenticate();
        }

        final SpotifyApi spotifyApi = getSpotifyApi();
        SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks("artist:" + artistName).build();
        Track[] tracks = searchTracksRequest.execute().getItems();

        return Arrays.stream(tracks).collect(Collectors.toList());
    }

    public List<Artist> searchArtists(String artistName) throws IOException, ParseException, SpotifyWebApiException {
        if (accessToken == null) {
            authenticate();
        }
        final SpotifyApi spotifyApi = getSpotifyApi();
        SearchArtistsRequest searchArtistsRequest = spotifyApi.searchArtists(artistName).build();
        Artist[] artists = searchArtistsRequest.execute().getItems();

        return Arrays.stream(artists).collect(Collectors.toList());
    }

}