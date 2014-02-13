package henkilostokysely;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import henkilostokysely.domain.Kysely;
import henkilostokysely.domain.Kysymys;
import henkilostokysely.domain.Vastaaja;
import henkilostokysely.domain.Vastaustyyppi;
import henkilostokysely.tallennus.VastaustenTallentaja;
import java.awt.Dimension;
import javax.swing.JFrame;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import henkilostokysely.domain.Kyselysailio;
import henkilostokysely.gui.Kayttoliittyma;
import henkilostokysely.sna.Kaavio;
import henkilostokysely.sna.Linkki;
import henkilostokysely.sna.Noodi;
import javax.swing.SwingUtilities;

/**
 *
 * @author Miska
 */
public class App {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

//        DirectedSparseGraph g = new DirectedSparseGraph();
//
//
//        Noodi n1 = new Noodi(1);
//        Noodi n2 = new Noodi(2);
//        Noodi n3 = new Noodi(3);
//        Noodi n4 = new Noodi(4);
//        Noodi n5 = new Noodi(5);
//
//
//        g.addEdge(new Linkki(2.0, 48), n1, n2, EdgeType.DIRECTED); // This method
//        g.addEdge(new Linkki(2.0, 48), n2, n3, EdgeType.DIRECTED);
//        g.addEdge(new Linkki(2.0, 48), n3, n5, EdgeType.DIRECTED);
//        g.addEdge(new Linkki(2.0, 48), n5, n4, EdgeType.DIRECTED); // or we can use
//        g.addEdge(new Linkki(2.0, 48), n4, n2); // In a directed graph the
//        g.addEdge(new Linkki(2.0, 48), n3, n1); // first node is the source
//        g.addEdge(new Linkki(2.0, 48), n2, n5);// and the second the destination
//
//        VisualizationImageServer vs =
//                new VisualizationImageServer(
//                new CircleLayout(g), new Dimension(200, 200));
//
//        JFrame frame = new JFrame();
//        frame.getContentPane().add(vs);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
        
//        Kaavio kaavio = new Kaavio();
//        System.out.println(kaavio.toString());
        
        Kyselysailio sailio = new Kyselysailio();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(sailio);
        SwingUtilities.invokeLater(kayttoliittyma);



    }
}
