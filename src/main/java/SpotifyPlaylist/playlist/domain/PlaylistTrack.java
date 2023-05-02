package SpotifyPlaylist.playlist.domain;

import SpotifyPlaylist.user.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class PlaylistTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playlistTrackId;

    private String trackId; // 스포티파이에서 가져온 곡의 고유 ID

    @ManyToOne(fetch = FetchType.LAZY)
    private Playlist playlist; // 곡이 포함된 플레이리스트

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // 곡을 추가한 사용자

}
