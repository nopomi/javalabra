/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package henkilostokysely.gui.vastaaminen;

import henkilostokysely.domain.Kysymys;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author mnoponen@cs
 */
public class AvoinVastausKentta extends JPanel{
    private Kysymys kysymys;
    
    public AvoinVastausKentta(Kysymys kysymys){
        super(new GridLayout(1,2));
        this.kysymys=kysymys;
    }
    
}
