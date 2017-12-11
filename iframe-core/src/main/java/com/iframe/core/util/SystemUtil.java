package com.iframe.core.util;

import java.lang.reflect.Method;

/**
 * @author peng.zhang.a
 * @since 17-12-11
 */
public class SystemUtil {

    public static void openUrlInBrowser(String url) {
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Mac OS")) {
                Class<?> fileMgr = Class.forName("com.apple.eio.FileManager");
                Method openURL = fileMgr.getDeclaredMethod("openURL", String.class);
                openURL.invoke(null, url);
            } else if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler \"" + url + "\"");
            } else {
                String[] browsers = {"chrome","firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape"};
                boolean open = false;
                for (String browser : browsers) {
                    if (Runtime.getRuntime().exec(new String[]{"which", browser}).waitFor() == 0) {
                        Runtime.getRuntime().exec(new String[]{browser, url});
                        open = true;
                    }
                }
                if (!open) {
                    throw new Exception("Could not find web browser");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Can not open url:" + url, e);
        }
    }
}

