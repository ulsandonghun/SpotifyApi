package SpotifyPlaylist;

import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
public class SpotifyController {
    @Autowired
    private SpotifyService spotifyService;

    @GetMapping("/tracks/{artistName}")
    public List<Track> searchTracksByArtist(@PathVariable String artistName) throws IOException, ParseException, SpotifyWebApiException {
        return spotifyService.searchTracksByArtist(artistName);
    }


}
