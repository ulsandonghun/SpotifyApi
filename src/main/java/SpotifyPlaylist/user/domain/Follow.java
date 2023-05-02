package SpotifyPlaylist.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User follower; // 팔로우를 하는 사용자

    @ManyToOne(fetch = FetchType.LAZY)
    private User following; // 팔로우 당하는 사용자

}
