package SpotifyPlaylist.spotifyconfig;

import java.io.IOException;
import java.util.List;
import org.apache.hc.core5.http.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Track;

@RestController
public class SpotifyController1 {
    SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(SpotifyConfig.accessToken())
            //accessToken()은 SpotifyConfig 에서 발급함
            .build();
    @GetMapping("/{trackname}")
    public List<Track> searchTracksByArtist(@PathVariable String trackname) throws IOException, ParseException, SpotifyWebApiException {


        return ;
    }

}
