package gettothepoint.unicatapi.common.security.oauth2.client.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class GoogleOAuth2UserInfo implements OAuth2UserInfo {

    private final Map<String, Object> attributes;

    @Setter
    @Getter
    private UUID memberId;

    @Override
    public String getId() {
        return (String) attributes.get("sub");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getPicture() {
        return (String) attributes.get("picture");
    }

    @Override
    public Map<String, Object> getAttributes() {
        return Map.of(
                "id", getId(),
                "email", getEmail(),
                "name", getName(),
                "picture", getPicture(),
                "memberId", getMemberId()
        );
    }
}