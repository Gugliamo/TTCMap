
package graph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;

/**
 *
 * @author Alexander Guglenko
 */
public class GraphDrawing extends javax.swing.JFrame {

  
  private Graph<String> graph = Graph.builder();
  private ArrayList<Ellipse2D.Double> ellipseList = new ArrayList<Ellipse2D.Double>();
  private ArrayList<Ellipse2D.Double> pathList = new ArrayList<Ellipse2D.Double>();
  private ArrayList<Line2D.Double> lineList = new ArrayList<Line2D.Double>();
  private Color defaultColor=Color.white;
  private Color pathColor = Color.ORANGE;
  private Color lineColor=Color.black;
  static JLabel startLabel;
    

    public GraphDrawing() {
        initComponents();

    }
    
    //method handling input of all stations to ellipseList ArrayList from graph 
    public void createStations(double x, double y){
        Ellipse2D.Double e = new Ellipse2D.Double(x*50, y*50, 20, 20);
        ellipseList.add(e);
    }
    
    //method handling input of path stations to pathList ArrayList
    public void createPath(double x, double y){
        Ellipse2D.Double e = new Ellipse2D.Double(x*50, y*50, 20, 20);
        pathList.add(e);
    }
    
    //method handling creation of edges in lineList arrayList
    public void createLine(double x1, double y1, double x2, double y2){
        Line2D.Double e = new Line2D.Double(x1*50+10, y1*50+10, x2*50+10, y2*50+10);
        lineList.add(e);
    }
    

    
    public void paint(Graphics g){

        //create a list of names of all vertices
        Iterable<String> nameList = graph.getAllVertices();
        
        //compare all vertices in graph to determine which edges to create
        for(String e : nameList){
            for(String f : nameList){
                if(graph.isAdjacent(e, f)){//if vertices are adjacent, create line
                    createLine(graph.getX(e),graph.getY(e), graph.getX(f), graph.getY(f));
                }
            }
        }

        //loop through list of vertices to create ellipse objects
        for(String e : nameList){
            createStations(graph.getX(e), graph.getY(e));
        }    
        
        //start of draw section
        Graphics2D g2=(Graphics2D)g;
        
        //draw out all lines in lineList arrayList
        for(Line2D e: lineList){
            g2.setColor(lineColor);
            g2.draw(e);
        }
        //draw out all vertices as white circles
        for(Ellipse2D e: ellipseList){
            g2.setColor(defaultColor);
            g2.fill(e);
        }
        
        //draw out path as orange circles
        for(Ellipse2D e: pathList){
            g2.setColor(pathColor);
            g2.fill(e);
        }
        
        //drawing station names
        g2.setColor(Color.black);
        g2.drawString("Ossington", 30, 240);
        g2.drawString("Christie", 90, 290);
        g2.drawString("Bathurst", 140, 240);
        g2.drawString("Spadina", 180, 290);
        g2.drawString("St George", 230, 240);
        g2.drawString("Bay", 300, 290);
        g2.drawString("Bloor-Yonge", 365, 285);
        g2.drawString("Sherbourne", 380, 240);
        g2.drawString("Castle Frank", 440, 285);
        g2.drawString("Dupont", 225, 210);
        g2.drawString("St Clair West", 180, 160);
        g2.drawString("Rosedale", 290, 215);
        g2.drawString("Summerhill", 375, 165);
        g2.drawString("Wellesley", 375, 315);
        g2.drawString("College", 375, 365);
        g2.drawString("Dundas", 375, 415);
        g2.drawString("Queen", 375, 465);
        g2.drawString("King", 375, 515);
        g2.drawString("Union", 325, 565);
        g2.drawString("St Andrew", 190,515);
        g2.drawString("Osgoode", 195,465);
        g2.drawString("St Patrick", 195,415);
        g2.drawString("Queen's Park", 175,365);
        g2.drawString("Museum", 200,315);
        
        g2.dispose();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        startField = new javax.swing.JTextField();
        destField = new javax.swing.JTextField();
        destLabel = new javax.swing.JLabel();
        goButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startField.setText("Ossington");

        destField.setText("Union");
        destField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destFieldActionPerformed(evt);
            }
        });

        destLabel.setText("Destination");

        goButton.setText("Go!");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Start");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(destLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(destField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(goButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destLabel))
                .addGap(18, 18, 18)
                .addComponent(goButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetButton)
                .addContainerGap(442, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed

        //clear path list and redraw in case reset was not pressed
        pathList.clear();
        this.repaint();
        
        //grab user input and create a Set consisting of station names along path
        Set<String> path = graph.BFS(graph, startField.getText(), destField.getText());
        //input Set into path ArrayList
        for(String e : path){
            createPath(graph.getX(e), graph.getY(e));
        } 
        this.repaint();    

        
        
    }//GEN-LAST:event_goButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        //set start and end textFields to blank
        startField.setText("");
        destField.setText("");
        //clear entires in pathList and repaint for all white circles
        pathList.clear();
        this.repaint();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void destFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraphDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphDrawing().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField destField;
    private javax.swing.JLabel destLabel;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField startField;
    // End of variables declaration//GEN-END:variables
}
