/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Kysymys;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author mnoponen@cs
 */
public class AvoinVastausKentta extends JPanel implements VastausKentta{
    private final Kysymys kysymys;
    private JTextArea vastaus;
    
    public AvoinVastausKentta(Kysymys kysymys){
        super(new GridLayout(1,2));
        this.kysymys=kysymys;
        luoKomponentit();
    }
    
    private void luoKomponentit(){
        this.vastaus=new JTextArea();
        vastaus.setLineWrap(true);
        vastaus.setWrapStyleWord(true);
        JLabel kysymysLabel = new JLabel(kysymys.getKysymys());
        add(kysymysLabel);
        add(vastaus);
    }

    @Override
    public String getVastaus() {
        if(this.vastaus.getText().isEmpty()){
            System.out.println("avoin");
            return null;
        }
        return this.vastaus.getText();
    }
    
}
