/**
 * Copyright (C) 2011  JTalks.org Team
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.jtalks.common.web.dto.user;

import org.joda.time.DateTime;
import org.jtalks.common.model.entity.User;
import org.jtalks.common.web.validation.ImageFormats;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * DTO for {@link User} object
 * <p/>
 * Date: 15.09.11
 * Time: 21:44
 *
 * @author Dmitriy Butakov
 * @author Dmitry Sokolov
 */
public class UserViewDto {
    private String firstName;
    private String lastName;
    private String username;
    private String encodedUsername;
    private String email;
    private DateTime lastLogin;
    private MultipartFile avatar;

    /**
     * Constructor which fill DTO fields from User entity
     *
     * @param user User entity
     */
    public UserViewDto(User user) {
        firstName = user.getFirstName();
        lastName = user.getLastName();
        username = user.getUsername();
        encodedUsername = user.getEncodedUsername();
        email = user.getEmail();
        lastLogin = user.getLastLogin();
        avatar = new MockMultipartFile("avatar", "", ImageFormats.JPG.getContentType(), user.getAvatar());
    }

    /**
     * Get user's first name
     *
     * @return First name of user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get user's last name
     *
     * @return Last name of user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get username
     *
     * @return username of user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get encoded username
     *
     * @return encoded username of user
     */
    public String getEncodedUsername() {
        return encodedUsername;
    }

    /**
     * Get email
     *
     * @return user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get last login date
     *
     * @return user's date of last login
     */
    public DateTime getLastLogin() {
        return lastLogin;
    }

    /**
     * Get user's avatar
     *
     * @return user's avatar
     */
    public MultipartFile getAvatar() {
        return avatar;
    }

    /**
     * Checks does user have an avatar
     *
     * @return does user have an avatar
     */
    public boolean isAvatarExist() {
        return avatar != null && avatar.getSize() > 0;
    }
}