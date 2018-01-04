/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagging;

/**
 *
 * @author admin
 */
public class Pagger {

    public static String generate(int current_page, int gap, int total_page, String address) {
        String result = "";
        if (current_page > gap + 1) {
            result += "  " + generateHyperLink(address + "?page=1", "First");
        }
        for (int i = current_page - gap; i < current_page; i++) {
            if (i > 0) {
                result += "  " + generateHyperLink(address + "?page=" + i, i + "");
            }
        }
        result += "<b>" + current_page + "</b>";
        for (int i = current_page + 1; i < current_page + gap; i++) {
            if (i < total_page) {
                result += "  " + generateHyperLink(address + "?page=" + i, i + "");
            }
        }
        if (current_page < total_page - gap) {
            result += "  " + generateHyperLink(address + "?page=" + total_page, "Last");
        }
        return result;
    }

    public static String generateHyperLink(String link, String value) {
        return "<a href=\"" + link + "\">" + value + "</a>";
    }
}
