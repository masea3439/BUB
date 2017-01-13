/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplace;

import static jdk.nashorn.internal.objects.NativeString.indexOf;

/**
 *
 * @author masea3439
 */
public class paragraph {
    
    public paragraph(String iText, String iHtmlText){
        String text = iText;
        String htmlText = iHtmlText;
        getPosition(text, htmlText);
    }
    
    public int getPosition(String text, String htmlText){
        int position = indexOf(htmlText,text);
        System.out.println("POS: "+position+" TXT: "+text);
        return position;     
    }
}
