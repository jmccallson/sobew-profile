package org.sobew;

import org.sobew.entities.ProfileUserEntity;
import org.sobew.repositories.ProfileUserRepo;
import org.springframework.stereotype.Component;

@Component
public class ProfileUserService {
  private static ProfileUserRepo profileUserRepo;
  public ProfileUserService(ProfileUserRepo profileUserRepo){
    this.profileUserRepo = profileUserRepo;
  }
  public ProfileUserEntity create(String sessionId, ProfileUserEntity profileUserEntity){
    Long userId = profileUserRepo.create(profileUserEntity);
    profileUserEntity.setUserId(userId);
    return profileUserEntity;
  }

}
