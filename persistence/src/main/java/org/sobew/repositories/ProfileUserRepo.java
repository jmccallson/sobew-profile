package org.sobew.repositories;

import org.sobew.entities.ProfileUserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProfileUserRepo {
  private final JdbcTemplate jdbcTemplate;

  public ProfileUserRepo(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
  }

  public Long create(ProfileUserEntity profileUserEntity){
    Long userId;
    String sql = "insert into profile_user ( " +
      "user_id, " +
      "contact_name, " +
      "contact_name_lc, " +
      "create_date," +
      "update_date, " +
      "login_name, " +
      "login_name_lc, " +
      "first_name, " +
      "first_name_nls, " +
      "last_name, " +
      "last_name_nls, " +
      "display_name, " +
      "email, " +
      "email_lc, " +
      "email_verify, " +
      "country, " +
      "deleted_date, " +
      "account_type, " +
      "enabled, " +
      "phone_number) values(?,?,Lower(?),?,?,?,Lower(?),?,?,?,?,?,?,Lower(?),?,?,?,?,?,?)";

    userId = jdbcTemplate.queryForObject("select nextval('SEQ_PROFILE_USER')", Long.class);
    jdbcTemplate.update(
      sql,
      userId,
      profileUserEntity.getContactName(),
      profileUserEntity.getContactName(),
      profileUserEntity.getCreateDate(),
      profileUserEntity.getUpdateDate(),
      profileUserEntity.getLoginName(),
      profileUserEntity.getLoginName(),
      profileUserEntity.getFirstName(),
      profileUserEntity.getFirstNameNls(),
      profileUserEntity.getLastName(),
      profileUserEntity.getLastNameNls(),
      profileUserEntity.getDisplayName(),
      profileUserEntity.getEmail(),
      profileUserEntity.getEmail(),
      profileUserEntity.getEmailVerify(),
      profileUserEntity.getCountry(),
      profileUserEntity.getDeletedDate(),
      profileUserEntity.getAccountType(),
      profileUserEntity.getEnabled()
    );
    return userId;
  }

  static final class ProfileUserMapper implements RowMapper<ProfileUserEntity>{
    @Override
    public ProfileUserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
      ProfileUserEntity profileUserEntity = new ProfileUserEntity();
      profileUserEntity.setUserId(resultSet.getLong("USER_ID"));
      profileUserEntity.setContactName(resultSet.getString("CONTACT_NAME"));
      profileUserEntity.setContactNameLc(resultSet.getString("CONTACT_NAME_LC"));
      profileUserEntity.setCreateDate(resultSet.getTimestamp("CREATE_DATE"));
      profileUserEntity.setUpdateDate(resultSet.getTimestamp("UPDATE_DATE"));
      profileUserEntity.setLoginName(resultSet.getString("LOGIN_NAME"));
      profileUserEntity.setLoginNameLc(resultSet.getString("LOGIN_NAME_LC"));
      profileUserEntity.setFirstName(resultSet.getString("FIRST_NAME"));
      profileUserEntity.setFirstNameNls(resultSet.getString("FIRST_NAME_LC"));
      profileUserEntity.setLastName(resultSet.getString("LAST_NAME"));
      profileUserEntity.setLastNameNls(resultSet.getString("LAST_NAME_LC"));
      profileUserEntity.setDisplayName(resultSet.getString("DISPLAY_NAME"));
      profileUserEntity.setEmail(resultSet.getString("EMAIL"));
      profileUserEntity.setEmailLc(resultSet.getString("EMAIL_LC"));
      profileUserEntity.setEmailVerify(resultSet.getBoolean("EMAIL_VERIFY"));
      profileUserEntity.setCountry(resultSet.getString("COUNTRY"));
      profileUserEntity.setDeletedDate(resultSet.getTimestamp(""));
      profileUserEntity.setAccountType(resultSet.getString("ACCOUNT_TYPE"));
      profileUserEntity.setEnabled(resultSet.getBoolean("ENABLED"));
      return profileUserEntity;
    }
  }
}


