package es.cifpcm.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Josué Ramírez
 */
public class ServletUtils {

  public static Cookie getCookie(HttpServletRequest request, String cookieName) {
    if (request.getCookies() == null) {
      return null;
    }
    for (Cookie cookie : request.getCookies()) {
      if (cookie.getName().equalsIgnoreCase(cookieName)) {
        return cookie;
      }
    }
    return null;
  }

}
