package com.kundi.kundi.service.util;

public class AuthTemplateUtil {
    public static String getAccountCreationEmail(String name, String activationLink) {
        return "<!doctype html>" +
            "<html>" +
            "<head> <meta name=\"viewport\" content=\"width=device-width\"> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <title>Activation Email</title> " +
            "<style>#outer-table{background-color: #f1f3f4; font-family: CenturyGothicStd, \"Century Gothic\", CenturyGothic, AppleGothic, sans-serif !important; line-height: 20px; color: #202124; width: 100%;}#content-data{width: 500px; margin: auto; background-color: white; padding: 20px; border-radius: 8px;}#logo-table{width: 100%;}.ext-link{color: white !important; background-color: #18224B; padding: 10px 20px; text-decoration: none; border-radius: 50px; text-transform: uppercase; font-size: small; font-weight: 600; letter-spacing: 1px;}#footer{color: #80868B; font-size: small;}</style>" +
            "</head>" +
            "<body> <table id=\"outer-table\"> <tbody> <th> <td> <p>&nbsp;</p></td></th> <tr> <td colspan=\"1\"></td><td colspan=\"1\" id=\"content-data\"> <table id=\"logo-table\"> <tbody> <tr> <td colspan=\"1\"> <img id=\"mulika-logo\" src=\"http://51.15.233.87:9080/assets/mulika_wordmark.png\" alt=\"Kundi\" width=150px/> </td><td align=\"right\" colspan=\"1\"> <img id=\"meliora-logo\" src=\"http://51.15.233.87:9080/assets/Meliora.png\" width=\"150px\"/> </td></tr></tbody> </table> <hr/> " +
            "<h3> Hello " + name + ", welcome to Kundi. </h3> " +
            "<p> Click the link below to activate your account and set your password. </p><br/> " +
            "<p align=center> <a class=\"ext-link\" href=\"" + activationLink + "\">Activate account</a> </p><br/> " +
            "<p> If you cannot click the link, copy the link below and paste in your browser. </p><p> <a href=\"" + activationLink + "\">" + activationLink + "</a> </p>" +
            "<p> <i><strong>NOTE:</strong> This link is valid for for the next <strong>48 hours.</strong></i> </p><p> <strong>Don't know why you're getting this email? </strong> <br/> Someone has registered an account in Kundi with this email.<br/> If you do not wish to maintain your account with us, ignore this email and the account will be deleted in 48 hours. </p><hr/> <p id=\"footer\" align=center> Meliora Technologies Limited, Ngara Road Mellow Heights, First Floor A4 A </p></td><td colspan=\"1\"></td></tr><th> <td> <p>&nbsp;</p></td></th> </tbody> </table></body></html>";
    }

    public static String getPasswordResetEmail(String name, String resetLink) {
        return "<!doctype html>" +
            "<html>" +
            "<head> <meta name=\"viewport\" content=\"width=device-width\"> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <title>Activation Email</title> " +
            "<style>#outer-table{background-color: #f1f3f4; font-family: CenturyGothicStd, \"Century Gothic\", CenturyGothic, AppleGothic, sans-serif !important; line-height: 20px; color: #202124; width: 100%;}#content-data{width: 500px; margin: auto; background-color: white; padding: 20px; border-radius: 8px;}#logo-table{width: 100%;}.ext-link{color: white !important; background-color: #18224B; padding: 10px 20px; text-decoration: none; border-radius: 50px; text-transform: uppercase; font-size: small; font-weight: 600; letter-spacing: 1px;}#footer{color: #80868B; font-size: small;}</style>" +
            "</head>" +
            "<body> <table id=\"outer-table\"> <tbody> <th> <td><p>&nbsp;</p></td></th> <tr> <td colspan=\"1\"></td><td colspan=\"1\" id=\"content-data\"> <table id=\"logo-table\"> <tbody> <tr> <td colspan=\"1\"> <img id=\"mulika-logo\" src=\"http://51.15.233.87:9080/assets/mulika_wordmark.png\" alt=\"Kundi Project\" width=150px/> </td><td align=\"right\" colspan=\"1\"> <img id=\"meliora-logo\" src=\"http://51.15.233.87:9080/assets/Meliora.png\" width=\"150px\"/> </td></tr></tbody> </table> <hr/> " +
            "<h3> Hello " + name + ", welcome Kundi. </h3> " +
            "<p> Click the link below to set your new account password. </p><br/> <p align=center> <a class=\"ext-link\" href=\"" + resetLink + "\">Reset Password</a> </p><br/> " +
            "<p> If you cannot click the link, copy the link below and paste in your browser. </p><p> <a href=\"" + resetLink + "\">" + resetLink + "</a> </p>" +
            "<p> <i><strong>NOTE:</strong> This link is valid for for the next <strong>1 hour.</strong></i> </p><p> <strong>Don't know why you're getting this email? </strong> <br/> A password reset has been requested from this worry. In this case, don't worry, your account is safe. Just keep using your credentials to sign in and ignore this email.</p><hr/> <p id=\"footer\" align=center> Meliora Technologies Limited, Ngara Road Mellow Heights, First Floor A4 A </p></td><td colspan=\"1\"></td></tr><th> <td><p>&nbsp;</p></td></th> </tbody> </table></body></html>";

    }
}
