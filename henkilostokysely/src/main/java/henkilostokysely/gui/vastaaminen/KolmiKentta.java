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
import javax.swing.JTextField;

/**
 *
 * @author mnoponen@cs
 */
public class KolmiKentta extends JPanel implements VastausKentta{
    
    private final Kysymys kysymys;
    private JTextField vastausKentta1;
    private JTextField vastausKentta2;
    private JTextField vastausKentta3;
    
    
    public KolmiKentta(Kysymys kysymys){
        super(new GridLayout(3,2,5,0));
        this.kysymys=kysymys;
        
        luoKomponentit();
    }
    
    private void luoKomponentit(){
        JLabel kysymysLabel = new JLabel(kysymys.getKysymys());
        vastausKentta1=new JTextField();
        vastausKentta2=new JTextField();
        vastausKentta3=new JTextField();
        
        add(kysymysLabel);
        add(vastausKentta1);
        add(new JLabel(""));
        add(vastausKentta2);
        add(new JLabel(""));
        add(vastausKentta3);
        
    }

    @Override
    public String getVastaus() {
        return vastausKentta1.getText()+","+vastausKentta2.getText()+","+
                vastausKentta3.getText();
    }
    
}
