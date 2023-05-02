package SpotifyPlaylist.user.domain;

import SpotifyPlaylist.playlist.domain.Playlist;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private Long kakaoId; // 카카오 로그인 API에서 할당된 사용자의 고유 식별자

    private String accessToken; // 카카오 API를 사용하기 위한 엑세스 토큰

    private String refreshToken; // 카카오 API의 엑세스 토큰을 새로 고침하기 위한 리프레시 토큰

    private String email; // 사용자의 이메일 주소

    private String nickname; // 사용자의 별명

    private String oneLineIntroduction; // 유저 한 줄 소개

    private String profileImage; //  사용자 프로필 이미지의 URL

    @OneToMany(mappedBy = "member", cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    private List<Playlist> userPlaylist = new ArrayList<>();

}
