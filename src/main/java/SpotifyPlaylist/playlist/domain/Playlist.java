package SpotifyPlaylist.playlist.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playlistId; // 플레이리스트의 고유 식별자

    private String name; // 플레이리스트의 이름

    private String description; // 플레이리스트에 대한 설명

    private String spotifyPlaylistId; // 스포티파이 플레이리스트의 고유 ID

}
