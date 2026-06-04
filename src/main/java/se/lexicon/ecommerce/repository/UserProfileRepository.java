package se.lexicon.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.ecommerce.model.entity.UserProfile;
import java.util.List;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    // Find a profile by exact nickname
    Optional<UserProfile> findByNickname(String nickname);

    // Search for profiles by a partial phone number
    List<UserProfile> findByPhoneNumberContaining(String phoneNumber);

    // Find profiles where the bio isn't empty
    List<UserProfile> findByBioIsNotNull();

    // Find profiles where the nickname starts with a specific prefix
    List<UserProfile> findByNicknameStartingWith(String prefix);

    // Count profiles where phone number starts w. a specific area code/prefix
    long countByPhoneNumberStartingWith(String prefix);

}
