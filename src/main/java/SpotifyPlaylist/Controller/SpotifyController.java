package SpotifyPlaylist.Controller;

import SpotifyPlaylist.Service.SpotifyService;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.io.IOException;
import java.util.List;

@RestController
public class SpotifyController {
    @Autowired
    private SpotifyService spotifyService;

    @GetMapping("/tracks/{artistName}")
    public List<Track> searchTracksByArtist(@PathVariable String artistName) throws IOException, ParseException, SpotifyWebApiException {
        return spotifyService.searchTracksByArtist(artistName);
    }



}
