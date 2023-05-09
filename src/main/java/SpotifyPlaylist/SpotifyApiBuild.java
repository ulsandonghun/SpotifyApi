package SpotifyPlaylist;

import com.neovisionaries.i18n.CountryCode;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchArtistsRequest;

public class SpotifyApiBuild {
    private static final String clientId = "f44ba55629874250bddde56310980a50";
    private static final String clientSecret = "c7446a870f4b4e399078cc75eb30b5fd";
    private static SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId)
            .setClientSecret(clientSecret).build();
    private static final String q = "Abba";


    private static final SearchArtistsRequest searchArtistsRequest = spotifyApi.searchArtists(q)
//          .market(CountryCode.SE)
//          .limit(10)
//          .offset(0)
//          .includeExternal("audio")
            .build();

    public static void searchArtists_Sync() {
        try {
            final Paging<Artist> artistPaging = searchArtistsRequest.execute();

            System.out.println("Total: " + artistPaging.getTotal());
        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void searchArtists_Async() {
        try {
            final CompletableFuture<Paging<Artist>> pagingFuture = searchArtistsRequest.executeAsync();

            // Thread free to do other tasks...

            // Example Only. Never block in production code.
            final Paging<Artist> artistPaging = pagingFuture.join();

            System.out.println("Total: " + artistPaging.getTotal());
        } catch (CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        } catch (CancellationException e) {
            System.out.println("Async operation cancelled.");
        }
    }

    public static void main(String[] args) {
        searchArtists_Sync();
        searchArtists_Async();
    }
}