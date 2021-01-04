package com.kundi.kundi.service.util;

import com.kundi.kundi.domain.Member;
import org.slf4j.Logger;

import java.util.List;

public class GmailUtil {

    public static boolean isDuplicate(List<Member> gmailUsers, String email, Logger logger) {
        logger.debug("Checking for duplicates of : {} in : {}",email, gmailUsers);
        for (Member user : gmailUsers) {
            String username1 = user.getEmail().split("@")[0];
            String username2 = email.split("@")[0];

            // replace the .
            username1 = username1.replace(".", "");
            username2 = username2.replace(".", "");


            logger.debug("username1 = {}, username2 = {}, isSimilar = {}", username1, username2, username1.equalsIgnoreCase(username2));

            if (username1.equalsIgnoreCase(username2)) {
                return true;
            }
        }
        return false;
    }
}
