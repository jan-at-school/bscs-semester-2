
import javax.swing.ImageIcon;
import javax.swing.JLabel;




/**
 *
 * @author ajan.bscs16seecs
 */
public class HangMaan extends javax.swing.JFrame {

   
    public HangMaan() {
        initComponents();
        pic= new ImageIcon(getClass().getResource("1.PNG"));
        drawing.setIcon(pic);
        
        
        for(int i=0; i<solution.length();i++){
            displayString+="-";
        }
    }

    public void updateDrawing(int i){
        
        pic= new ImageIcon(getClass().getResource(i+".PNG"));
        drawing.setIcon(pic);
        
        
    }
    
    static String[]  options= new String[]{"JAWAD", "WAHAB", "MEMON", "RAFAQAT", "KHAN", "ULLAH", "JAN", "KHATTI", "KHALID", "HUZAIFAH", "ASIF", "BAKHT", "JAVED", "AKRAM", "AHAD", "AZWAR", "SAEED", "MASROOR", "HARIS","MUSTAFA", "JAVAID", "KHALID", "MUGHEES", "SHARJEEL", "AHSEN", "MUSTAFA", "ABID", "GHANI", "DAR", "SHAKEEL", "KHAN", "KHAQAN", "ZUBAIR", "NAQVI", "ISMAIL", "AHMAD", "CHAUDHARY", "YASEEN", "CHAUDHARY"};
    //static String solution=options[(int)Math.random()*options.length];
    String displayString="";
    String solution = "jan";
    
    public  String newSolution(char a){
        String neww= "";
        for(int i=0;i<solution.length();i++){
            if(solution.charAt(i)== a ){
                neww +=(a+"").toUpperCase();
                
            }
            else{
                neww+=displayString.charAt(i);
            }
        }
        return neww;
    }
    public boolean matched(char a){
       for(int i=0; i<solution.length();i++){
                if(a==solution.charAt(i)){
                    return true;
                }
       }
       return false;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayTextView = new javax.swing.JLabel();
        inputField = new javax.swing.JTextField();
        drawing = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        displayTextView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayTextView.setText("_ _ _ _ ");

        inputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFieldActionPerformed(evt);
            }
        });

        drawing.setBackground(new java.awt.Color(255, 255, 255));
        drawing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(inputField)
                    .addComponent(displayTextView, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(drawing, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(displayTextView, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
            .addComponent(drawing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFieldActionPerformed
        inputField.removeAll();
        char input = inputField.getText().charAt(0);
        if(displayString==solution){
               return;
        }
        if(matched(input)){
            
            displayString= newSolution(input);
            displayTextView.setText(displayString);
            if(displayString==solution){
                displayTextView.setText("YOU WON!!!!");
            }
        }
        else{
            counter++;
            updateDrawing(counter);
        }
    }//GEN-LAST:event_inputFieldActionPerformed

    
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
            java.util.logging.Logger.getLogger(HangMaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HangMaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HangMaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HangMaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HangMaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel displayTextView;
    private javax.swing.JLabel drawing;
    private javax.swing.JTextField inputField;
    // End of variables declaration//GEN-END:variables
    private ImageIcon pic;
    int counter=1;
    
    
}
