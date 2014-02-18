/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Kysymys;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mnoponen@cs
 */
public class KolmiKentta extends JPanel{
    
    public KolmiKentta(Kysymys kysymys){
        super(new GridLayout(3,1,5,0));
        add(new JTextField());
        add(new JTextField());
        add(new JTextField());
    }
    
}
