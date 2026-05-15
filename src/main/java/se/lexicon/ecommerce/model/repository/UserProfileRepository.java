package se.lexicon.ecommerce.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.ecommerce.model.entity.UserProfile;
import java.util.List;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    // Find a profile by exact nickname
    Optional<UserProfile> findByNickname(String nickname);

    // Search for profiles where phone number contains a specific sequence
    List<UserProfile> findByPhoneNumberContaining(String phoneNumber);
}
